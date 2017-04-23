package xzfm.monitor.datasource;


import com.alibaba.druid.support.http.StatViewServlet;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

/**
 * Created by wangxizhong on 2017/4/19.
 */
@WebServlet(urlPatterns = "/druid/*",
        initParams = {
                //@WebInitParam(name="allow",value="192.168.16.110,127.0.0.1"),
                //@WebInitParam(name="deny",value="192.168.16.111"),
                @WebInitParam(name = "loginUsername", value = "wangxizhong"),
                @WebInitParam(name = "loginPassword", value = "961023"),
                @WebInitParam(name = "resetEnable", value = "false")
        })
public class DruidStatViewServlet extends StatViewServlet {
}
