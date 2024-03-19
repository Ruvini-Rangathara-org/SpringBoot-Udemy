package com.example.pointcutanymethod.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO {
    @Override
    public void addAccount() {
        System.out.println(getClass() + " : DOING MY DB WORK: ADDING A MEMBER");
    }

    @Override
    public void updateAccount() {
        System.out.println(getClass() + " : DOING MY DB WORK: UPDATING A MEMBER");
    }

    @Override
    public void deleteAccount() {
        System.out.println(getClass() + " : DOING MY DB WORK: DELETING A MEMBER");
    }

    @Override
    public void searchAccount() {
        System.out.println(getClass() + " : DOING MY DB WORK: SEARCHING A MEMBER");
    }

    @Override
    public void goToSleep() {
        System.out.println(getClass() + " : I'm going to sleep now...");
    }
}
