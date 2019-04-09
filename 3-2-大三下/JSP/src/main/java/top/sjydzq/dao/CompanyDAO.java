package top.sjydzq.dao;

import top.sjydzq.javabean.Company;
import top.sjydzq.utils.DB;
import top.sjydzq.utils.StatementCallback;

import javax.sql.rowset.CachedRowSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;

public class CompanyDAO {
    class InsertSetter extends StatementCallback {
        private String name;
        private String area;
        private String size;
        private String type;
        private String brief;
        private int state;
        private int sort;
        private String viewNum;
        private String pic;

        InsertSetter(String name, String area, String size, String type, String brief, int state, int sort, String viewNum, String pic) {
            this.name = name;
            this.area = area;
            this.size = size;
            this.type = type;
            this.brief = brief;
            this.state = state;
            this.sort = sort;
            this.viewNum = viewNum;
            this.pic = pic;
        }

        public void set(PreparedStatement statement) {
            try {
                statement.setString(1, name);
                statement.setString(2, area);
                statement.setString(3, size);
                statement.setString(4, type);
                statement.setString(5, brief);
                statement.setInt(6, state);
                statement.setInt(7, sort);
                statement.setString(8, viewNum);
                statement.setString(9, pic);
            } catch (SQLException e) {
                System.err.println("为插入公司准备信息时出错！");

                e.printStackTrace();
            }
        }
    }

    public boolean save(Company company) {
        DB db = new DB();

        InsertSetter insertSetter = new InsertSetter(
                company.getName(),
                company.getArea(),
                company.getSize(),
                company.getType(),
                company.getBrief(),
                company.getState(),
                company.getSort(),
                company.getViewNum(),
                company.getPic()

        );

        String sql = "INSERT INTO TB_COMPANY(company_name,company_area,company_size,company_type,company_brief,company_state,company_sort,company_viewnum,company_pic) VALUES(?,?,?,?,?,?,?,?,?)";

        boolean status = db.insert(sql, insertSetter);
        db.close();

        return status;
    }

    public Vector<Company> query() {
        DB db = new DB();

        CachedRowSet result = db.select("SELECT * FROM TB_COMPANY");
        db.close();

        Vector<Company> companies = new Vector<>();

        try {
            while (result.next()) {
                Company company = new Company();

                company.setId(result.getInt(1));
                company.setName(result.getString(2));
                company.setArea(result.getString(3));
                company.setSize(result.getString(4));
                company.setType(result.getString(5));
                company.setBrief(result.getString(6));
                company.setState(result.getInt(7));
                company.setSort(result.getInt(8));
                company.setViewNum(result.getString(9));
                company.setPic(result.getString(10));

                companies.add(company);
            }
        } catch (SQLException e) {
            System.err.println("从数据库取数据时出错！");

            e.printStackTrace();
        }

        return companies;
    }
}
