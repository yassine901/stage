package Models.repositories;

import Models.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**
 * Repository pour la gestion des clients
 */
@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, String> {

    /**
     * Trouve un client par son ID
     */
    Optional<CustomerEntity> findByCustomerId(String customerId);

    /**
     * Trouve les clients par catégorie
     */
    List<CustomerEntity> findByCategory(String category);

    /**
     * Trouve les clients par marché
     */
    List<CustomerEntity> findByMarket(String market);

    /**
     * Recherche par nom (like)
     */
    @Query("SELECT c FROM CustomerEntity c WHERE c.designation LIKE %:name%")
    List<CustomerEntity> findByDesignationContaining(@Param("name") String name);

    /**
     * Trouve les clients par ville
     */
    List<CustomerEntity> findByCity(String city);

    /**
     * Trouve les clients par nationalité
     */
    List<CustomerEntity> findByNationality(String nationality);
}