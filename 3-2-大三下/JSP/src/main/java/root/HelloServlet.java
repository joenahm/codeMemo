package root;

import org.json.JSONObject;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(urlPatterns = "/aaa")
public class HelloServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/json;charset=utf-8");

        JSONObject person = new JSONObject();

        person.append("name", "张建");
        person.append("gender", "男");
        person.append("age", 20);

        response.getWriter().append(person.toString());
    }
}
