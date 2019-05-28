package top.sjydzq.www.service;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import top.sjydzq.www.model.Product;

import java.util.List;

@Repository("productService")
@Mapper
public interface ProductService {
    public List<Product> selectAll();
    public Product selectById(Integer id);
    public List<Product> selectByName(String name);
    public int insertProduct(Product product);
    public int updateProduct(Product product);
    public int deleteById(Integer id);
}
