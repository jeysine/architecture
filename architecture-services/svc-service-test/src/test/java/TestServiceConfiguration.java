import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
public class TestServiceConfiguration {
	@Configuration
	@Profile("dev")
	@PropertySource({ "classpath:properties/dubbo.properties"})
	static class Dev {
	}

	@Configuration
	@Profile("ci")
	@PropertySource({ "classpath:properties/dubbo.properties"})
	static class Ci {
	}
}