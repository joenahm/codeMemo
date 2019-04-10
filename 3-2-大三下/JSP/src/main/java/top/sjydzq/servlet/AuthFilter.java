package top.sjydzq.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "AuthFilter")
public class AuthFilter implements Filter {
    private String sessionKey;
    private String redirectUrl;

    public void init(FilterConfig config) throws ServletException {
        this.sessionKey = config.getInitParameter("sessionKey");
        this.redirectUrl = config.getInitParameter("redirectUrl");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        if (request.getSession().getAttribute(sessionKey) == null) {
            response.sendRedirect(this.redirectUrl);
        } else {
            chain.doFilter(req, resp);
        }
    }

    public void destroy() {}
}
