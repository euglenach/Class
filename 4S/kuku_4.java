package com.company;
import java.util.*;
import java.util.stream.*;
import java.lang.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        displayKuku(3);
    }

    public static void timesKuku(int i , int t){
        List<Integer> list = IntStream.range(1,10).boxed().collect(Collectors.toList());

        for (int u = 0;u < t ;u++ ){
            list.stream().forEach(n -> System.out.printf("%2d ",n * i));
        }
        System.out.println();
    }
    public static void displayKuku(int n){
        List<Integer> list = IntStream.range(1,10).boxed().collect(Collectors.toList());
        for (int u = 0;u < n; u++){
            list.stream().forEach(i -> timesKuku(i,n));
            System.out.println();
        }
    }
}
