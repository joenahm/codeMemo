package top.sjydzq.servlet;

import top.sjydzq.dao.CompanyDAO;
import top.sjydzq.javabean.Company;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@WebServlet(name = "CompanyAddServlet", urlPatterns = "/companyAdd")
@MultipartConfig
public class CompanyAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        Part part = request.getPart("companyPic");

        Company company = new Company();

        company.setName(request.getParameter("companyName"));
        company.setArea(request.getParameter("companyArea"));
        company.setSize(request.getParameter("companySize"));
        company.setType(request.getParameter("companyType"));
        company.setBrief(request.getParameter("companyBrief"));
        company.setState(Integer.parseInt(request.getParameter("companyState")));
        company.setSort(Integer.parseInt(request.getParameter("companySort")));
        company.setPic(part.getSubmittedFileName());

        CompanyDAO companyDAO = new CompanyDAO();

        if (companyDAO.save(company)) {
            response.sendRedirect("/manage/companyList.jsp");
        } else {
            response.getWriter().println("添加公司失败！");
        }
    }
}
