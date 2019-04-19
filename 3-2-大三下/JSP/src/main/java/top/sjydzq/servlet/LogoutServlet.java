package top.sjydzq.servlet;

import top.sjydzq.javabean.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Vector;
import java.util.regex.Pattern;

@WebServlet(name = "LogoutServlet", urlPatterns = "/logout")
public class LogoutServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String uidStr = request.getParameter("uid");
        String type = request.getParameter("type");

        if (uidStr!=null && Pattern.matches("\\d", uidStr)) {
            int uid = Integer.parseInt(uidStr);

            ServletContext servletContext = request.getServletContext();
            Vector<HttpSession> onlineUserSessions = (Vector<HttpSession>) servletContext.getAttribute("ONLINE_USER_SESSIONS");

            if (onlineUserSessions != null) {
                for (HttpSession session: onlineUserSessions) {
                    User user = (User) session.getAttribute("SESSION_USER");
                    if (user.getId() == uid) {
                        onlineUserSessions.remove(session);
                        servletContext.setAttribute("ONLINE_USER_SESSIONS", onlineUserSessions);
                        session.invalidate();

                        break;
                    }
                }
            }

            if (type.equals("force")) {
                response.setHeader("refresh", "0;url='/manage/userOnline.jsp'");
            } else {
                response.sendRedirect("/login.html");
            }
        }
    }
}
