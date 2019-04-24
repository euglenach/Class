package com.company;

public class Poker {
    public CardDeck CardDeck;
    public Cards Cards1,Cards2;

    public Poker(){
        CardDeck = new CardDeck();
        Cards1 = new Cards(5,"ワンペア");
        for (var item:new int[]{1,14,15,16,17}) {
            Cards1.addCard(item);
        }
        Cards2 = new Cards(5, "なし");
    }
    public void printCards(){
        Cards1.printSuitsNumbers();
        Cards2.printSuitsNumbers();
    }
}
