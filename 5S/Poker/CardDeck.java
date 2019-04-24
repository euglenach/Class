package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CardDeck {
    private List<Integer> cards = new ArrayList<>();

    public CardDeck(){
        cards = IntStream.range(1,53).boxed().collect(Collectors.toList());
    }

    public void printCards(){
        for (var item:cards) {
            var str = CardUtility.convertNum2Str(item);
            if(str.equals("10")){
                str = "0";
            }
            System.out.print(CardUtility.convertNum2Suit(item) + str + " ");
        }
        System.out.println();
    }

    public int getSize(){
        return cards.size();
    }

    public String getSuitNumber(int index){
        var str = CardUtility.convertNum2Str(cards.get(index));
        if(str.equals("10")){
            str = "0";
        }
        return CardUtility.convertNum2Suit(cards.get(index)) + str;
    }

    public void shuffle(){
        Collections.shuffle(cards);
        System.out.println();
    }

    public int getNextCard(){
        if(cards.size() < 1)return -1;
        var temp =cards.get(0);
        cards.remove(0);
        return temp;
    }
}
