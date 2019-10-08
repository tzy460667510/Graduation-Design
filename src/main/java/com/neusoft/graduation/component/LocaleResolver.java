package com.neusoft.graduation.component;

import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @ClassName LocaleResolver
 * @Description TODO
 * @Author Alice丶Nakiri
 * @Date 2019/9/16 9:41
 * Version 1.0
 **/
/*
可以在链接上携带区域信息
 */
public class LocaleResolver implements org.springframework.web.servlet.LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String l = request.getParameter("l");
        Locale locale = Locale.getDefault();
        if (!StringUtils.isEmpty(l)) {
            String[] split = l.split("_");
            locale = new Locale(split[0], split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
    }
}
