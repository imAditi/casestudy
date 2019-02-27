package com.example.casestudyapp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * this is responsible for web layer configuration like
 * static resource, view resolver etc
 * @author gunjan.khatri
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages= {"com.yash"})
public class SpringWebConfig extends WebMvcConfigurerAdapter{

}
