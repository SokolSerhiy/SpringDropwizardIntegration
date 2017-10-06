package ua.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.config.TestConfiguration;

import javax.sql.DataSource;

@Repository
public class TestDao  {

    private final JdbcTemplate template;

    public TestDao(DataSource dataSource, TestConfiguration testConfiguration) {
        this.template = new JdbcTemplate(dataSource);
    }
}
