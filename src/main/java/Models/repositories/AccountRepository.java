package Models.repositories;

import Models.entities.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, String> {

    Optional<AccountEntity> findByAccountNumber(String accountNumber);

    List<AccountEntity> findByCustomerId(String customerId);

    List<AccountEntity> findByAccountStatus(String accountStatus);

    @Query("SELECT a FROM AccountEntity a WHERE a.availableBalance > :minBalance")
    List<AccountEntity> findAccountsWithBalanceGreaterThan(@Param("minBalance") Long minBalance);
}