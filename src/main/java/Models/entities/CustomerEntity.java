package Models.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * Entité Customer - Représente un client
 */
@Entity
@Table(name = "customers")
public class CustomerEntity {

    @Id
    @Column(name = "customer_id", length = 8)
    private String customerId;

    @Column(name = "title", length = 10)
    private String title;

    @Column(name = "designation", length = 100)
    private String designation;

    @Column(name = "category", length = 1)
    private String category;

    @Column(name = "market", length = 10)
    private String market;

    @Column(name = "address", length = 200)
    private String address;

    @Column(name = "city", length = 50)
    private String city;

    @Column(name = "postal_code", length = 10)
    private String postalCode;

    @Column(name = "nationality", length = 5)
    private String nationality;

    @Column(name = "birth_date")
    private String birthDate;

    @Column(name = "phone", length = 20)
    private String phone;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public CustomerEntity() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public CustomerEntity(String customerId, String title, String designation,
                          String category, String market, String address,
                          String city, String postalCode, String nationality, String birthDate) {
        this();
        this.customerId = customerId;
        this.title = title;
        this.designation = designation;
        this.category = category;
        this.market = market;
        this.address = address;
        this.city = city;
        this.postalCode = postalCode;
        this.nationality = nationality;
        this.birthDate = birthDate;
    }

    public String getCustomerId() { return customerId; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDesignation() { return designation; }
    public void setDesignation(String designation) {
        this.designation = designation;
        this.updatedAt = LocalDateTime.now();
    }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getMarket() { return market; }
    public void setMarket(String market) { this.market = market; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getPostalCode() { return postalCode; }
    public void setPostalCode(String postalCode) { this.postalCode = postalCode; }

    public String getNationality() { return nationality; }
    public void setNationality(String nationality) { this.nationality = nationality; }

    public String getBirthDate() { return birthDate; }
    public void setBirthDate(String birthDate) { this.birthDate = birthDate; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    @Override
    public String toString() {
        return "CustomerEntity{" +
                "customerId='" + customerId + '\'' +
                ", designation='" + designation + '\'' +
                ", category='" + category + '\'' +
                ", market='" + market + '\'' +
                '}';
    }
}
