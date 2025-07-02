package com.autobots.java.mobileBanking;

import java.util.AbstractMap;

public class ExchangeRate {

    final static double USD = 1.0;
    final static double EUR = 1.1;
    final static double KGS = 0.011;
    /*
    Курс к USD:
    USD → 1.0
    EUR → 1.1
    KGS → 0.011
    Пример: если перевод с EUR в USD, то сначала переводим в USD, затем в целевую валюту.
     */

    static double convert(double amount, Currency from, Currency to) {
        double res = 0.0;
        if (from.equals(Currency.EUR) && to.equals(Currency.USD)) {
            res = amount * EUR * USD;
        } else if (from.equals(Currency.USD) && to.equals(Currency.EUR)) {
            res = amount * USD / EUR;
        } else if (from.equals(Currency.KGS) && to.equals(Currency.EUR)) {
            res = amount * KGS / EUR;
        } else if (from.equals(Currency.KGS) && to.equals(Currency.USD)) {
            res = amount * KGS / USD;
        } else if (from.equals(Currency.USD) && to.equals(Currency.KGS)) {
            res = amount / KGS;
        } else if (from.equals(Currency.EUR) && to.equals(Currency.KGS)) {
            res = amount * EUR / KGS;
        } else if (from.equals(Currency.EUR) && to.equals(Currency.EUR)) {
            res = amount;
        } else if (from.equals(Currency.USD) && to.equals(Currency.USD)) {
            res = amount;
        } else if (from.equals(Currency.KGS) && to.equals(Currency.KGS)) {
            res = amount;
        }
        return Math.round(res);
    }
}


