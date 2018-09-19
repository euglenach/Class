import java.util.*;
import java.util.stream.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String args[ ]) {
        
        int[] list = IntStream.rangeClosed(1, 9).toArray();
        
        System.out.print("      ");
        IntStream.range(1,10)
                 .forEach(i->System.out.print(i + "  "));
        System.out.println();
        System.out.println("  -----------------------------");
        
        
        
        IntStream.range(1, 10)
                 .forEach(x -> {
                    IntStream.range(0,10).forEach(y ->{
                        if(y == 0)System.out.printf("%3s|", x);
                        else System.out.printf("%3s", x * y);
                    });
                    System.out.println();
                 });
    }
}

