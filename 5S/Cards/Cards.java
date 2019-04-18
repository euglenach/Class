package hello;
import java.util.*;
import java.util.stream.*;
import java.lang.*;

public class Cards {

    private int cards[];
    private  int num;
    private String name;
    private static final String[] numbers = new String[]{"K","A","2","3","4","5","6","7","8","9","10","J","Q"};
    private static final String[] suits = new String[]{"S","H","D","C"};

    public Cards(int num,String name){
        cards = new int[num];
        this.num = 0;
        this.name = name;
    }

    public void addCard(int card){
        cards[num] = card;
        num++;
    }

    public int getCard(int index){
        return cards[index];
    }

    public void printCards(){
        Arrays.stream(cards).forEach(n -> System.out.print(n + " "));
    }

    public void printNumbers(){
        Arrays.stream(cards).forEach(n -> System.out.print(convertNum2Str(n) + " "));
        System.out.println();
    }

    private String convertNum2Str(int n){
        return numbers[n % 13];
    }
    private String convertNum2Suit(int n){
        return suits[n / 14];
    }

    public int convertNum2Int(int n){
        var m = n % 13;
        if(m == 0){
            m = 13;
        }
        return m;
    }

    public String getNumber(int index){
       return convertNum2Str(index);
    }


    public String getSuitNumber(int index){
        return convertNum2Suit(cards[index]) + convertNum2Str(cards[index]);
    }

    public void printSuitsNumbers(){
        for (var item:cards) {
            System.out.print(convertNum2Suit(item) + convertNum2Str(item) + " ");
        }
        System.out.println();
    }

    public int maxNumber(){
        var nums = new Integer[cards.length];
        for (var i:IntStream.range(0,cards.length).toArray()) {
            nums[i] = convertNum2Int(cards[i]);
        }
        return Arrays.stream(nums).max((a,b)->a.compareTo(b)).get();
    }

    public void reverse(){
        List<Integer> list = new ArrayList<>();
        for (int t : cards) list.add(t);
        Collections.reverse(list);
        for (var i:IntStream.range(0,cards.length).toArray()) {
            cards[i] = list.get(i);
        }
    }

    public int removeFirst(){
        var temp = cards[0];
        for (var i:IntStream.range(1,cards.length).toArray()) {
            cards[i - 1] = cards[i];
        }
        cards[cards.length - 1] = 0;
        return temp;
    }
}
