package ua.spring.app.annotation;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import ua.spring.app.DropwizardConfiguration;

@Retention(RUNTIME)
@Target(TYPE)
@ComponentScan
@Configuration
@Import(DropwizardConfiguration.class)
public @interface EnableDropwizard {

}
