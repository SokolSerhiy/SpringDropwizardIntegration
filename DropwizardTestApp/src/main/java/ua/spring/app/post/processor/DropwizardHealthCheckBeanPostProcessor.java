package ua.spring.app.post.processor;

import com.codahale.metrics.health.HealthCheck;
import io.dropwizard.setup.Environment;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;

public class DropwizardHealthCheckBeanPostProcessor implements BeanPostProcessor{

    private final Environment environment;

    public DropwizardHealthCheckBeanPostProcessor(Environment environment) {
        this.environment = environment;
    }

    @Nullable
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof HealthCheck) {
        	environment.healthChecks().register(beanName, (HealthCheck) bean);
        }
        return bean;
    }
}