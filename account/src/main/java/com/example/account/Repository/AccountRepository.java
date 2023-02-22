package com.example.account.Repository;


import com.example.account.Entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountEntity,Long>{
    
}

