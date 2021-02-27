package com.broadtext;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author swsm
 * @date 2021/2/27
 */
@SpringBootApplication(exclude = { DruidDataSourceAutoConfigure.class })
@MapperScan({ "com.broadtext.domain.repository.mapper" })
@EnableTransactionManagement
@Slf4j
public class UnionApplication {

    public static void main(String[] args) {
        SpringApplication.run(UnionApplication.class, args);
    }
    
}
