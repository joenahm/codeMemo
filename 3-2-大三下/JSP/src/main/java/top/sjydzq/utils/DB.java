package top.sjydzq.utils;

import java.sql.*;

import com.sun.rowset.CachedRowSetImpl;

import top.sjydzq.config.Config;

public class DB {
    private Connection connection;

    public DB() {
        try {
            Class.forName(Config.DB_DRIVER);
            // 加载驱动

            connection = DriverManager.getConnection(Config.DB_URL, Config.DB_USERNAME, Config.DB_PASSWORD);

            // 创建连接

            if (connection != null) {
                System.out.println("连接成功");
            } else {
                System.err.println("未取得数据库连接！");
            }
        } catch (ClassNotFoundException e) {
            System.err.println("数据库驱动出错！");

            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("数据库连接失败！");

            e.printStackTrace();
        }
    }

    public CachedRowSetImpl select(String sql, StatementCallback statementSetter){
        CachedRowSetImpl cachedRowSet = null;

        try{
            PreparedStatement statement = connection.prepareStatement(sql);

            statementSetter.set(statement);

            ResultSet res = statement.executeQuery();

            cachedRowSet = new CachedRowSetImpl();
            cachedRowSet.populate(res);
        }catch(SQLException e){
            System.err.println("数据库出错！");

            e.printStackTrace();
        }

        return cachedRowSet;
    }

    public static void main(String[] args) {
        DB db = new DB();
    }
}
