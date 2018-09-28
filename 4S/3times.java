 import java.util.*;
import java.util.stream.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String args[ ]) {
        
        IntStream.range(1, 101)
                 .filter(n -> n % 3 == 0)
                 .forEach(n -> System.out.println(n));
    }
}

