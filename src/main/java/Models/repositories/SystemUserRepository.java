package Models.repositories;


import Models.entities.SystemUsers;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@Repository
public interface SystemUserRepository extends JpaRepository<SystemUsers, String> {

    Optional<SystemUsers> findByUserId(String userId);

    Optional<SystemUsers> findByUserIdAndStatus(String userId, String status);

    @Modifying
    @Transactional
    @Query("UPDATE SystemUsers u SET u.failedAttempts = u.failedAttempts + 1 WHERE u.userId = :userId")
    void incrementFailedAttempts(@Param("userId") String userId);

    @Modifying
    @Transactional
    @Query("UPDATE SystemUsers u SET u.failedAttempts = 0, u.lastLogin = :loginTime WHERE u.userId = :userId")
    void resetFailedAttemptsAndUpdateLogin(@Param("userId") String userId, @Param("loginTime") LocalDateTime loginTime);
}