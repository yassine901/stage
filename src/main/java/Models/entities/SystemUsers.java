package Models.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "system_users")
public class SystemUsers {

    @Id
    @Column(name = "user_id")
    private String userId;

    @Column(name = "password")
    private String password;

    @Column(name = "user_type")
    private String userType;

    @Column(name = "status")
    private String status;

    @Column(name = "failed_attempts")
    private Integer failedAttempts = 0;

    @Column(name = "description")
    private String description;

    @Column(name = "last_login")
    private LocalDateTime lastLogin;

    // Constructors
    public SystemUsers() {}

    public SystemUsers(String userId, String password, String userType, String status) {
        this.userId = userId;
        this.password = password;
        this.userType = userType;
        this.status = status;
        this.failedAttempts = 0;
    }

    // Getters and Setters
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getUserType() { return userType; }
    public void setUserType(String userType) { this.userType = userType; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Integer getFailedAttempts() { return failedAttempts; }
    public void setFailedAttempts(Integer failedAttempts) { this.failedAttempts = failedAttempts; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public LocalDateTime getLastLogin() { return lastLogin; }
    public void setLastLogin(LocalDateTime lastLogin) { this.lastLogin = lastLogin; }

    @Override
    public String toString() {
        return "SystemUsers{" +
                "userId='" + userId + '\'' +
                ", userType='" + userType + '\'' +
                ", status='" + status + '\'' +
                ", failedAttempts=" + failedAttempts +
                '}';
    }
}
