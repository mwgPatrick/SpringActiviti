package com.example.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * WebSecurityConfig
 *
 * @author mawengang
 * @date 2019/12/10 14:10
 */
@Configuration
public class WebSecurityConfig implements WebMvcConfigurer {

    private Logger logger = LoggerFactory.getLogger(WebSecurityConfig.class);
    /**
     * 登录session key
     */
    public final static String SESSION_KEY = "user";

    @Bean
    public SecurityInterceptor getSecurityInterceptor() {
        return new SecurityInterceptor();
//        return null;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration addInterceptor = registry.addInterceptor(getSecurityInterceptor());
        // 排除配置
        addInterceptor.excludePathPatterns("/error");
        addInterceptor.excludePathPatterns("/login**");
        addInterceptor.excludePathPatterns("/static/**");
        // 拦截配置
        addInterceptor.addPathPatterns("/**");
    }

    private class SecurityInterceptor extends HandlerInterceptorAdapter {
        @Override
        public boolean preHandle(HttpServletRequest request,
                                 HttpServletResponse response, Object handler) throws Exception {
//            String user = request.getSession().getAttribute(SESSION_KEY).toString();
            if (request.getSession().getAttribute(SESSION_KEY)==null)  {
                response.sendRedirect("/login");
                logger.info("请登录后使用!");
                return false;
            }
            logger.info("当前登录用户：{}", request.getSession().getAttribute(SESSION_KEY).toString());
            return true;
        }

        @Override
        public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//            logger.info("postHandle...");
        }

        @Override
        public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//            logger.info("afterCompletion...");
        }
//        @Override
//        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//                throws Exception {
//            HttpSession session = request.getSession();
//            if (session.getAttribute(SESSION_KEY) != null){
//                return true;
//            }
//            // 跳转登录
//            String url = "/login";
//            response.sendRedirect(url);
//            return false;
//        }
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //其他静态资源，与本文关系不大
        registry.addResourceHandler("/upload/**").addResourceLocations("classpath:/upload/");

        //需要配置1：----------- 需要告知系统，这是要被当成静态文件的！
        //第一个方法设置访问路径前缀，第二个方法设置资源路径
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }
}