package com.example.demo.account;

import com.example.demo.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AccountService {
    private final AccountRepository accountRepository;
    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> getAccounts(){
        return accountRepository.findAll();

//        return List.of(
//                new Account(
//                        UUID.randomUUID(),1,
//                        "mariam@gamil.com",
//                        "password"
//                        ),
//                new Account(
//                        UUID.randomUUID(), 1,
//                        "popa@gamil.com",
//                        "password"
//                )
//        );
    }

    public void addNewAccount(Account account){
        Optional<Account> accountByEmail = accountRepository.
                findAccountByEmail(account.getEmail());
        if(accountByEmail.isPresent()){
            throw new IllegalStateException("Email is taken!");
        }
        System.out.println(account.toString());
        accountRepository.save(account);
    }

    public void deleteAccount(UUID account_id) {
        boolean exists = accountRepository.existsById(account_id);
        if(!exists){
            throw new IllegalStateException("Account with id" + account_id + "does not exist!");
        }
        accountRepository.deleteById(account_id);
    }
}
