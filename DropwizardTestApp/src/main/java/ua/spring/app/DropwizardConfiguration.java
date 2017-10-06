package ua.spring.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;

import io.dropwizard.setup.Environment;
import ua.spring.app.post.processor.DropwizardControllerAnnotationBeanPostProcessor;
import ua.spring.app.post.processor.DropwizardHealthCheckBeanPostProcessor;

public class DropwizardConfiguration {
	
	@Autowired
	Environment enviropment;
	
	@Bean
	public BeanPostProcessor dropwizardControllerAnnotationBeanPostProcessor() {
		return new DropwizardControllerAnnotationBeanPostProcessor(enviropment);
	}
	
	@Bean
	public BeanPostProcessor dropwizardHealthCheckBeanPostProcessor() {
		return new DropwizardHealthCheckBeanPostProcessor(enviropment);
	}
}