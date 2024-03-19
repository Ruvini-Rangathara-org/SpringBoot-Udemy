package com.example.pointcutcombine.dao;

import com.example.pointcutcombine.dto.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {
    private String name;
    private String serviceCode;

    @Override
    public void addAccount() {
        System.out.println(getClass() + " : DOING MY DB WORK: ADDING AN ACCOUNT");
    }

    @Override
    public void deleteAccount(Account account, boolean vipFlag) {
        System.out.println(getClass() + " : DOING MY DB WORK: DELETING AN ACCOUNT");
    }

    @Override
    public void setName(String name) {
        System.out.println(getClass() + " : in setName()");
        this.name = name;
    }

    @Override
    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + " : in setServiceCode()");
        this.serviceCode = serviceCode;
    }

    @Override
    public String getName() {
        System.out.println(getClass() + " : in getName()");
        return name;
    }

    @Override
    public String getServiceCode() {
        System.out.println(getClass() + " : in getServiceCode()");
        return serviceCode;
    }

}
