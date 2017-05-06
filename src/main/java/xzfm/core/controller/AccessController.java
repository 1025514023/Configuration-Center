package xzfm.core.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import xzfm.common.boot.exception.ASS;
import xzfm.common.boot.web.ResponseData;
import xzfm.core.interceptor.AccessInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 * Created by wangxizhong on 17/5/6.
 */
@Deprecated
@RestController
@RequestMapping(value = "/login")
public class AccessController {

    @Autowired
    private AccessInterceptor accessInterceptor;

    @ApiOperation(value = "管理员登录", httpMethod = "POST")
    @RequestMapping(value = "/loginByAdministrator", method = RequestMethod.POST)
    public ResponseData<Object> loginByAdministrator(
            @ApiParam(name = "username", value = "用户名", required = true)
            @RequestParam(name = "username") String username,
            @ApiParam(name = "password", value = "密码", required = true)
            @RequestParam(name = "password") String password
    ) {
        ASS.validateStringNotEmpty(username, "登录用户名不能为空");
        ASS.validateStringNotEmpty(password, "登录密码不能为空");

        HttpServletResponse response =
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        //setting response cookie
        Cookie usernameCookie = new Cookie("access_username", username);
        Cookie passwordCookie = new Cookie("access_passwrod", password);
        response.addCookie(usernameCookie);
        response.addCookie(passwordCookie);

        accessInterceptor.validateAccessIdentityByCookie(new HashMap() {{
            put("username", username);
            put("password", password);
        }});

        return ResponseData.ok(null);
    }
}
