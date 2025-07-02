package com.autobots.java.bankApplication;

public class Demo {
    public static void main(String[] args) {
        int result = sum(5, 6);
        System.out.println(result);

        System.out.println(sum2(5,6));

    }

    public static int sum(int a, int b){
        return a+b;
    }

    public static String sum2(int a, int b){
        return String.valueOf(a+b);
    }
}
