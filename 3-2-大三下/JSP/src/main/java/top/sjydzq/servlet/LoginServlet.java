package top.sjydzq.servlet;

import top.sjydzq.dao.UserDAO;
import top.sjydzq.javabean.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String username = request.getParameter("userLogname");
        String password = request.getParameter("userPwd");
//        String captcha = request.getParameter("validateCode");

        UserDAO userDAO = new UserDAO();
        User user = userDAO.query(username, password);

        if (user != null) {
            request.getSession().setAttribute("SESSION_USER", user);
            response.sendRedirect("/manage/main.jsp");
        } else {
            response.getWriter().append("<script>alert('用户信息错误，登陆失败！');</script>");
            response.getWriter().append("<script>window.location.replace('/login.html');</script>");
        }
    }
}
