import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.env.Environment;
import org.springframework.core.env.SimpleCommandLinePropertySource;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.CountDownLatch;

@SpringBootApplication
@ImportResource({"classpath:spring/application-context-test.xml"})
//@EnableAspectJAutoProxy
public class TestServiceLauncher {
	public static final String SPRING_PROFILE_DEVELOPMENT = "dev";

	private static final Logger logger = LoggerFactory.getLogger(TestServiceLauncher.class);

	@Inject
	private Environment env;

	@Bean
	public CountDownLatch closeLatch() {
		return new CountDownLatch(1);
	}

	@PostConstruct
	public void initApplication() throws IOException {
		if (env.getActiveProfiles().length == 0) {
			logger.info("No Spring profile configured, running with default configuration");
		} else {
			logger.info("Running with Spring profile(s) : {}", Arrays.toString(env.getActiveProfiles()));
			@SuppressWarnings("rawtypes")
			Collection activeProfiles = Arrays.asList(env.getActiveProfiles());
			if (activeProfiles.contains("dev") && activeProfiles.contains("prod")) {
				logger.error("You have misconfigured your application! "
						+ "It should not run with both the 'dev' and 'prod' profiles at the same time.");
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		SpringApplication app = new SpringApplication(TestServiceLauncher.class);
		// non-web env
		app.setWebEnvironment(false);
		SimpleCommandLinePropertySource source = new SimpleCommandLinePropertySource(args);
		addDefaultProfile(app, source);

		ConfigurableApplicationContext ctx = app.run(args);
		Environment env = ctx.getEnvironment();

		logger.info("Wechat Sevice Started with Profiles: " + Arrays.toString(env.getActiveProfiles()));

		// make main thread blocking
		CountDownLatch closeLatch = ctx.getBean(CountDownLatch.class);
		closeLatch.await();
	}

	/**
	 * If no profile has been configured, set by default the "dev" profile.
	 */
	private static void addDefaultProfile(SpringApplication app, SimpleCommandLinePropertySource source) {
		if (!source.containsProperty("spring.profiles.active")
				&& !System.getenv().containsKey("SPRING_PROFILES_ACTIVE")) {
			logger.info("Setting more profile " + SPRING_PROFILE_DEVELOPMENT);
			app.setAdditionalProfiles(SPRING_PROFILE_DEVELOPMENT);
		} else {
			logger.info("NOT Setting more profile");
		}
	}
}
