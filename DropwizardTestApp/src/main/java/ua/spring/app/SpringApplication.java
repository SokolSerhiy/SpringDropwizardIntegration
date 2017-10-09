package ua.spring.app;

import io.dropwizard.Configuration;
import io.dropwizard.setup.Environment;
import org.eclipse.jetty.util.component.AbstractLifeCycle;
import org.eclipse.jetty.util.component.LifeCycle;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringApplication<T extends Configuration, E extends DropwizardApplication<T>> extends AnnotationConfigApplicationContext {

    private SpringApplication(T configuration, Environment environment, E annotatedClass) {
        super(registerDropwizard(configuration, environment));
        this.register(annotatedClass.getClass());
        this.registerStopEvent(environment);
        this.refresh();
    }

	private void registerStopEvent(Environment environment){
        final ConfigurableApplicationContext context = this;
        environment.lifecycle().addLifeCycleListener(new AbstractLifeCycle.AbstractLifeCycleListener() {
            @Override
            public void lifeCycleStopped(LifeCycle event) {
                context.close();
            }
        });
    }

    private static DefaultListableBeanFactory registerDropwizard(Object configuration, Environment environment){
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        beanFactory.registerSingleton("dropwizardConfiguration", configuration);
        beanFactory.registerSingleton("dropwizardEnviropment", environment);
        return beanFactory;
    }

    public static <T extends Configuration, E extends DropwizardApplication<T>> AnnotationConfigApplicationContext run(T configuration, Environment environment, E annotatedClass){
        return new SpringApplication<T, E>(configuration, environment, annotatedClass);
    }
}
