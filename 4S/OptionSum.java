package com.company;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.print(Stream.of(args).mapToInt(Integer::parseInt).sum());
    }
}
