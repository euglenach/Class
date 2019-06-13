package cards;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class CardUtility {

    public static Map<String,Integer> RoleTable = new HashMap<String,Integer>(){{
        put("ノーペア",0);put("ワンペア",1);put("ツーペア",2);put("スリーカード",3);put("ストレート",5);
        put("フラッシュ",10);put("フルハウス",20);put("フォーカード",40);put("ストレートフラッシュ",70);put("ロイヤルストレートフラッシュ",100);
    }};

    private static final String[] numbers = new String[]{"K","A","2","3","4","5","6","7","8","9","10","J","Q"};
    private static final String[] suits = new String[]{"S","H","D","C"};

    public static int convertNum2Int(int n){
        var m = n % 13;
        if(m == 0){
            m = 13;
        }
        return m;
    }
    public static String convertNum2Str(int n){
        return numbers[n % 13];
    }
    public static String convertNum2Suit(int n){
        return suits[(n + (n/14))  / 14];
    }


    public static String judge(int[] cards){
        int[] nums = new int[13];
        for (var item:cards) {
            nums[convertNum2Int(item)-1]++;
        }
        var pearCount = Count(nums,n -> n == 2);
        var threeCard = Count(nums,n -> n == 3) == 1;
        var fourCard = Count(nums,n -> n == 4) == 1;

        var count = 0;
        for (var item: nums) {
            if(item >= 2){break;}

            if(item == 1){
                count++;
                if(count == 5){break;}
            }else{
                count = 0;
            }
        }

        if(isRoyal(cards) && isFlash(cards)) return "ロイヤルストレートフラッシュ";

        if(isFlash(cards) && count == 5)return "ストレートフラッシュ";

        if(fourCard)return "フォーカード";

        if(threeCard && pearCount == 1) return "フルハウス";

        if(isFlash(cards))return "フラッシュ";
        if(count == 5)return "ストレート";

        if(threeCard)return "スリーカード";

        if(pearCount == 1)return "ワンペア";
        if(pearCount == 2)return "ツーペア";
        if(pearCount == 0)return "ノーペア";

        return "ノーペア";
    }

    private static boolean isFlash(int[] cards){
        for (var suit: suits) {
            if(All(cards,n -> convertNum2Suit(n) == suit)){return true;}
        }
        return false;
    }

    private static boolean isRoyal(int[] cards){
        for (var item:new int[]{1,10,11,12,13}) {
            if(Count(cards,n->n==item)==0)return false;
        }
        return true;
    }

    private static int Count(int[] cards, Function<Integer,Boolean> fn){
        var count = 0;

        for (var item:cards) {
            if(fn.apply(item)){
                count++;
            }
        }
        return count;
    }
    private static boolean All(int[] cards,Function<Integer,Boolean> fn){
        for (var item:cards) {
            if(!fn.apply(item)){
                return false;
            }
        }
        return true;
    }

}