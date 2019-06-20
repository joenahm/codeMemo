package top.sjydzq.www.service;

import org.springframework.stereotype.Service;
import top.sjydzq.www.POJO.User;

@Service
public class UserServiceImpl implements UserService {
    public boolean insert(User user) {
        // 模拟数据库操作

        return true;
    }
}
