package com.autobots.java.mobileBanking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Client {
    private String fullName;
    private UUID clientID = UUID.randomUUID();
    private int pinCode;
    private boolean isAuthorised = false;
    protected static List<BankAccount> listOfBankAccounts;

    public Client(String fullName, int pinCode) {
        this.fullName = fullName;
        this.pinCode = pinCode;
        listOfBankAccounts = new ArrayList<>();
    }

    public void authorization(UUID clientID, int pinCode){
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        if (clientID != getClientID() || pinCode != getPinCode()){
            throw new IllegalArgumentException("Invalid client ID or pin code");
        } else {
            setAuthorised(true);
            System.out.println(getFullName() + " welcome to super App!");
            System.out.println("Menu: \n "+
                    "1. Просмотреть счета\n" +
                    "2. Перевести между счетами\n" +
                    "3. Показать чек (историю операций)\n" +
                    "0. Выход");
            while (choice >=0 && choice < 4){
                System.out.println("Please choose operation type: ");
                choice =scanner.nextInt();
                if (choice == 1){
                    showMyAccounts();
                } else if (choice ==2){
//                    BankService.transfer(BankAccount);
                }

            }
        }
    }
    public static void showMyAccounts(){
        for(BankAccount bankAccount : listOfBankAccounts){
            System.out.println(bankAccount);
        }
    }

    public static BankAccount getAccountByAccountNumber(String accountNumber){
        BankAccount bankAccount1 = null;
        for (BankAccount bankAccount : listOfBankAccounts){
            if(bankAccount.accountNUmber.equals(UUID.fromString(accountNumber))){
                bankAccount1 = bankAccount;
            }
        }
        return bankAccount1;
    }


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public UUID getClientID() {
        return clientID;
    }

    public void setClientID(UUID clientID) {
        this.clientID = clientID;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public List<BankAccount> getListOfBankAccounts() {
        return listOfBankAccounts;
    }

    public void setListOfBankAccounts(BankAccount bankAccount) {
        listOfBankAccounts.add(bankAccount);
    }

    public boolean isAuthorised() {
        return isAuthorised;
    }

    public void setAuthorised(boolean authorised) {
        isAuthorised = authorised;
    }

    @Override
    public String toString() {
        return "Client{" +
                "fullName='" + fullName + '\'' +
                ", clientID=" + clientID +
                ", pinCode=" + pinCode +
                ", isAuthorised=" + isAuthorised +
                '}';
    }
}
