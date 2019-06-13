package hello;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.IntStream;

@WebServlet("/Hello")
public class Hello extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public Hello() {
        super();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var assetPath = "Asset/cards/";

        response.setContentType("text/html; charset=UTF-8");
        var out = response.getWriter();
        out.println("<html>");
        out.println("<img src=\"" + assetPath + "1.png\">");
        out.println("スペードA");
        out.println("<hr>");

        var  card = (int)(Math.random()*52)+1;
        out.println("<img src=\"" + assetPath + card + ".png\">");
        out.println("ランダムなカード");
        out.println("<hr>");

        for (int i: IntStream.range(14,27).toArray()) {
            out.println("<img src=\"" + assetPath + i + ".png\" width=\"40\" height=\"80\">");
        }

        out.println("</html>");
        System.out.println("doget()");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost()"); // この例ではdoPost()は実行されないので表示もされない
    }
}
