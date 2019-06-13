package hello;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Stream;

@WebServlet("/Change")
public class Change extends HttpServlet {
    final String cardsPath = "Asset/cards/";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8"); // フォームの文字コード
        var hand = Stream.of(request.getParameterValues("hand")).mapToInt(Integer::parseInt).toArray();

        response.setCharacterEncoding("UTF-8"); // レスポンスの文字コード
        var out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><meta charset=\"UTF-8\"><title>change test</title></head>");
        out.println("<body>");

        for (int item :hand) {
            out.println("<img src=\"" + cardsPath + item + ".png\"" +"</img>");
        }

        out.println("</body>");
        out.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());

    }
}
