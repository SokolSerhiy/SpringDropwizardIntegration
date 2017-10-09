package ua;

import freemarker.template.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import ua.config.TestConfiguration;
import ua.spring.app.DropwizardApplication;
import ua.spring.app.annotation.EnableDropwizard;

@EnableDropwizard
public class MainApp extends DropwizardApplication<TestConfiguration>{
	
	public static void main(String[] args) throws Exception {
		System.out.println(Configuration.AUTO_DETECT_NAMING_CONVENTION);
		new Configuration();
		Class.forName("freemarker.template.Configuration");
//		start(MainApp.class, args);
	}

	@Override
	public void initialize(Bootstrap<TestConfiguration> bootstrap) {
		bootstrap.addBundle(new SwaggerBundle<TestConfiguration>() {
			@Override
			protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(TestConfiguration configuration) {
				return configuration.getSwaggerBundleConfiguration();
			}
		});
	}
}