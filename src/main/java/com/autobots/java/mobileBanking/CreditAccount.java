package com.autobots.java.mobileBanking;

import java.time.LocalDateTime;

//4. CreditAccount (наследник BankAccount)
//Счёт с кредитным лимитом до 1000 единиц.
//Разрешено уходить в минус до -1000.
public class CreditAccount extends BankAccount {

    private double creditLimit = -1000;
    public CreditAccount(Currency currency, Client client) { super(currency, client); }

    public void callMethod(String methodName, double amount) {
        if (methodName.equals(OperationType.DEPOSIT.description)) {
            deposit(amount);
            System.out.println(transaction);
        } else if (methodName.equals(OperationType.WITHDRAW.description)) {
            withdraw(amount);
            System.out.println(transaction);
        }
        client.setListOfBankAccounts(this);
    }


    @Override
    void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Insufficient funds ");
        } else {
            balance += amount;
            transaction.setOperationType("DEPOSIT");
            transaction.setOperationSum(amount);
            transaction.setTimestamp(LocalDateTime.now());
        }
    }

    @Override
    boolean withdraw(double amount) {
        boolean res = false;
        if ((balance - amount) < creditLimit) {
            throw new IllegalArgumentException("Insufficient funds for withdraw");
        } else {
            balance -=amount;
            transaction.setOperationType("WITHDRAW");
            transaction.setOperationSum(amount);
            transaction.setTimestamp(LocalDateTime.now());
            res = true;
        }
        return res;
    }

    @Override
    void addTransaction(String type, double amount) {
        callMethod(type, amount);
    }

    @Override
    public String toString() {
        return "CreditAccount{" +
                "creditLimit=" + creditLimit +
                ", accountNUmber=" + accountNUmber +
                ", balance=" + balance +
                ", currency=" + currency +
                ", client=" + client +
                ", transaction=" + transaction +
                '}';
    }
}
