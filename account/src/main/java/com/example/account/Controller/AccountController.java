package com.example.account.Controller;

//Imports, vscode should auto add these as needed
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//import class
import com.example.account.Entity.AccountEntity;
import com.example.account.Repository.AccountRepository;
import java.util.*;

// REST APis controllers
@RestController
public class AccountController {
    
    //Property to hold our repository
    public AccountRepository Account;

    public AccountController(AccountRepository account){
        this.Account= account;
    }

    // Get to /account that returns list of people
    @GetMapping(value="/account")
    public List<AccountEntity> getAccount(){
        return Account.findAll(); // return all accounts
    } 

    // Post to /people, takes in request body which must be of type Person
    @PostMapping("/account")
    public List<AccountEntity> createPerson(@RequestBody AccountEntity newAccount){
        Account.save(newAccount); //creates new person
        return Account.findAll(); // returns all cats
    }

     // put to /people/:id, takes in the body and url param id
     @PutMapping("/account/{id}")
     public List<AccountEntity> updatePerson(@RequestBody AccountEntity updateAccount, @PathVariable Long id){
         // search for the person by id, map over the person, alter them, then save
         Account.findById(id)
             .map(acc -> {
                 acc.setName(updateAccount.getName());
                 acc.setAge(updateAccount.getAge());
                 return Account.save(acc); // save and return edits
             });
 
         return Account.findAll(); // return all people
     }

    // delete request to /people/:id, deletes person based on id param
    @DeleteMapping("/account/{id}")
    public List<AccountEntity> deleteCat(@PathVariable Long id){
        Account.deleteById(id);
        return Account.findAll();
    }
}
