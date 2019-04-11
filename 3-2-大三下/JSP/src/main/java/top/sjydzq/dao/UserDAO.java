package top.sjydzq.dao;

import top.sjydzq.javabean.Page;
import top.sjydzq.javabean.User;
import top.sjydzq.utils.DB;
import top.sjydzq.utils.Pagination;
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

                user.setId(result.getInt(1));
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

        try {
            while (result.next()) {
                user = new User();

                user.setId(result.getInt(1));
                user.setName(result.getString(2));
                user.setRealName(result.getString(4));
                user.setEmail(result.getString(5));
                user.setRole(result.getInt(6));
                user.setState(result.getInt(7));
            }
        } catch (SQLException e) {
            System.err.println("从数据库取数据时出错！");

            e.printStackTrace();
        }

        return user;
    }

//    class PageSelectSetter extends StatementCallback {
//
//    }

//    public Page<User> queryPagination(int pageNo, int pageSize) {
//        DB db = new DB();
//        ResumeDAO.SelectSetter selectSetter = new ResumeDAO.SelectSetter(pageNo-1, pageSize);
//        // SQL中是0基的
//
//        CachedRowSet records = db.select("SELECT * FROM TB_RESUME_BASICINFO LIMIT ?,?", selectSetter);
//
//        Vector<Resume> resumes = new Vector<>();
//
//        try {
//            while (records.next()) {
//                Resume resume = new Resume();
//
//                resume.setId(records.getInt(1));
//                resume.setRealName(records.getString(3));
//                resume.setGender(records.getString(4));
//                resume.setBirthday(records.getDate(5));
//                resume.setCurrentLocation(records.getString(6));
//                resume.setResidentLocation(records.getString(7));
//                resume.setPhone(records.getString(8));
//                resume.setEmail(records.getString(9));
//                resume.setIntention(records.getString(10));
//                resume.setExperience(records.getString(11));
//                resume.setAvatar(records.getString(12));
//
//                resumes.add(resume);
//            }
//        } catch (SQLException e) {
//            System.err.println("从数据库取数据时出错！");
//
//            e.printStackTrace();
//        }
//
//        Page<Resume> page = new Page<>(pageNo, pageSize, resumes);
//        int recordCount = 0;
//        CachedRowSet count = db.select("SELECT COUNT(*) FROM TB_RESUME_BASICINFO");
//
//        db.close();
//
//        try {
//            if (count.next()) {
//                recordCount = count.getInt(1);
//            }
//        } catch (SQLException e) {
//            System.err.println("从数据库取数据个数时出错！");
//
//            e.printStackTrace();
//        }
//
//        page.setTotalPages(Pagination.paginate(recordCount, pageSize));
//        if (pageNo == 1) {
//            page.setPrevStatus(false);
//        } else {
//            page.setPrevStatus(true);
//        }
//        if (page.getTotalPages() <= pageNo) {
//            page.setNextStatus(false);
//        } else {
//            page.setNextStatus(true);
//        }
//
//        return page;
//    }
}
