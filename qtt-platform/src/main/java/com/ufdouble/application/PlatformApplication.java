package com.ufdouble.application;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.WebApplicationInitializer;

import com.kcfy.platform.server.kernal.servlet.ConvertServlet;

@SpringBootApplication
@ImportResource("classpath:spring-context.xml")
@Configuration
public class PlatformApplication extends SpringBootServletInitializer implements 
EmbeddedServletContainerCustomizer,WebApplicationInitializer {


    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = SpringApplication.run(PlatformApplication.class, args);

        System.out.println("Let's inspect the beans provided by Spring Boot:");

        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName+"->"+ctx.getBean(beanName).getClass().getName());
        }
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(PlatformApplication.class);
    }

    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
    	container.setContextPath("/qtt-platform");
    }
    
    @Bean
    public ConvertServlet convertServlet() {
        return new ConvertServlet();
    }

    @Bean(name = "convert-servlet-register-bean")
    public ServletRegistrationBean dispatcherServletRegistration() {
        ServletRegistrationBean registration = new ServletRegistrationBean(convertServlet());
        registration.addUrlMappings("/extapi/*");
        Map<String,String> params = new HashMap<String,String>();
        registration.setInitParameters(params);
        return registration;
    }
}
