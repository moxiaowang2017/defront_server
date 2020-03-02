package com.interview.defront;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@EnableSwagger2Doc
@SpringBootApplication
public class DefrontApplication {

    public static void main(String[] args) {
        SpringApplication.run(DefrontApplication.class, args);
    }
}
