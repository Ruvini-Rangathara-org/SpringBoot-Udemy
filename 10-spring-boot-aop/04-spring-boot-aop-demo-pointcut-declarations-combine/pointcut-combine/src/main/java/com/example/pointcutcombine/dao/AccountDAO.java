package com.example.pointcutcombine.dao;

import com.example.pointcutcombine.dto.Account;
public interface AccountDAO {
    void addAccount();
    void deleteAccount(Account account, boolean vipFlag);

    void setName(String name);
    void setServiceCode(String serviceCode);
    String getName();
    String getServiceCode();
}
