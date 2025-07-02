package com.autobots.java.mobileBanking;

public class BankService {

    public static boolean transfer(BankAccount from, BankAccount to, double amount){
        double convertedAmount = ExchangeRate.convert(amount, from.getCurrency(), to.getCurrency());

        if(from.withdraw(amount)){
            to.deposit(convertedAmount);
            from.addTransaction("TRANSFER", amount);
            to.addTransaction("TRANSFER", convertedAmount);
            return true;
        }
        return false;
    }

//    public static boolean transfer(BankAccount from, String operation, BankAccount to, double amount) {
//        double convertedAmount = ExchangeRate.convert(amount, from.getCurrency(), to.getCurrency());
//        from.callMethod(operation, amount);
//        to.callMethod("DEPOSIT", amount);
//        from.addTransaction("TRANSFER", amount);
//        to.addTransaction("TRANSFER", convertedAmount);
//        return true;
//    }

}
