package com.example.pointcutdec.dao;

import com.example.pointcutdec.dto.Account;
public interface AccountDAO {
    void addAccount();

    boolean updateAccount();

    void deleteAccount(Account account, boolean vipFlag);

    void searchAccount();

    boolean doWork();
}
