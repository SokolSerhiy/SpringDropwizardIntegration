package ua.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class TestDao  {

    private final JdbcTemplate template;

    public TestDao(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }
}
