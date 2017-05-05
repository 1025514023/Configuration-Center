package xzfm.test;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import xzfm.core.domain.ConfigurationCenter;

/**
 * Created by wangxizhong on 2017/5/5.
 */
@RestController
public class TestController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    @Transactional
    public String test() {
        ConfigurationCenter configurationCenter = ConfigurationCenter.create("name", "url", "t", "s");
        return configurationCenter.getConfigurationName();
    }
}
