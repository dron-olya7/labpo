package org.example;

public class Main {
    private static boolean flag;

    public static void main(String[] args) {

        Number n;
        if( flag )
            n = Double.valueOf((double) ( new Integer(1).intValue() ));
         else
            n = Double.valueOf(new Double(2.0).doubleValue());


    }
}