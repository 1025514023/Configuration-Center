package xzfm.core.interceptor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import xzfm.common.boot.exception.ServiceException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangxizhong on 17/5/6.
 */
@Aspect
@Component
public class AccessInterceptor implements InitializingBean {

    @Value("${administrator.username}")
    @NotBlank
    private String username;

    @Value("${administrator.password}")
    @NotBlank
    private String password;

    private Log logger = LogFactory.getLog(getClass());

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Pointcut("execution(* xzfm.core.service..*.*(..))")
    public void aspect() {

    }

    @Around("aspect()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Cookie[] cookies = request.getCookies();

        Map<String, String> accessCookie = getAccessCookieByCookie(cookies);
        validateAccessIdentityByCookie(accessCookie);

        return joinPoint.proceed();
    }

    private Map getAccessCookieByCookie(Cookie[] targetCookie) {
        checkTargetCookieNotNull(targetCookie);

        Map accessCookie = new HashMap();
        for (Cookie cookie : targetCookie) {
            if (cookie.getName().equals("access_username")) {
                accessCookie.put("username", cookie.getValue());
            } else if (cookie.getName().equals("access_password")) {
                accessCookie.put("password", cookie.getValue());
            }
        }
        return accessCookie;
    }

    public void validateAccessIdentityByCookie(Map targetAccessCookie) {
        try {
            if (!targetAccessCookie.get("username").equals(username)
                    || !targetAccessCookie.get("password").equals(password)) {

                throwAccessLoginException();
            }
        } catch (NullPointerException ex) {
            throwAccessLoginException();
        }
    }

    private void checkTargetCookieNotNull(Cookie[] targetCookie) {
        if (targetCookie == null) {
            throwAccessLoginException();
        }
    }

    private void throwAccessLoginException() {
        throw new ServiceException(100, "管理员权限验证失败");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info(
                "Initialization AccessInterceptor Administrator Digest: username:" + username + "    password:" + password);
    }
}
