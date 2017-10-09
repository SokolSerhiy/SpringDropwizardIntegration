package ua.spring.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Environment;

public class DropwizardApplication<T extends Configuration> extends Application<T>{
	
	@Autowired
	protected T configuration;
	@Autowired
	protected Environment environment;

    public void run(T configuration, Environment environment) throws Exception {
        SpringApplication.run(configuration, environment, this).getBean(AutowiredAnnotationBeanPostProcessor.class);
    }

    public static <T extends Configuration> void start(Class<? extends DropwizardApplication<T>> clazz, String... args) throws Exception{
    	clazz.newInstance().run(args);
    }
    
    
}
