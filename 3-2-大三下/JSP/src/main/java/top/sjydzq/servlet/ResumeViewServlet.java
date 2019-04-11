package top.sjydzq.servlet;

import top.sjydzq.dao.ResumeDAO;
import top.sjydzq.javabean.Resume;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Pattern;

@WebServlet(name = "ResumeViewServlet", urlPatterns = "/ResumeViewServlet")
public class ResumeViewServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String reqResumeId = request.getParameter("id");

        if (reqResumeId!=null && Pattern.matches("\\d", reqResumeId)) {
            int resumeId = Integer.parseInt(reqResumeId);

            ResumeDAO resumeDAO = new ResumeDAO();

            Resume resume = resumeDAO.query(resumeId);

            request.setAttribute("resume", resume);
            request.getRequestDispatcher("/manage/resumeView.jsp").forward(request, response);
        } else {
            response.getWriter().println("所查简历不存在！");
        }
    }
}
