package org.example;

public class Main {
    private static boolean flag1;
    private static boolean flag2;

    public static void main(String[] args) {
        Integer n;
        if( flag1 )
            n = Integer.valueOf(1);
        else {
            if( flag2 )
                n = Integer.valueOf(Integer.valueOf(2).intValue());
            else
                n = Integer.valueOf(((Integer)null).intValue());
        }        
        
    }
}