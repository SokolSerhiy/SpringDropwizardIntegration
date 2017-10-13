package ua.spring.app.post.processor;

import javax.ws.rs.ext.Provider;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import io.dropwizard.setup.Environment;

public class DropwizardProviderAnnotationBeanPostProcessor implements BeanPostProcessor{

	private final Environment environment;

	public DropwizardProviderAnnotationBeanPostProcessor(Environment environment) {
		this.environment = environment;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if(bean.getClass().isAnnotationPresent(Provider.class)) {
			environment.jersey().register(bean);
		}
		return bean;
	}
	
	
}
