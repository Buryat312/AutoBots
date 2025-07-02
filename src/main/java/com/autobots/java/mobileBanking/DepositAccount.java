package com.autobots.java.mobileBanking;

import java.time.LocalDateTime;

public class DepositAccount extends BankAccount {

    public DepositAccount(Currency currency, Client client) { super(currency, client); }

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
        if (balance < amount) {
            throw new IllegalArgumentException("Insufficient funds for withdraw");
        } else {
            balance -=amount;
            transaction.setOperationType("WITHDRAW");
            transaction.setOperationSum(amount);
            transaction.setTimestamp(LocalDateTime.now());
            return true;
        }
    }

    @Override
    void addTransaction(String type, double amount) {
        callMethod(type, amount);
    }

    @Override
    public String toString() {
        return "DepositAccount{" +
                "accountNUmber=" + accountNUmber +
                ", balance=" + balance +
                ", currency=" + currency +
                ", client=" + client +
                ", transaction=" + transaction +
                '}';
    }
}

//3. DepositAccount (наследник BankAccount)
//Обычный депозитный счёт.
//Снятие возможно только при наличии достаточного баланса.
//Без овердрафта.


