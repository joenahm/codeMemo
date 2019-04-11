package top.sjydzq.utils;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PaginationSetter extends StatementCallback {
    private int pageNo;
    private int pageSize;

    public PaginationSetter(int pageNo, int pageSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    public void set(PreparedStatement statement) {
        try {
            statement.setInt(1, pageNo);
            statement.setInt(2, pageSize);
        } catch (SQLException e) {
            System.err.println("为查询准备分页信息时出错！");

            e.printStackTrace();
        }
    }
}
