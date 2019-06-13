<%--
  Created by IntelliJ IDEA.
  User: midor
  Date: 2019/06/05
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="cards.Cards, card.Player" %>
<%
    Cards cards = (Cards)session.getAttribute("cards"); // サーブレットで作った手札
    Player player = (Player)session.getAttribute("player");
    final String cardPath = "/Asset/cards/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>result</title>
</head>
<body>
<form action="/PokerApp" method="POST">
    役：<%= cards.getName() %>
    <table>
        <tr>
            <% for (int i=0; i<cards.getNum(); i++) { %>
            <td>
                <img src="<%= cardPath + cards.getCard(i) %>.png" width="100" height="150">
            </td>
            <% } %>
        </tr>
    </table>
    残コイン：<%= player.getCoins() %><br>
    <% if (player.getCoins() > 0) { %>
    <a href="/PokerApp">次のカードを配る</a>
    <% } else { %>
    ゲームオーバー
    <a href="/PokerApp">新規ゲームを始める</a>
    <% } %>
</form>
</body></html>
