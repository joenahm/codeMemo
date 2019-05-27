package top.sjydzq.www.controller;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import top.sjydzq.www.model.Product;
import top.sjydzq.www.utils.mybatis.SelectListHelper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ProductController {
    public static void main(String[] args) {
        test();
    }

    private static void test() {
        try {
            InputStream config = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(config);
            SqlSession session = factory.openSession();

            SelectListHelper helper = new SelectListHelper();
            helper.stringHelper = "cu";
            List<Product> products = session.selectList("ProductMapper.selectByName", helper);
            System.out.println(products.get(0).getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
