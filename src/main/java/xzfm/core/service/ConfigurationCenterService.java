package xzfm.core.service;

import xzfm.core.domain.dto.ConfigurationCenterDto;

import java.util.List;

/**
 * Created by wangxizhong on 17/4/24.
 */

public interface ConfigurationCenterService {

    List<ConfigurationCenterDto> getAllConfiguration();

    void deleteConfigurationById(String configurationId);

    List<ConfigurationCenterDto> getConfigurationDetailByKey(String configurationKey);

    void updateConfigurationDetailById(String configurationId, String configurationKey, String configurationValue,
                                       String type, String status,int ttl);
}
