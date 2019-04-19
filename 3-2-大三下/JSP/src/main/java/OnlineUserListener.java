import top.sjydzq.javabean.User;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;
import java.util.Enumeration;
import java.util.Vector;

@WebListener()
public class OnlineUserListener implements HttpSessionAttributeListener, HttpSessionListener {

    public void attributeAdded(HttpSessionBindingEvent sbe) {
        if (sbe.getName().equals("SESSION_USER")) {
            User user = (User)sbe.getValue();

            ServletContext servletContext = sbe.getSession().getServletContext();
            Vector<User> onlineUsers = (Vector<User>) servletContext.getAttribute("ONLINE_USERS");
            Vector<HttpSession> onlineUserSessions = (Vector<HttpSession>) servletContext.getAttribute("ONLINE_USER_SESSIONS");

            if (onlineUsers == null) {
                onlineUsers = new Vector<>();
            }

            onlineUsers.add(user);
            servletContext.setAttribute("ONLINE_USERS", onlineUsers);

            if (onlineUserSessions == null) {
                onlineUserSessions = new Vector<>();
            }

            onlineUserSessions.add(sbe.getSession());
            servletContext.setAttribute("ONLINE_USER_SESSIONS", onlineUserSessions);
        }
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        Enumeration<String> attrNames = se.getSession().getAttributeNames();

        boolean status = true;
        while (status && attrNames.hasMoreElements()) {
            if (attrNames.nextElement().equals("SESSION_USER")) {
                status = false;
                User user = (User)se.getSession().getAttribute("SESSION_USER");

                ServletContext servletContext = se.getSession().getServletContext();
                Vector<User> onlineUsers = (Vector<User>) servletContext.getAttribute("ONLINE_USERS");

                if (onlineUsers != null) {
                    onlineUsers.remove(user);
                    servletContext.setAttribute("ONLINE_USERS", onlineUsers);
                }
            }
        }
    }
}
