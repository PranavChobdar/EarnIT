package com.example.demo.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
/** Interface reponsible for data access */
@Repository
public interface AccountRepository extends  JpaRepository<Account, UUID>{

//  In the query below, Account actually references @Entity Account, not the database directly
    @Query("SELECT a from Account a WHERE a.email = ?1")
    Optional<Account> findAccountByEmail(String email);
}

