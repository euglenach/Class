import java.util.*;
import java.util.stream.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String args[ ]) {
        
        IntStream.range(2, 100)  
            .filter(i -> i % 2 != 0 || i == 2)
            .filter(i -> i % 3 != 0 || i == 3)
            .filter(i -> i % 5 != 0 || i == 5)
            .filter(i -> i % 7 != 0 || i == 7)
            .forEach(i -> System.out.println(i));
    }
}