package com.lq;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.lq.dao","com.baomidou.mybatisplus.samples.quickstart.mapper"})
public class DevopsApplication implements CommandLineRunner {

    @Value("${server.port:8080}")
    private String serverPort;

    // 日志
    private static final Logger LOGGER = LoggerFactory.getLogger(DevopsApplication.class);


    public static void main(String[] args) {
        SpringApplication.run(DevopsApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        LOGGER.info("DevopsApplication is success, Index >> http:127.0.0.1:{}", serverPort);
        LOGGER.info("DevopsApplication is success, Login Page >> http:127.0.0.1:{}/login", serverPort);
        LOGGER.info("DevopsApplication is success, Swagger Url >> http:127.0.0.1:{}/swagger-ui.html", serverPort);

    }

}

