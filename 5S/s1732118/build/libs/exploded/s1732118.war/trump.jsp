<%--
  Created by IntelliJ IDEA.
  User: midor
  Date: 2019/05/29
  Time: 6:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="cards.CardDeck" %>
<%@ page import="java.util.stream.IntStream" %>
<%
    CardDeck cardDeck = new CardDeck();
    final String cardsPath = "Asset/cards/";
%>
<html>
<head>
    <title>カードデッキ</title>
</head>
<body>
<p>デッキ残り <%= cardDeck.getSize() %>枚</p>
<%
    int number = cardDeck.getNextCard();
    System.out.println(number);
    System.out.println(cardDeck.getSize());
%>
<img src="<%= cardsPath + number %>.png" width="100" height="150">
<hr>
<%
    for (int i: IntStream.range(1,14).toArray()) {

%>
<img src="<%= cardsPath + i %>.png" width="100" height="150">
<% } %>

<hr>
<%
    for (int i: IntStream.range(1,53).toArray()) {
        if((i - 1) % 13 == 0){
%>
    <br>
<%
    }
%>

<img src="<%= cardsPath + i %>.png" width="100" height="150">
<% } %>

</body>
</html>
