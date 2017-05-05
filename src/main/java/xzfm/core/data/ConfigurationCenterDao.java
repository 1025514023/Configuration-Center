package xzfm.core.data;

import xzfm.common.domain.BaseDao;
import xzfm.core.domain.ConfigurationCenter;
import xzfm.monitor.datasource.SpringMonitor;

/**
 * Created by wangxizhong on 17/4/24.
 */
public interface ConfigurationCenterDao extends SpringMonitor, BaseDao<ConfigurationCenter, String> {

}
