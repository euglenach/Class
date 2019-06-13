package card;

import cards.CardDeck;
import cards.Cards;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@WebServlet("/PokerApp")
public class PokerApp extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public PokerApp() {
        super();
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // セッションスコープに保存されているデータをcardDeck, cards, playerに格納する
        HttpSession session = request.getSession();
        CardDeck cardDeck = (CardDeck)session.getAttribute("cardDeck"); // カードデッキ
        Cards cards = (Cards)session.getAttribute("cards"); // 5枚の手札
        Player player = (Player)session.getAttribute("player"); // プレイヤー情報
        // (課題3.1)交換するカード番号(1～52)をSystem.out.println()する
        var hands = new int[]{};
        try {
            hands = Stream.of(request.getParameterValues("hand")).mapToInt(Integer::parseInt).toArray();
        }catch(Exception e){

        }
        if(hands.length != 0){
            for (var item:hands) {
                System.out.println(item);
            }
            // (課題3.2)手札から交換するカードを取り除く
            for (var item:hands) {
                cards.removeCard(item);
            }
            // (課題3.3)取り除いた分をカーデデッキから引き，手札に加える
            for (var i: IntStream.range(0, hands.length).toArray()) {
                cards.addCard(cardDeck.getNextCard());
            }
        }

        int reward = cards.judge(); // 役判別
        cards.numSort();
        // (課題3.4)役判別の結果を用いてコインを増やす
        player.addCoins(reward);
        // pokerResult.jspにフォワードして，手札を表示する
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pokerResult.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        // プレイヤー情報をセッションスコープから取り出す
        // サーバ起動後に初めてPokerAppを開いた場合，playerはnullなので
        // ゲームオーバー状態のプレイヤーをセッションスコープに作成する
        Player player = (Player)session.getAttribute("player");
        if (player == null) {
            player = new Player();
            player.setName("");
            player.setCoins(0);
            session.setAttribute("player", player); // ゲームオーバー状態のプレイヤー
        }
        // ゲームオーバー状態の場合，新規ゲームを開始する
        if (player.getCoins() == 0) {
            player.setName("工大太郎");
            player.setCoins(10); // ゲーム開始時のコインは10枚
        }
        int c = player.getCoins(); // 参加料を支払う
        player.setCoins(c-1);
        CardDeck cardDeck = new CardDeck(); // 山札(52枚)
        cardDeck.shuffle(); // 山札のシャッフル

        Cards cards = new Cards(5, "test"); // 手札(この時点では0枚)
//        for (int i=0; i<5; i++) {
//            int card = cardDeck.getNextCard();
//            cards.addCard(card);
//        }
        for (var item:new int[]{1,10,11,12,13}) {
            cards.addCard(item);
        }
        cards.numSort();
        // セッションスコープに山札・手札を保存する
        session.setAttribute("cardDeck", cardDeck);
        session.setAttribute("cards", cards);
        // pokerApp.jspにフォワードして，手札を表示する
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pokerChange.jsp");
        dispatcher.forward(request, response);

    }
}
