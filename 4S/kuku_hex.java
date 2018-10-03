package com.company;
import java.util.stream.*;
import java.lang.*;

class Main {
    public static void main(String args[ ]) {

        System.out.print("      ");
        IntStream.range(1,10)
                .forEach(i->System.out.print(i + "  "));
        System.out.println();
        System.out.println("  -----------------------------");



        IntStream.range(1, 10)
                .forEach(x -> {
                    IntStream.range(0,10).forEach(y ->{
                        if(y == 0)System.out.printf("%3s|", x);
                        else System.out.printf("%3s", Integer.toHexString(x * y));
                    });
                    System.out.println();
                });
    }
}
