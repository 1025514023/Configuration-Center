package xzfm.core.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xzfm.common.boot.web.ResponseData;
import xzfm.monitor.datasource.SpringMonitor;

/**
 * Created by wangxizhong on 2017/4/24.
 */
@RestController
@RequestMapping(value = "/server")
public class ServerController implements SpringMonitor {

    @RequestMapping(value = "/getAllConfiguration", method = RequestMethod.POST)
    public ResponseData<Object> getAllConfiguration() {
        return null;
    }

    @RequestMapping(value = "/deleteConfigurationById", method = RequestMethod.DELETE)
    public ResponseData<Object> deleteConfigurationById(
            @RequestParam(name = "id") String id
    ) {
        return null;
    }

    @RequestMapping(value = "/getConfigurationDetailById", method = RequestMethod.POST)
    public ResponseData<Object> getConfigurationDetailById(
            @RequestParam(name = "id") String id) {
        return null;
    }

    @RequestMapping(value = "/updateConfigurationDetailById", method = RequestMethod.POST)
    public ResponseData<Object> updateConfigurationDetailById(
            @RequestParam(name = "id") String id
    ) {
        return null;
    }
}
