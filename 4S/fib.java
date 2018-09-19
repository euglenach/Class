import java.util.*;
import java.util.stream.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String args[ ]) {
        IntStream.range(0, 21).forEach(i ->System.out.print(fibonacci(i)+ " "));
    }
    
    static int fibonacci(int n) {
        return (n==1||n==0)?n:fibonacci(n-2)+fibonacci(n-1);
    }
} 
