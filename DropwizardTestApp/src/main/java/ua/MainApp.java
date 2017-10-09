package ua;

import ua.config.TestConfiguration;
import ua.spring.app.DropwizardApplication;
import ua.spring.app.annotation.EnableDropwizard;

@EnableDropwizard
public class MainApp extends DropwizardApplication<TestConfiguration>{
	
	public static void main(String[] args) throws Exception {
		start(MainApp.class, args);
	}

	public MainApp() {
		System.out.println("MainApp");
	}
}