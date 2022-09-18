package com.example.demo.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
/** Interface reponsible for data access */
@Repository
public interface AccountRepository extends  JpaRepository<Account, UUID>{
}

