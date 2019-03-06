package top.sjydzq.servlet;

import top.sjydzq.dao.UserDAO;
import top.sjydzq.javabean.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/userAdd")
public class UserAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        User user = new User();

        user.setName(request.getParameter("userLogname"));
        user.setPassword(request.getParameter("userPwd"));
        user.setRealName(request.getParameter("userRealname"));
        user.setEmail(request.getParameter("userEmail"));
        user.setRole(Integer.parseInt(request.getParameter("userRole")));
        user.setState(Integer.parseInt(request.getParameter("userState")));

        UserDAO userDAO = new UserDAO();

        if (userDAO.save(user)) {
            response.sendRedirect("/manage/userList.jsp");
        } else {
            response.getWriter().println("添加用户失败!");
        }
    }
}
