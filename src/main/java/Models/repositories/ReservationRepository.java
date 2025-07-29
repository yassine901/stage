package Models.repositories;

import Models.entities.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationEntity, Long> {


    List<ReservationEntity> findByAccountNumber(String accountNumber);

    List<ReservationEntity> findByStatus(String status);

    List<ReservationEntity> findByOpvReference(String opvReference);

    List<ReservationEntity> findByOperationType(String operationType);

    List<ReservationEntity> findByRuleCode(String ruleCode);

    List<ReservationEntity> findByCreatedAtBetween(LocalDateTime startDate, LocalDateTime endDate);

    List<ReservationEntity> findByAccountNumberAndStatus(String accountNumber, String status);

    List<ReservationEntity> findByOpvReferenceAndStatus(String opvReference, String status);



    @Query("SELECT r FROM ReservationEntity r ORDER BY r.createdAt DESC")
    List<ReservationEntity> findAllOrderByCreatedAtDesc();


        /**
         * Trouver une réservation par référence d'opération
         */
        Optional<ReservationEntity> findByOperationReference(String operationReference);

        /**
         * ⚠️ MÉTHODE NÉCESSAIRE POUR LA VALIDATION
         * Vérifier si une référence d'opération existe déjà
         */
        boolean existsByOperationReference(String operationReference);

        /**
         * Trouver toutes les réservations pour un compte donné
         */
        List<ReservationEntity> findByAccountNumberOrderByCreatedAtDesc(String accountNumber);

        /**
         * Trouver les réservations par statut
         */
        List<ReservationEntity> findByStatusOrderByCreatedAtDesc(String status);

        /**
         * Trouver les réservations par référence OPV
         */
        List<ReservationEntity> findByOpvReferenceOrderByCreatedAtDesc(String opvReference);

        /**
         * Trouver les réservations par type d'opération
         */
        List<ReservationEntity> findByOperationTypeOrderByCreatedAtDesc(String operationType);

        /**
         * Trouver les réservations par code de règle
         */
        List<ReservationEntity> findByRuleCodeOrderByCreatedAtDesc(String ruleCode);



        /**
         * Trouver les réservations par plage de dates
         */
        List<ReservationEntity> findByCreatedAtBetweenOrderByCreatedAtDesc(LocalDateTime startDate, LocalDateTime endDate);

        /**
         * Trouver les réservations par compte et statut
         */
        List<ReservationEntity> findByAccountNumberAndStatusOrderByCreatedAtDesc(String accountNumber, String status);

        /**
         * Trouver les réservations par OPV et statut
         */
        List<ReservationEntity> findByOpvReferenceAndStatusOrderByCreatedAtDesc(String opvReference, String status);

        /**
         * Trouver toutes les réservations ordonnées par date de création (plus récentes en premier)
         */
        List<ReservationEntity> findAllByOrderByCreatedAtDesc();

        /**
         * Calculer le montant total des réservations par statut
         */
        @Query("SELECT SUM(r.amount) FROM ReservationEntity r WHERE r.status = :status")
        Long getTotalAmountByStatus(@Param("status") String status);

        /**
         * Calculer le montant total des réservations pour un compte
         */
        @Query("SELECT SUM(r.amount) FROM ReservationEntity r WHERE r.accountNumber = :accountNumber AND r.status = :status")
        Long getTotalAmountByAccountAndStatus(@Param("accountNumber") String accountNumber, @Param("status") String status);

        /**
         * Calculer le montant total des réservations pour une OPV
         */
        @Query("SELECT SUM(r.amount) FROM ReservationEntity r WHERE r.opvReference = :opvReference AND r.status != 'CANCELLED'")
        Long getTotalAmountByOpvReference(@Param("opvReference") String opvReference);

        /**
         * Compter les réservations par statut
         */
        @Query("SELECT r.status, COUNT(r) FROM ReservationEntity r GROUP BY r.status")
        List<Object[]> getCountByStatus();

        /**
         * Compter toutes les réservations pour un compte
         */
        Long countByAccountNumber(String accountNumber);

        /**
         * Compter les réservations actives (non annulées) pour un compte
         */
        @Query("SELECT COUNT(r) FROM ReservationEntity r WHERE r.accountNumber = :accountNumber AND r.status != 'CANCELLED'")
        Long countActiveReservationsByAccount(@Param("accountNumber") String accountNumber);



        /**
         * Trouver les réservations par compte dans une période donnée
         */
        @Query("SELECT r FROM ReservationEntity r WHERE r.accountNumber = :accountNumber AND r.createdAt BETWEEN :startDate AND :endDate ORDER BY r.createdAt DESC")
        List<ReservationEntity> findByAccountNumberAndDateRange(
                @Param("accountNumber") String accountNumber,
                @Param("startDate") LocalDateTime startDate,
                @Param("endDate") LocalDateTime endDate
        );

        /**
         * Trouver les réservations en attente (statut spécifique)
         */
        @Query("SELECT r FROM ReservationEntity r WHERE r.status = 'RESERVED' ORDER BY r.createdAt ASC")
        List<ReservationEntity> findPendingReservations();

        /**
         * Trouver les réservations traitées (statut spécifique)
         */
        @Query("SELECT r FROM ReservationEntity r WHERE r.status = 'PROCESSED' ORDER BY r.createdAt DESC")
        List<ReservationEntity> findProcessedReservations();

        /**
         * Trouver les réservations annulées
         */
        @Query("SELECT r FROM ReservationEntity r WHERE r.status = 'CANCELLED' ORDER BY r.createdAt DESC")
        List<ReservationEntity> findCancelledReservations();

        /**
         * Trouver les réservations avec montant supérieur à une valeur
         */
        @Query("SELECT r FROM ReservationEntity r WHERE r.amount > :minAmount ORDER BY r.amount DESC")
        List<ReservationEntity> findReservationsAboveAmount(@Param("minAmount") Long minAmount);

        /**
         * Trouver les réservations anciennes (plus de X jours)
         */
        @Query("SELECT r FROM ReservationEntity r WHERE r.createdAt < :cutoffDate AND r.status = 'RESERVED'")
        List<ReservationEntity> findOldPendingReservations(@Param("cutoffDate") LocalDateTime cutoffDate);



        /**
         * Marquer les réservations comme traitées
         */
        @Modifying
        @Query("UPDATE ReservationEntity r SET r.status = 'PROCESSED', r.updatedAt = :updatedAt WHERE r.id IN :ids")
        int markAsProcessed(@Param("ids") List<Long> ids, @Param("updatedAt") LocalDateTime updatedAt);

        /**
         * Marquer les réservations comme annulées
         */
        @Modifying
        @Query("UPDATE ReservationEntity r SET r.status = 'CANCELLED', r.updatedAt = :updatedAt WHERE r.id IN :ids")
        int markAsCancelled(@Param("ids") List<Long> ids, @Param("updatedAt") LocalDateTime updatedAt);

        /**
         * Mettre à jour le statut d'une réservation par référence
         */
        @Modifying
        @Query("UPDATE ReservationEntity r SET r.status = :status, r.updatedAt = :updatedAt WHERE r.operationReference = :operationReference")
        int updateStatusByOperationReference(@Param("operationReference") String operationReference,
                                             @Param("status") String status,
                                             @Param("updatedAt") LocalDateTime updatedAt);



        /**
         * Statistiques des réservations par période
         */
        @Query("SELECT DATE(r.createdAt), COUNT(r), SUM(r.amount), r.status FROM ReservationEntity r WHERE r.createdAt >= :startDate AND r.createdAt <= :endDate GROUP BY DATE(r.createdAt), r.status ORDER BY DATE(r.createdAt)")
        List<Object[]> getReservationStatsByPeriod(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);

        /**
         * Rapport mensuel des réservations
         */
        @Query("SELECT YEAR(r.createdAt), MONTH(r.createdAt), COUNT(r), SUM(r.amount) FROM ReservationEntity r WHERE r.createdAt >= :startDate GROUP BY YEAR(r.createdAt), MONTH(r.createdAt) ORDER BY YEAR(r.createdAt), MONTH(r.createdAt)")
        List<Object[]> getMonthlyReservationReport(@Param("startDate") LocalDateTime startDate);

        /**
         * Top comptes par nombre de réservations
         */
        @Query("SELECT r.accountNumber, COUNT(r) as count FROM ReservationEntity r GROUP BY r.accountNumber ORDER BY count DESC")
        List<Object[]> getTopAccountsByReservationCount();

        /**
         * Top comptes par montant total réservé
         */
        @Query("SELECT r.accountNumber, SUM(r.amount) as total FROM ReservationEntity r WHERE r.status != 'CANCELLED' GROUP BY r.accountNumber ORDER BY total DESC")
        List<Object[]> getTopAccountsByReservationAmount();



        /**
         * Trouver les doublons potentiels (même compte, même montant, même heure)
         */
        @Query("SELECT r FROM ReservationEntity r WHERE r.accountNumber = :accountNumber AND r.amount = :amount AND r.createdAt >= :startTime AND r.createdAt <= :endTime AND r.id != :excludeId")
        List<ReservationEntity> findPotentialDuplicates(@Param("accountNumber") String accountNumber,
                                                        @Param("amount") Long amount,
                                                        @Param("startTime") LocalDateTime startTime,
                                                        @Param("endTime") LocalDateTime endTime,
                                                        @Param("excludeId") Long excludeId);

        /**
         * Trouver la dernière réservation pour un compte
         */
        @Query("SELECT r FROM ReservationEntity r WHERE r.accountNumber = :accountNumber ORDER BY r.createdAt DESC")
        Optional<ReservationEntity> findLatestByAccount(@Param("accountNumber") String accountNumber);

        /**
         * Vérifier si un compte a des réservations actives
         */
        @Query("SELECT COUNT(r) > 0 FROM ReservationEntity r WHERE r.accountNumber = :accountNumber AND r.status IN ('RESERVED', 'PENDING')")
        boolean hasActiveReservations(@Param("accountNumber") String accountNumber);

        /**
         * Trouver les réservations par pattern de référence
         */
        @Query("SELECT r FROM ReservationEntity r WHERE r.operationReference LIKE :pattern ORDER BY r.createdAt DESC")
        List<ReservationEntity> findByOperationReferencePattern(@Param("pattern") String pattern);

    @Query("SELECT r FROM ReservationEntity r WHERE r.operationReference = :operRef AND r.status = :status")
    Optional<ReservationEntity> findByOperationReferenceAndStatus(
            @Param("operRef") String operRef,
            @Param("status") String status
    );
    }


