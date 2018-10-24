package com.company;

public class RemoveFirstChar {
    public static void main(String[] args) {
        var s = args[0].substring(0,1);
        for (var i:args) {
            System.out.println(i.replace(s,""));
        }
    }
}
