package ua.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = "ua")
public class SpringConfiguration {

    private final TestConfiguration configuration;

    public SpringConfiguration(TestConfiguration configuration) {
        this.configuration = configuration;
    }

    @Bean(destroyMethod = "close")
    HikariDataSource dataSource(){
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName(configuration.getDb().getClassName());
        dataSource.setJdbcUrl(configuration.getDb().getUrl());
        dataSource.setUsername(configuration.getDb().getUser());
        dataSource.setPassword(configuration.getDb().getPass());
        return dataSource;
    }
}
