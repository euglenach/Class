package com.company;
import java.util.*;
import java.util.stream.*;
import java.lang.*;

public class Cards {
    private int cards[];
    private  int num;
    private String name;

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
        Arrays.stream(cards).forEach(n -> {
            if(n!=0)System.out.print(n + " ");
        });
    }

    public void printNumbers(){
        Arrays.stream(cards).forEach(n -> {
            if(n!=0) {
                var str = CardUtility.convertNum2Str(n);
                if (str.equals("10")) str = "0";
                System.out.print(str + " ");
            }
        });
        System.out.println();
    }

    public String getNumber(int index){
        var str = CardUtility.convertNum2Str(index);
        if(str.equals("10"))str = "0";
       return CardUtility.convertNum2Str(index);
    }


    public String getSuitNumber(int index){
        var str = CardUtility.convertNum2Str(cards[index]);
        if(str.equals("10"))str = "0";
        return CardUtility.convertNum2Suit(cards[index]) + str;
    }

    public void printSuitsNumbers(){
        for (var item:cards) {
            if(item == 0)continue;
            var str = CardUtility.convertNum2Str(item);
            if(str.equals("10"))str = "0";
            System.out.print(CardUtility.convertNum2Suit(item) + str + " ");
        }
        System.out.println(" :" + name);
    }

    public int maxNumber(){
        var nums = new Integer[cards.length];
        for (var i:IntStream.range(0,cards.length).toArray()) {
            nums[i] = CardUtility.convertNum2Int(cards[i]);
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
