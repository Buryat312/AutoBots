package com.autobots.java.mobileBanking;

import java.util.UUID;

public abstract class BankAccount {

    public UUID accountNUmber;
    protected double balance;
    public Currency currency;
    Client client;
    Transaction transaction;

    public BankAccount(Currency currency, Client client) {
        this.currency = currency;
        this.client = client;
        this.transaction = new Transaction();
    }

    abstract void deposit(double amount);
    abstract boolean withdraw(double amount);
    void addTransaction(String type, double amount){

    }

    public UUID getAccountNUmber() {
        return accountNUmber;
    }

    public void setAccountNUmber(UUID accountNUmber) {
        this.accountNUmber = accountNUmber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public void callMethod(String methodName, double amount) {

    }

}
