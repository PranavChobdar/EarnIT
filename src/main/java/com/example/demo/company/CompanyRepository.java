package com.example.demo.company;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
/** Interface reponsible for data access */
@Repository
public interface CompanyRepository extends JpaRepository<Company, UUID> {
//    Company findById(UUID id);
}
