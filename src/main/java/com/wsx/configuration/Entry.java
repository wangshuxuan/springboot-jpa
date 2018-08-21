package com.wsx.configuration;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author wangshuxuan
 * @date 2018/8/20 12:53
 * 项目启动入口，配置包根路径
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.wsx")
public class Entry {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Entry.class, args);
    }
}
