package top.sjydzq.www.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class IndexController {
    @RequestMapping("/")
    public void redirect(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("/user/register");
    }
}
