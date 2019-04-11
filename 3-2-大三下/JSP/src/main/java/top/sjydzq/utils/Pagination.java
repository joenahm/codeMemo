package top.sjydzq.utils;

import javax.sql.rowset.CachedRowSet;
import java.sql.SQLException;

public abstract class Pagination {
    public static int paginate(int totalPages, int pageSize) {
        return  (int)Math.ceil((float) totalPages/(float) pageSize);
    }

    public static int getRecordCount(CachedRowSet resultSet) {
        int recordCount = 0;

        try {
            if (resultSet.next()) {
                recordCount = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            System.err.println("从数据库获取数据个数时出错！");

            e.printStackTrace();
        }

        return recordCount;
    }
}
