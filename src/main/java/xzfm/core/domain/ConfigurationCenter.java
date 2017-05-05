package xzfm.core.domain;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import xzfm.common.boot.annotation.HibernateDynamic;
import xzfm.common.domain.BaseEntity;
import xzfm.monitor.datasource.SpringMonitor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by wangxizhong on 2017/4/24.
 */
@Entity
@HibernateDynamic
@Table(name = "configuration_center")
public class ConfigurationCenter extends BaseEntity implements SpringMonitor {

    @Column(name = "configuration_name")
    private String configurationName;

    @Column(name = "configuration_url")
    private String configurationUrl;

    @Column
    private String type;

    @Column
    private String status;

    public static final String STATUS_NORMAL = "normal";

    public static final String STATUS_DISABLE = "disable";

    public static final String TYPE_SERVER = "server";

    public static final String TYPE_WEB = "web";

    public static final String TYPE_WECHAT = "weChat";


    public String getConfigurationName() {
        return configurationName;
    }

    public void setConfigurationName(String configurationName) {
        this.configurationName = configurationName;
    }

    public String getConfigurationUrl() {
        return configurationUrl;
    }

    public void setConfigurationUrl(String configurationUrl) {
        this.configurationUrl = configurationUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static ConfigurationCenter create(String configurationName, String configurationUrl, String type,
                                             String status) {
        ConfigurationCenter configurationCenter = new ConfigurationCenter();
        configurationCenter.setConfigurationName(configurationName);
        configurationCenter.setConfigurationUrl(configurationUrl);
        configurationCenter.setType(type);
        configurationCenter.setStatus(status);
        session().persist(configurationCenter);
        return configurationCenter;
    }
}
