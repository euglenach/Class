import java.util.*;
import java.util.stream.*;
import java.lang.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        List<Integer> list = IntStream.range(1,10).boxed().collect(Collectors.toList());
        
        for (int u = 0;u < 2 ;u++ ){ 
            list.stream().forEach(i -> timesKuku(i));
            System.out.println();
        }
    }
    
    public static void timesKuku(int n){
        List<Integer> list = IntStream.range(1,10).boxed().collect(Collectors.toList());
        
        
        for (int u = 0;u < 2 ;u++ ){
            list.stream().forEach(i -> System.out.printf("%2d ",i * n));
        }
        System.out.println();
    
    }
}
