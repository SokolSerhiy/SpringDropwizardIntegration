package ua.health.check;

import com.codahale.metrics.health.HealthCheck;
import ua.spring.app.annotation.DropwizardHealthCheck;

@DropwizardHealthCheck
public class TestHealthCheck extends HealthCheck {

    protected Result check() throws Exception {
        return Result.healthy();
    }
}
