package top.sjydzq.www.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class AccountDAOImpl implements AccountDAO {
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int update(String sql, Object[] params) {
        return jdbcTemplate.update(sql, params);
    }
}
