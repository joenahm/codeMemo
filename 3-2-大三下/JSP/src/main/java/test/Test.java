package test;

import top.sjydzq.dao.UserDAO;
import top.sjydzq.javabean.User;

import java.util.Vector;

public class Test {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();

        Vector<User> users;
        users = userDAO.query();

        for (User user: users) {
            System.out.println(user.getName());
        }
    }
}
