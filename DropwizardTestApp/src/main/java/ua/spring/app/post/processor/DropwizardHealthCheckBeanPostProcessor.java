package ua.spring.app.post.processor;

import com.codahale.metrics.health.HealthCheck;
import io.dropwizard.setup.Environment;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import ua.spring.app.annotation.DropwizardHealthCheck;

@Component
public class DropwizardHealthCheckBeanPostProcessor implements BeanPostProcessor{

    private final Environment environment;

    public DropwizardHealthCheckBeanPostProcessor(Environment environment) {
        this.environment = environment;
    }

    @Nullable
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(bean.getClass().isAnnotationPresent(DropwizardHealthCheck.class)){
            if(! (bean instanceof HealthCheck)) throw new HealthCheckRegistrationException(String.format("The bean %s must be subtype of HealthCheck", beanName));
            environment.healthChecks().register(beanName, (HealthCheck) bean);
        }
        return bean;
    }

    class HealthCheckRegistrationException extends RuntimeException{
        
		private static final long serialVersionUID = -1043651730682511419L;

		public HealthCheckRegistrationException(String message) {
            super(message);
        }
    }
}
