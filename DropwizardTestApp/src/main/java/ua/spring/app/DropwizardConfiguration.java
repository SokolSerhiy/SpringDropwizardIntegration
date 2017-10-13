package ua.spring.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;

import io.dropwizard.setup.Environment;
import ua.spring.app.post.processor.DropwizardPathAnnotationBeanPostProcessor;
import ua.spring.app.post.processor.DropwizardProviderAnnotationBeanPostProcessor;
import ua.spring.app.post.processor.DropwizardHealthCheckBeanPostProcessor;

public class DropwizardConfiguration {
	
	@Autowired
	Environment enviropment;
	
	@Bean
	public BeanPostProcessor dropwizardPathAnnotationBeanPostProcessor() {
		return new DropwizardPathAnnotationBeanPostProcessor(enviropment);
	}
	
	@Bean
	public BeanPostProcessor dropwizardHealthCheckBeanPostProcessor() {
		return new DropwizardHealthCheckBeanPostProcessor(enviropment);
	}
	
	@Bean
	public BeanPostProcessor dropwizardProviderAnnotationBeanPostProcessor() {
		return new DropwizardProviderAnnotationBeanPostProcessor(enviropment);
	}
}