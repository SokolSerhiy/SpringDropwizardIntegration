package ua.config;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TestConfiguration extends Configuration{

    @NotEmpty
    private String defaultName = "Test";

    private Db db;
    
    @JsonProperty("swagger")
    private SwaggerBundleConfiguration swaggerBundleConfiguration;
    
    public SwaggerBundleConfiguration getSwaggerBundleConfiguration() {
		return swaggerBundleConfiguration;
	}

	public void setSwaggerBundleConfiguration(SwaggerBundleConfiguration swaggerBundleConfiguration) {
		this.swaggerBundleConfiguration = swaggerBundleConfiguration;
	}

	public Db getDb() {
        return db;
    }

    public void setDb(Db db) {
        this.db = db;
    }

    public String getDefaultName() {
        return defaultName;
    }

    public void setDefaultName(String defaultName) {
        this.defaultName = defaultName;
    }

}
