package com.lq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.lq.devops.dao","com.baomidou.mybatisplus.samples.quickstart.mapper"})
public class DevopsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DevopsApplication.class, args);
    }

}

