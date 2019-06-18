package top.sjydzq.www.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/register")
public class RegisterController {
    @RequestMapping("/index")
    public String index() {
        return "Register/index";
    }

    @RequestMapping(value="/handle", method= RequestMethod.POST)
    public void handle(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(request.getParameter("name"));
        System.out.println(request.getParameter("id"));
        System.out.println(request.getParameter("email"));
        System.out.println(request.getParameter("addr"));
    }
}
