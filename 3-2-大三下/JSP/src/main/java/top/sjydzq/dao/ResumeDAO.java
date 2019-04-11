package top.sjydzq.dao;

import top.sjydzq.javabean.Page;
import top.sjydzq.javabean.Resume;
import top.sjydzq.utils.DB;
import top.sjydzq.utils.Pagination;
import top.sjydzq.utils.PaginationSetter;
import top.sjydzq.utils.StatementCallback;

import javax.sql.rowset.CachedRowSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;

public class ResumeDAO {
    private Vector<Resume> fetchResume(CachedRowSet resultSet) {
        Vector<Resume> resumes = new Vector<>();

        if (resultSet != null) {
            try {
                while (resultSet.next()) {
                    Resume resume = new Resume();

                    resume.setId(resultSet.getInt(1));
                    resume.setRealName(resultSet.getString(3));
                    resume.setGender(resultSet.getString(4));
                    resume.setBirthday(resultSet.getDate(5));
                    resume.setCurrentLocation(resultSet.getString(6));
                    resume.setResidentLocation(resultSet.getString(7));
                    resume.setPhone(resultSet.getString(8));
                    resume.setEmail(resultSet.getString(9));
                    resume.setIntention(resultSet.getString(10));
                    resume.setExperience(resultSet.getString(11));
                    resume.setAvatar(resultSet.getString(12));

                    resumes.add(resume);
                }
            } catch (SQLException e) {
                System.err.println("从数据库取简历数据时出错！");

                e.printStackTrace();
            }
        }

        return resumes;
    }

    class SelectSetter extends StatementCallback {
        private int  id;

        public SelectSetter(int id) {
            this.id = id;
        }

        public void set(PreparedStatement statement) {
            try {
                statement.setInt(1, id);
            } catch (SQLException e) {
                System.err.println("为查询简历准备信息时出错！");

                e.printStackTrace();
            }
        }
    }

    public Resume query(int id) {
        DB db = new DB();
        SelectSetter selectSetter = new SelectSetter(id);

        CachedRowSet resultSet = db.select("SELECT * FROM TB_RESUME_BASICINFO WHERE BASICINFO_ID=?", selectSetter);
        db.close();

        Resume resume = null;

        Vector<Resume> tmpResumes = this.fetchResume(resultSet);

        if (tmpResumes.size() > 0) {
            resume = tmpResumes.get(0);
        }

        return resume;
    }

    public Page<Resume> queryPagination(int pageNo, int pageSize) {
        DB db = new DB();
        PaginationSetter selectSetter = new PaginationSetter(pageNo-1, pageSize);
        // SQL中是0基的

        CachedRowSet records = db.select("SELECT * FROM TB_RESUME_BASICINFO LIMIT ?,?", selectSetter);

        Vector<Resume> resumes = this.fetchResume(records);

        Page<Resume> page = new Page<>(pageNo, pageSize, resumes);

        CachedRowSet count = db.select("SELECT COUNT(*) FROM TB_RESUME_BASICINFO");

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
