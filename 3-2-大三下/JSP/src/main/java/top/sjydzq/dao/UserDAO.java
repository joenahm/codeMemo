package top.sjydzq.dao;

import top.sjydzq.javabean.Page;
import top.sjydzq.javabean.User;
import top.sjydzq.utils.DB;
import top.sjydzq.utils.Pagination;
import top.sjydzq.utils.PaginationSetter;
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

    private Vector<User> fetchUser(CachedRowSet resultSet) {
        Vector<User> users = new Vector<>();

        if (resultSet != null) {
            try {
                while (resultSet.next()) {
                    User user = new User();

                    user.setId(resultSet.getInt(1));
                    user.setName(resultSet.getString(2));
                    user.setRealName(resultSet.getString(4));
                    user.setEmail(resultSet.getString(5));
                    user.setRole(resultSet.getInt(6));
                    user.setState(resultSet.getInt(7));

                    users.add(user);
                }
            } catch (SQLException e) {
                System.err.println("从数据库取用户数据时出错！");

                e.printStackTrace();
            }
        }

        return users;
    }

    public Vector<User> query() {
        DB db = new DB();

        CachedRowSet result = db.select("SELECT * FROM TB_USERS");
        db.close();

        return this.fetchUser(result);
    }

    class UserSelectSetter extends StatementCallback {
        private String name;
        private String password;

        UserSelectSetter(String name, String password) {
            this.name = name;
            this.password = password;
        }

        public void set(PreparedStatement statement) {
            try {
                statement.setString(1, name);
                statement.setString(2, password);
            } catch (SQLException e) {
                System.err.println("为查询用户准备信息时出错！");

                e.printStackTrace();
            }
        }
    }

    public User query(String username, String password) {
        DB db = new DB();
        UserSelectSetter selectSetter = new UserSelectSetter(username, password);

        String sql = "SELECT * FROM TB_USERS WHERE user_logname=? AND user_pwd=?";
        CachedRowSet result = db.select(sql, selectSetter);
        db.close();

        User user = null;

        Vector<User> tmpUsers = this.fetchUser(result);

        if (tmpUsers.size() > 0) {
            user = tmpUsers.get(0);
        }

        return user;
    }

    public Page<User> queryPagination(int pageNo, int pageSize) {
        DB db = new DB();
        PaginationSetter selectSetter = new PaginationSetter(pageNo-1, pageSize);
        // SQL中是0基的

        CachedRowSet records = db.select("SELECT * FROM TB_USERS LIMIT ?,?", selectSetter);

        Vector<User> users = this.fetchUser(records);

        Page<User> page = new Page<>(pageNo, pageSize, users);

        CachedRowSet count = db.select("SELECT COUNT(*) FROM TB_USERS");

        db.close();

        int recordCount = Pagination.getRecordCount(count);

        page.setTotalPages(Pagination.paginate(recordCount, pageSize));
        if (pageNo == 1) {
            page.setPrevStatus(false);
        } else {
            page.setPrevStatus(true);
        }
        if (page.getTotalPages() <= pageNo) {
            page.setNextStatus(false);
        } else {
            page.setNextStatus(true);
        }

        return page;
    }
}
