package com.example.pointcutanymethod.dao;

import com.example.pointcutanymethod.dto.Account;

public interface AccountDAO {
    void addAccount();

    boolean updateAccount();

    void deleteAccount(Account account, boolean vipFlag);

    void searchAccount();

    boolean doWork();
}
