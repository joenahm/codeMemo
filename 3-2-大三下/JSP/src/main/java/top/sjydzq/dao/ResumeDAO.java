package top.sjydzq.dao;

import top.sjydzq.javabean.Resume;
import top.sjydzq.utils.DB;
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

    public Vector<Resume> query(int pageNo, int pageSize) {
        DB db = new DB();
        SelectSetter selectSetter = new SelectSetter(pageNo, pageSize);

        CachedRowSet result = db.select("SELECT * FROM TB_RESUME_BASICINFO LIMIT ?,?", selectSetter);
        db.close();

        Vector<Resume> resumes = new Vector<>();

        try {
            while (result.next()) {
                Resume resume = new Resume();

                resume.setId(result.getInt(1));
                resume.setRealName(result.getString(3));
                resume.setGender(result.getString(4));
                resume.setBirthday(result.getDate(5));
                resume.setCurrentLocation(result.getString(6));
                resume.setResidentLocation(result.getString(7));
                resume.setPhone(result.getString(8));
                resume.setEmail(result.getString(9));
                resume.setIntention(result.getString(10));
                resume.setExperience(result.getString(11));
                resume.setAvatar(result.getString(12));
            }
        } catch (SQLException e) {
            System.err.println("从数据库取数据时出错！");

            e.printStackTrace();
        }

        return resumes;
    }
}
