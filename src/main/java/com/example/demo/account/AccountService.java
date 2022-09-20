package com.example.demo.account;

import com.example.demo.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public void addNewAccount(Account account) {
        System.out.println(account.toString());
        accountRepository.save(account);
    }
}
