package hello;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/FormTest")
public class FormTest extends HttpServlet{
    private static final long serialVersionUID = 1L;
    public FormTest() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8"); // フォームの文字コード
        var name = request.getParameter("name");
        var age =  Integer.parseInt(request.getParameter("age"));
        var year = Integer.parseInt(request.getParameter("year"));
        var gender = request.getParameter("gender");
        String blood = request.getParameter("blood");

        response.setCharacterEncoding("UTF-8"); // レスポンスの文字コード
        var out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><meta charset=\"UTF-8\"><title>formtest</title></head>");
        out.println("<body>");

        out.println("<div>氏名:"+name+"</div>");
        out.println("<div>学年:"+year+"</div>");
        out.println("<div>年齢:"+age+"</div>");
        out.println("<div>性別:"+gender+"</div>");
        out.println("<div>血液型:"+blood+"</div>");

        out.println("</body>");
        out.println("</html>");
    }
}
