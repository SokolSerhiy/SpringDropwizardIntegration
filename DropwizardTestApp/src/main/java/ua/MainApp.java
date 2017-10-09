package ua;

import org.springframework.context.annotation.Bean;

import com.zaxxer.hikari.HikariDataSource;

import io.dropwizard.setup.Bootstrap;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import ua.config.TestConfiguration;
import ua.spring.app.DropwizardApplication;
import ua.spring.app.annotation.EnableDropwizard;

@EnableDropwizard
public class MainApp extends DropwizardApplication<TestConfiguration>{
	
	public static void main(String[] args) throws Exception {
		start(MainApp.class, args);
	}

	@Override
	public void initialize(Bootstrap<TestConfiguration> bootstrap) {
		bootstrap.addBundle(new SwaggerBundle<TestConfiguration>() {
			@Override
			protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(TestConfiguration configuration) {
				return configuration.getSwaggerBundleConfiguration();
			}
        });
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