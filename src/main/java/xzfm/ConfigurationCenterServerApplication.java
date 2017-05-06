package xzfm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import xzfm.common.domain.EnableJpaEntityManager;
import xzfm.monitor.EnableDataMonitor;

@EnableDataMonitor
@ServletComponentScan
@SpringBootApplication
@EnableJpaEntityManager
public class ConfigurationCenterServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigurationCenterServerApplication.class, args);
    }
}
