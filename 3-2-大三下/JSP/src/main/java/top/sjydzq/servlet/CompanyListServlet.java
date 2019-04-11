package top.sjydzq.servlet;

import top.sjydzq.config.Config;
import top.sjydzq.dao.CompanyDAO;
import top.sjydzq.javabean.Company;
import top.sjydzq.javabean.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Pattern;

@WebServlet(name = "CompanyListServlet", urlPatterns = "/CompanyListServlet")
public class CompanyListServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        int pageNo = Config.DEFAULT_PAGE_NO;
        int pageSize = Config.DEFAULT_PAGE_SIZE;
        String reqPageNo = request.getParameter("pageNo");
        String reqPageSize = request.getParameter("pageSize");

        if (reqPageNo!=null && Pattern.matches("\\d", reqPageNo)) {
            pageNo = Integer.parseInt(reqPageNo);
        }
        if (reqPageSize!=null && Pattern.matches("\\d", reqPageSize)) {
            pageSize = Integer.parseInt(reqPageSize);
        }

        CompanyDAO companyDAO = new CompanyDAO();

        Page<Company> page = companyDAO.queryPagination(pageNo, pageSize);

        request.setAttribute("companyList", page);
        request.getRequestDispatcher("/manage/companyList.jsp").forward(request, response);
    }
}
