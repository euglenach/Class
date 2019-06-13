<%@ page import="java.util.stream.IntStream" %>
<%@ page import="cards.Cards" %>
<%@ page import="cards.CardDeck" %><%--
  Created by IntelliJ IDEA.
  User: midor
  Date: 2019/05/29
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    final String cardPath = "Asset/cards/";
    CardDeck cardDeck = new CardDeck(); // 山札(52枚)
    cardDeck.shuffle(); // 山札のシャッフル
    Cards cards = new Cards(5, "test"); // 手札(この時点は0枚)
    for (int i: IntStream.range(0,5).toArray()) {
        int card = cardDeck.getNextCard(); // 山札から1枚引いて，
        cards.addCard(card); // それを手札に加える
    }

    cards.numSort();
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="Change" method="POST">
    交換するカードをチェックしてください
    <table>
        <tr>
            <% for (int i: IntStream.range(0,5).toArray()) { %>
            <td><img src="<%=cardPath + cards.getCard(i)%>.png" width="100" height="150"></td>
            <%} %>
        </tr>
        <tr>
            <% for (int i: IntStream.range(0,5).toArray()) { %>
            <td align="center"> <input type="checkbox" name="hand" value="<%=cards.getCard(i)%>"></td>
            <% } %>
        </tr>
    </table>
    <input type="submit" value="交換">
</form>
</body>
</html>
