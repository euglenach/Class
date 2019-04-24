package com.company;

public class CardUtility {

    private static final String[] numbers = new String[]{"K","A","2","3","4","5","6","7","8","9","10","J","Q"};
    private static final String[] suits = new String[]{"S","H","D","C"};

    public static int convertNum2Int(int n){
        var m = n % 13;
        if(m == 0){
            m = 13;
        }
        return m;
    }
    public static String convertNum2Str(int n){
        return numbers[n % 13];
    }
    public static String convertNum2Suit(int n){
        return suits[n / 14];
    }
}
