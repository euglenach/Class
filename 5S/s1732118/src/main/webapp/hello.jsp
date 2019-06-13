<%--
  Created by IntelliJ IDEA.
  User: midor
  Date: 2019/05/29
  Time: 6:18
  To change this template use File | Settings | File Templates.
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.stream.IntStream" %>
<%
  // 日時をtodayに入れる
  Date date = new Date(); // dateは現在の日時
  SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
  String today = sdf.format(date); // 現在の日時を"2019/05/15 12:34:56"のフォーマットのStringにする
// 1～100の乱数をnumに入れる
  int num = (int)(Math.random()*100)+1;
%>
<html>
  <head>
    <title>動的Webページの例</title>
  </head>
  <body>
  <%-- JSPのコメント --%>
  <p>現在の日時 <%= today %></p>
  <p>乱数 <%= num %></p>
  <!-- HTMLのコメント -->
  こんばんは！
  <%-- 変数 --%>
  <%
    int x=10, y=20;
  %>
  <%-- for文 --%>
  <p>
  <%
    for (int i: IntStream.range(0,5).toArray()) {
  %>
    iの値 <%=i %><br>
  <%
    }
  %>
    <% int z=x+y; %>
    zの値 <%= z %>
  </p>

  </body>
</html>
