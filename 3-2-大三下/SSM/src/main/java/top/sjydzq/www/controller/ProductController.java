package top.sjydzq.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import top.sjydzq.www.model.Product;
import top.sjydzq.www.service.ProductService;

import java.util.List;
import java.util.Scanner;

@Controller("productController")
public class ProductController {
    @Autowired
    private ProductService productService;

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    public void add() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("【 添加商品 】");

        System.out.print("名称: ");
        String name = scanner.next();

        System.out.print("价格: ");
        float price = scanner.nextFloat();

        Product product = new Product();
        product.setName(name);
        product.setPrice(price);

        if (this.productService.insertProduct(product) > 0) {
            System.out.println("添加成功！");
        } else {
            System.err.println("添加失败！");
        }
    }

    public void show() {
        List<Product> products = this.productService.selectAll();

        System.out.println("【 所有商品 】");
        for (Product p: products) {
            System.out.printf("%d %s %f\n", p.getId(), p.getName(), p.getPrice());
        }
    }

    public void search() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("【 模糊搜索 】");

        System.out.print("名称: ");
        String name = scanner.next();

        List<Product> products = this.productService.selectByName(name);

        System.out.println("结果:");
        for (Product p: products) {
            System.out.printf("%d %s %f\n", p.getId(), p.getName(), p.getPrice());
        }
    }

    public void edit() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("【 修改信息 】");

        System.out.print("商品id: ");
        int id = scanner.nextInt();

        Product product = this.productService.selectById(id);
        if (product != null) {
            System.out.print("名称: ");
            String name = scanner.next();
            product.setName(name);

            System.out.print("价格: ");
            float price = scanner.nextFloat();
            product.setPrice(price);

            if (this.productService.updateProduct(product) > 0) {
                System.out.println("商品信息修改成功！");
            } else {
                System.err.println("商品信息修改失败！");
            }
        } else {
            System.err.println("商品不存在！");
        }
    }

    public void remove() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("【 删除商品 】");

        System.out.print("商品id: ");
        int id = scanner.nextInt();

        if (this.productService.selectById(id) != null) {
            if (this.productService.deleteById(id) > 0) {
                System.out.println("商品删除成功！");
            } else {
                System.err.println("商品删除失败！");
            }
        } else {
            System.err.println("商品不存在！");
        }
    }
}
