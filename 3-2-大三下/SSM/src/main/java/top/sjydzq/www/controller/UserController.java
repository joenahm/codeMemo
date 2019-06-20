package top.sjydzq.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import top.sjydzq.www.POJO.User;
import top.sjydzq.www.service.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/register")
    public String registerView(Model model) {
        model.addAttribute("user", new User());

        return "User/Register";
    }
    @RequestMapping(value="/register", method= RequestMethod.POST)
    public String handleRegister(@Valid @ModelAttribute("user") User user, BindingResult errors) {
        if (errors.hasErrors()) {
            return "User/Register";
        } else {
            userService.insert(user);

            return "User/Login";
        }
    }

    @RequestMapping("/login")
    public String loginView() {
        return "User/Login";
    }
}
