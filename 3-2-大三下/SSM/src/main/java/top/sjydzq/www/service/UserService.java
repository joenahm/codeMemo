package top.sjydzq.www.service;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import top.sjydzq.www.bean.User;

import java.util.List;

@Repository("userDAO")
@Mapper
public interface UserService {
    public List<User> selectAll ();
    public List<User> selectByName(String name);
}
