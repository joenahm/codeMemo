package top.sjydzq.www.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.sjydzq.www.service.AccountService;

public class AccountController {
    public static void main(String[] args) {
        test();
    }

    private static void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService accountService = (AccountService)context.getBean("accountService");

        accountService.transfer(1, 2, 66);
    }
}
