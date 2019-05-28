package top.sjydzq.www.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.sjydzq.www.controller.ProductController;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ProductController productController = (ProductController)context.getBean("productController");

        productController.add();
        productController.show();
        productController.search();
        productController.edit();
        productController.remove();
    }
}
