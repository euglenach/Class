public class Main {
    public static void main(String[] args) {
        var s = args[0].substring(0,1);
        for (var i:args) {
            if(i.contains(s)){
                System.out.println(i);
            }
        }
    }
}
