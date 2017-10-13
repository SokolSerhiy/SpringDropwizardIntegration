package ua.health.check;

import com.codahale.metrics.health.HealthCheck;

public class TestHealthCheck extends HealthCheck {

    protected Result check() throws Exception {
        return Result.healthy();
    }
}
