package hello;

import java.util.stream.*;

public class Game {
    public static void main(String[] args) {
        Cards cards = new Cards(5,"手札");
        //cards.addCard(1);
        for (var item: new int[]{1,15,31,49,52}) {
            cards.addCard(item);
        }
        cards.printCards();
        System.out.println(cards.getSuitNumber(0));
        cards.printNumbers();
        cards.printSuitsNumbers();
        System.out.println(cards.maxNumber());
        cards.reverse();
        cards.printCards();
        System.out.println();
        cards.removeFirst();
        cards.printCards();
    }
}
