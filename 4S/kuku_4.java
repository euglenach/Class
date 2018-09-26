package com.company;
import java.util.*;
import java.util.stream.*;
import java.lang.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        //var list = IntStream.range(1,9).toArray();

        List<Integer> list = IntStream.range(1,10).boxed().collect(Collectors.toList());

        list.stream().forEach(i -> IntStream.range(0,10));
    }
}
