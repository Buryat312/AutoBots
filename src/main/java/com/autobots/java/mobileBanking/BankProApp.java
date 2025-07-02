package com.autobots.java.mobileBanking;

import java.util.Scanner;
import java.util.UUID;

public class BankProApp {
    public static void main(String[] args) {
        Client zinaida = new Client("Zinaida", 333444);
        Client kaniet = new Client("Zinaida", 222333);
        Client alia = new Client("Zinaida", 111222);

        DepositAccount zinaidaDebitEUR = new DepositAccount(Currency.EUR, zinaida);
        DepositAccount zinaidaDebitUSD = new DepositAccount(Currency.USD, alia);
        DepositAccount zinaidaDebitKGS= new DepositAccount(Currency.KGS, kaniet);

        CreditAccount zinaidaCreditEUR = new CreditAccount(Currency.EUR, zinaida);
        CreditAccount zinaidaCreditUSD = new CreditAccount(Currency.USD, alia);
        CreditAccount zinaidaCreditKGS = new CreditAccount(Currency.KGS, kaniet);

        zinaidaDebitEUR.deposit(10000);
//        zinaidaDebitKGS.deposit(1000);
        zinaidaDebitUSD.deposit(500);
//        zinaidaCredit.deposit(101);
//        System.out.println(zinaidaDebit.getBalance());


        // Просмотреть счета — показать тип, номер, баланс и валюту всех счетов клиента.
        zinaida.setListOfBankAccounts(zinaidaCreditEUR);
        zinaida.setListOfBankAccounts(zinaidaCreditKGS);
        zinaida.setListOfBankAccounts(zinaidaCreditUSD);
        zinaida.setListOfBankAccounts(zinaidaDebitEUR);
        zinaida.setListOfBankAccounts(zinaidaDebitUSD);
        zinaida.setListOfBankAccounts(zinaidaDebitKGS);
//        Client.showMyAccounts();

        System.out.println("-------------------");

        // Перевести — ввести номер счёта-отправителя, номер получателя и сумму.
        BankService.transfer(zinaidaDebitEUR, zinaidaCreditKGS, 100.00);
        System.out.println(zinaidaDebitEUR.getBalance());
        System.out.println(zinaidaCreditKGS.getBalance());

        System.out.println("----");

        BankService.transfer(zinaidaDebitEUR, zinaidaCreditUSD, 120);
        System.out.println(zinaidaDebitEUR.getBalance());
        System.out.println(zinaidaCreditUSD.getBalance());

        System.out.println("----");

        BankService.transfer(zinaidaDebitEUR, zinaidaCreditEUR, 100);
        System.out.println(zinaidaDebitEUR.getBalance());
        System.out.println(zinaidaCreditEUR.getBalance());

        System.out.println("----");

//        BankService.transfer(zinaidaDebitKGS, zinaidaCreditEUR, 8000.00);
//        System.out.println(zinaidaDebitKGS.getBalance());
//        System.out.println(zinaidaCreditEUR.getBalance()); // 80

        System.out.println("----");

        BankService.transfer(zinaidaDebitUSD, zinaidaCreditEUR, 100);
        // 100 / 1.1 = 90,909090909 = 91
//        System.out.println(zinaidaDebitUSD.getBalance());
//        System.out.println(zinaidaCreditEUR.getBalance()); // 91 + 80 = 171

        System.out.println("-------------------");

        // Показать чек — вывести список всех операций по каждому счёту клиента.
//        Client.showMyAccounts();
        System.out.println("-------------------");
        System.out.println(zinaidaCreditEUR.getBalance() + " Credit Before");
        System.out.println(zinaidaDebitKGS.getBalance() + " Before"); // 10 000
        System.out.println("-------------------");
//        BankService.transfer(zinaidaCreditUSD, zinaidaCreditKGS, 100);
//        System.out.println(zinaidaCreditUSD.getBalance());
//        System.out.println(zinaidaCreditKGS.getBalance());
        //                                                             108272,727272727 = 108430.0
        BankService.transfer(zinaidaCreditEUR, zinaidaDebitKGS, 1);
        System.out.println(zinaidaCreditEUR.getBalance() + " Credit After");
        System.out.println(zinaidaDebitKGS.getBalance() + " After"); // 10 000 + 108430.0 = 118430.0



        // Пример использования:
        // Клиент Alice имеет два счета:
        // Депозитный в USD
        // Кредитный в EUR
        // Она заходит в систему и переводит 100 EUR со своего кредитного на депозитный (конвертируется в USD)


    }
}
