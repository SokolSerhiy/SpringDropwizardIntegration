package ua.spring.app.post.processor;

import io.dropwizard.setup.Environment;

import javax.ws.rs.Path;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;

public class DropwizardPathAnnotationBeanPostProcessor implements BeanPostProcessor {

    private final Environment environment;

    public DropwizardPathAnnotationBeanPostProcessor(Environment environment) {
        this.environment = environment;
    }

    @Nullable
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(bean.getClass().isAnnotationPresent(Path.class)){
            environment.jersey().register(bean);
        }
        return bean;
    }
}
