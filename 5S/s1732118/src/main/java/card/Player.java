package card;

public class Player {
    /** プレイヤー名 */
    private String name;
    /** 所持コイン数 */
    private int coins;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
        public int getCoins() {
        return coins;
    }
    public void setCoins(int coins) {
        this.coins = coins;
    }
    public void addCoins(int coins) {
        this.coins += coins;
    }
}
