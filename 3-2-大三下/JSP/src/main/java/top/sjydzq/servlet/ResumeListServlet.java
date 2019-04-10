package top.sjydzq.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Pattern;

@WebServlet(name = "ResumeListServlet")
public class ResumeListServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        int pageNo = 0;
        int pageSize = 8;
        String reqPageNo = request.getParameter("pageNo");
        String reqPageSize = request.getParameter("pageSize");

        if (Pattern.matches("\\d", reqPageNo)) {
//            pageNo = Integer.parseInt()
            System.out.println("是数字");
        } else {
            System.out.println("不是数字");
        }

//        System.out.println();
    }
}
