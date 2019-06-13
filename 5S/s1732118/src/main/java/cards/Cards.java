package cards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

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

    public void removeCard(int card) {
        int index = -1;
        for (int i=0; i<num; i++) { // cardの格納場所を探す
            if (cards[i] == card)
                index = i;
        }
        if (index != -1) {
            for (int i=index; i<num-1; i++) { // 一枚ずつずらす
                cards[i] = cards[i+1];
            }
            num--; // 1枚減らす
        }
    }


    public int getNum() {
        return num;
    }
    public String getName() {
        return name;
    }

    /** 判別した役名をnameにセットし，獲得したコイン数を返す */
    public int judge() { // judgeを自作している場合，このように獲得したコイン数をintで返すようにせよ
        name = CardUtility.judge(cards);
        var coin = CardUtility.RoleTable.get(name);
        return coin;
    }


    public void sort(){
        Arrays.sort(cards);
    }

    public void numSort() {

        for (int i = 0; i < cards.length - 1; i++) {
            for (int j = cards.length - 1; j > i; j--) {
                if (CardUtility.convertNum2Int(cards[j - 1]) > CardUtility.convertNum2Int(cards[j])) {
                    var tmp = cards[j - 1];
                    cards[j - 1] = cards[j];
                    cards[j] = tmp;
                }
            }
        }
    }
}
