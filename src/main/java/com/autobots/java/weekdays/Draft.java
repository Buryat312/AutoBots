package com.autobots.java.weekdays;

public class Draft {
    public static void main(String[] args) {
        System.out.println(withouEnd2("abcd"));
        System.out.println(middleTwo("code"));
        System.out.println(endsLy("oddly"));
    }

    public static String withouEnd2(String str) {
        return str.substring(1, str.length()-1);
    }

    public static String middleTwo(String str) {
        int mid = str.length()/2;
        return str.substring(mid-1, mid+1);
    }

    public static boolean endsLy(String str) {
        return str.endsWith("ly");
    }

    public String nTwice(String str, int n) {
        return (str.substring(0, n))+(str.substring(str.length()-n));
    }

}
