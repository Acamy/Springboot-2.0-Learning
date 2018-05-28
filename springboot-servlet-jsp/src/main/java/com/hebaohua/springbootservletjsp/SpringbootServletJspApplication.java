package com.hebaohua.springbootservletjsp;

import com.hebaohua.springbootservletjsp.registrationServlet.MyFilter2;
import com.hebaohua.springbootservletjsp.registrationServlet.MyServlet2;
import com.hebaohua.springbootservletjsp.registrationServlet.MyServletRequestListener2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@ServletComponentScan(basePackages="com.hebaohua.springbootservletjsp.anotationServlet")
public class SpringbootServletJspApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootServletJspApplication.class, args);
    }

    @Bean
    public static ServletRegistrationBean servletRegistrationBean(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
        servletRegistrationBean.setServlet(new MyServlet2());
        servletRegistrationBean.addUrlMappings("/myservlet2");
        servletRegistrationBean.addInitParameter("paramName2", "myvalue2");
        return servletRegistrationBean;
    }

    @Bean
    public static FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new MyFilter2());
        filterRegistrationBean.addUrlPatterns("/myservlet2");

        return filterRegistrationBean;
    }

    @Bean
    public static ServletListenerRegistrationBean servletListenerRegistrationBean(){
        ServletListenerRegistrationBean servletListenerRegistrationBean = new ServletListenerRegistrationBean();
        servletListenerRegistrationBean.setListener(new MyServletRequestListener2());
        return  servletListenerRegistrationBean;
    }


    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
        builder.sources(SpringbootServletJspApplication.class);
        return builder;
    }
}
