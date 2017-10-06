package ua.spring.app.post.processor;

import io.dropwizard.setup.Environment;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import ua.spring.app.annotation.DropwizardController;

@Component
public class DropwizardControllerAnnotationBeanPostProcessor implements BeanPostProcessor {

    private final Environment environment;

    public DropwizardControllerAnnotationBeanPostProcessor(Environment environment) {
        this.environment = environment;
    }

    @Nullable
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(bean.getClass().isAnnotationPresent(DropwizardController.class)){
            environment.jersey().register(bean);
        }
        return bean;
    }
}
