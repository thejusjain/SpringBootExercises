package com.system2.taraperformance.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="user_credentials")
public class Users {

    public Users() {
    }

    public Users(String username, String userType, String accountId, String password) {
        this.username = username;
        this.userType = userType;
        this.accountId = accountId;
        this.password = password;
    }

    @Id
    String username;
    @Column(name = "user_type")
    String  userType;
    @Column(name = "account_id")
    String accountId;
    String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Users{" +
                "username='" + username + '\'' +
                ", userType='" + userType + '\'' +
                ", accountId='" + accountId + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
