package ua.spring.app.annotation;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.ws.rs.Path;
import javax.ws.rs.ext.Provider;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;

import com.codahale.metrics.health.HealthCheck;

import ua.spring.app.DropwizardConfiguration;

@Retention(RUNTIME)
@Target(TYPE)
@ComponentScan(includeFilters= {
		@Filter(type = FilterType.ASSIGNABLE_TYPE, classes = HealthCheck.class),
		@Filter(Path.class),
		@Filter(Provider.class)
})
@Configuration
@Import(DropwizardConfiguration.class)
public @interface EnableDropwizard {

}
