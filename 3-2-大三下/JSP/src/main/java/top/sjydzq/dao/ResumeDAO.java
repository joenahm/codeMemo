package top.sjydzq.dao;

import top.sjydzq.javabean.Page;
import top.sjydzq.javabean.Resume;
import top.sjydzq.utils.DB;
import top.sjydzq.utils.Pagination;
import top.sjydzq.utils.StatementCallback;

import javax.sql.rowset.CachedRowSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;

public class ResumeDAO {
    class SelectSetter extends StatementCallback {
        private int pageNo;
        private int pageSize;

        SelectSetter(int pageNo, int pageSize) {
            this.pageNo = pageNo;
            this.pageSize = pageSize;
        }

        public void set(PreparedStatement statement) {
            try {
                statement.setInt(1, pageNo);
                statement.setInt(2, pageSize);
            } catch (SQLException e) {
                System.err.println("为查询简历信息准备分页信息时出错！");

                e.printStackTrace();
            }
        }
    }

    public Page<Resume> queryPagination(int pageNo, int pageSize) {
        DB db = new DB();
        SelectSetter selectSetter = new SelectSetter(pageNo-1, pageSize);
        // SQL中是0基的

        CachedRowSet records = db.select("SELECT * FROM TB_RESUME_BASICINFO LIMIT ?,?", selectSetter);

        Vector<Resume> resumes = new Vector<>();

        try {
            while (records.next()) {
                Resume resume = new Resume();

                resume.setId(records.getInt(1));
                resume.setRealName(records.getString(3));
                resume.setGender(records.getString(4));
                resume.setBirthday(records.getDate(5));
                resume.setCurrentLocation(records.getString(6));
                resume.setResidentLocation(records.getString(7));
                resume.setPhone(records.getString(8));
                resume.setEmail(records.getString(9));
                resume.setIntention(records.getString(10));
                resume.setExperience(records.getString(11));
                resume.setAvatar(records.getString(12));

                resumes.add(resume);
            }
        } catch (SQLException e) {
            System.err.println("从数据库取数据时出错！");

            e.printStackTrace();
        }

        Page<Resume> page = new Page<>(pageNo, pageSize, resumes);
        int recordCount = 0;
        CachedRowSet count = db.select("SELECT COUNT(*) FROM TB_RESUME_BASICINFO");

        db.close();

        try {
            if (count.next()) {
                recordCount = count.getInt(1);
            }
        } catch (SQLException e) {
            System.err.println("从数据库取数据个数时出错！");

            e.printStackTrace();
        }

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
