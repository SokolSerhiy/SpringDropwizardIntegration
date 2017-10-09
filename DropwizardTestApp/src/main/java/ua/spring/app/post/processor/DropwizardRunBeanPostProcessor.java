package ua.spring.app.post.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

import ua.spring.app.annotation.EnableDropwizard;

public class DropwizardRunBeanPostProcessor implements BeanPostProcessor{
	
	@Autowired
	DefaultListableBeanFactory context;

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if(bean.getClass().isAnnotationPresent(EnableDropwizard.class)) {
			
		}
		return bean;
	}
}