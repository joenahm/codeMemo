package top.sjydzq.dao;

import top.sjydzq.javabean.User;
import top.sjydzq.utils.DB;
import top.sjydzq.utils.StatementCallback;

import javax.sql.rowset.CachedRowSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;

public class UserDAO {
    class InsertSetter extends StatementCallback {
        private String name;
        private String password;
        private String realName;
        private String email;
        private int role;
        private int state;

        InsertSetter(String name, String password, String realName, String email, int role, int state) {
            this.name = name;
            this.password = password;
            this.realName = realName;
            this.email = email;
            this.role = role;
            this.state = state;
        }

        public void set(PreparedStatement statement) {
            try {
                statement.setString(1, name);
                statement.setString(2, password);
                statement.setString(3, realName);
                statement.setString(4, email);
                statement.setInt(5, role);
                statement.setInt(6, state);
            } catch (SQLException e) {
                System.err.println("为插入用户准备信息时出错！");

                e.printStackTrace();
            }
        }
    }

    public boolean save(User user) {
        DB db = new DB();
        InsertSetter insertSetter = new InsertSetter(
                user.getName(),
                user.getPassword(),
                user.getRealName(),
                user.getEmail(),
                user.getRole(),
                user.getState()
        );

        String sql = "INSERT INTO TB_USERS(user_logname,user_pwd,user_realname,user_email,user_role,user_state) VALUES(?,?,?,?,?,?)";

        boolean status = db.insert(sql, insertSetter);
        db.close();

        return status;
    }

    public Vector<User> query() {
        DB db = new DB();

        CachedRowSet result = db.select("SELECT * FROM TB_USERS");
        db.close();

        Vector<User> users = new Vector<>();

        try {
            while (result.next()) {
                User user = new User();

                user.setName(result.getString(2));
                user.setRealName(result.getString(4));
                user.setEmail(result.getString(5));
                user.setRole(result.getInt(6));
                user.setState(result.getInt(7));

                users.add(user);
            }
        } catch (SQLException e) {
            System.err.println("从数据库取数据时出错！");

            e.printStackTrace();
        }

        return users;
    }
}
