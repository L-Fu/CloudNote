package com.liang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author Liang
 */
@MapperScan("com.liang.mapper")
@SpringBootApplication
//@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class CloudNoteApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudNoteApplication.class, args);
    }

}
