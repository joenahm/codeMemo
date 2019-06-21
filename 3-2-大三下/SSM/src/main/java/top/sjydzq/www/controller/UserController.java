package top.sjydzq.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import top.sjydzq.www.POJO.POJOUser;
import top.sjydzq.www.bean.User;
import top.sjydzq.www.service.UserService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/search")
    public String registerView(Model model) {
        model.addAttribute("user", new POJOUser());

        return "User/Search";
    }
    @RequestMapping(value="/search", method= RequestMethod.POST)
    public String handleRegister(@Valid @ModelAttribute("user") POJOUser inputPOJOUser, BindingResult errors, Model model) {
        if (errors.hasErrors()) {
            return "User/Search";
        } else {
            List<User> users = userService.selectByName(inputPOJOUser.getUsername());

            model.addAttribute("users", users);

            return "User/List";
        }
    }
}
