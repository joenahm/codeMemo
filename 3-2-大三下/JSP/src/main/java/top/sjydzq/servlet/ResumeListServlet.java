package top.sjydzq.servlet;

import top.sjydzq.config.Config;
import top.sjydzq.dao.ResumeDAO;
import top.sjydzq.javabean.Resume;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import top.sjydzq.javabean.Page;
import java.util.regex.Pattern;

@WebServlet(name = "ResumeListServlet", urlPatterns = "/ResumeListServlet")
public class ResumeListServlet extends HttpServlet {
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

        ResumeDAO resumeDAO = new ResumeDAO();

        Page<Resume> page = resumeDAO.queryPagination(pageNo, pageSize);

        request.setAttribute("resumeList", page);
        request.getRequestDispatcher("/manage/resumeList.jsp").forward(request, response);
    }
}
