package xzfm.core.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.models.HttpMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xzfm.common.boot.exception.ASS;
import xzfm.common.boot.web.ResponseData;
import xzfm.core.domain.dto.ConfigurationCenterDto;
import xzfm.core.service.ConfigurationCenterService;
import xzfm.monitor.datasource.SpringMonitor;

import java.util.List;

/**
 * Created by wangxizhong on 2017/4/24.
 */
@RestController
@RequestMapping(value = "/server")
public class ServerController implements SpringMonitor {

    @Autowired
    private ConfigurationCenterService centerService;

    @ApiOperation(value = "获取所有配置中心参数", httpMethod = "POST")
    @RequestMapping(value = "/getAllConfiguration", method = RequestMethod.POST)
    public ResponseData<List<ConfigurationCenterDto>> getAllConfiguration() {

        return ResponseData.ok(centerService.getAllConfiguration());
    }

    @ApiOperation(value = "根据Id删除配置中心参数", httpMethod = "DELETE")
    @RequestMapping(value = "/deleteConfigurationById", method = RequestMethod.DELETE)
    public ResponseData<Object> deleteConfigurationById(
            @ApiParam(name = "configurationId", value = "配置Id", required = true)
            @RequestParam(name = "configurationId") String configurationId
    ) {
        ASS.validateStringNotEmpty(configurationId, "配置Id不能为空");

        centerService.deleteConfigurationById(configurationId);
        return ResponseData.ok(null);
    }

    @ApiOperation(value = "根据Key获取配置中心参数", httpMethod = "PATCH")
    @RequestMapping(value = "/getConfigurationDetailById", method = RequestMethod.POST)
    public ResponseData<List<ConfigurationCenterDto>> getConfigurationDetailByKey(
            @ApiParam(name = "configurationKey", value = "配置Key", required = true)
            @RequestParam(name = "configurationKey") String configurationKey
    ) {
        ASS.validateStringNotEmpty(configurationKey, "配置Id不能为空");

        return ResponseData.ok(centerService.getConfigurationDetailByKey(configurationKey));
    }

    @ApiOperation(value = "根据Id更新配置中心参数", httpMethod = "PATCH")
    @RequestMapping(value = "/updateConfigurationDetailById", method = RequestMethod.PATCH)
    public ResponseData<Object> updateConfigurationDetailById(
            @ApiParam(name = "configurationId", value = "配置Id", required = true)
            @RequestParam(name = "configurationId") String configurationId,
            @ApiParam(name = "configurationKey", value = "配置key", required = true)
            @RequestParam(name = "configurationKey") String configurationKey,
            @ApiParam(name = "configurationValue", value = "配置value", required = true)
            @RequestParam(name = "configurationValue") String configurationValue,
            @ApiParam(name = "type", value = "类型", required = true)
            @RequestParam(name = "type") String type,
            @ApiParam(name = "status", value = "状态", required = true)
            @RequestParam(name = "status") String status,
            @ApiParam(name = "ttl", value = "ttl", required = true)
            @RequestParam(name = "ttl") int ttl

    ) {
        ASS.validateFalse(ttl>0,"ttl不正确");
        ASS.validateStringNotEmpty(type, "配置类型不能为空");
        ASS.validateStringNotEmpty(status, "配置状态不能为空");
        ASS.validateStringNotEmpty(configurationId, "配置Id不能为空");
        ASS.validateStringNotEmpty(configurationKey, "配置key不能为空");
        ASS.validateStringNotEmpty(configurationValue, "配置value不能为空");

        centerService.updateConfigurationDetailById(
                configurationId, configurationKey, configurationValue, type, status,ttl
        );
        return ResponseData.ok(null);
    }
}
