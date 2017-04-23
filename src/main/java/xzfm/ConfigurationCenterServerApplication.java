package xzfm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import xzfm.monitor.EnableDataMonitor;

@EnableDataMonitor
@SpringBootApplication
public class ConfigurationCenterServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigurationCenterServerApplication.class, args);
	}
}
