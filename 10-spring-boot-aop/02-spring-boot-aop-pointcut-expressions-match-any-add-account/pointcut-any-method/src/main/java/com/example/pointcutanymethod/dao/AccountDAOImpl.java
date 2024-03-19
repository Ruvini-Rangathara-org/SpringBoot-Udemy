package com.example.pointcutanymethod.dao;

import com.example.pointcutanymethod.dto.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {
    @Override
    public void addAccount() {
        System.out.println(getClass() + " : DOING MY DB WORK: ADDING AN ACCOUNT");
    }

    @Override
    public boolean updateAccount() {
        System.out.println(getClass() + " : DOING MY DB WORK: UPDATING AN ACCOUNT");
        return true;
    }

    @Override
    public void deleteAccount(Account account, boolean vipFlag) {
        System.out.println(getClass() + " : DOING MY DB WORK: DELETING AN ACCOUNT");
    }

    @Override
    public void searchAccount() {
        System.out.println(getClass() + " : DOING MY DB WORK: SEARCHING AN ACCOUNT");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass() + " : DOING SOME WORK");
        return false;
    }
}
