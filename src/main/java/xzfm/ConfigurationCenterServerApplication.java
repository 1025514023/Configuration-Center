package xzfm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import xzfm.monitor.EnableDataMonitor;

@EnableDataMonitor
@ServletComponentScan
@SpringBootApplication
public class ConfigurationCenterServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigurationCenterServerApplication.class, args);
	}
}
