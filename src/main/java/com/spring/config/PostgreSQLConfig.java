//package com.spring.config;
//
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Component;
//
//import javax.sql.DataSource;
//import java.sql.Connection;
//import java.sql.Statement;
//
//@Configuration
//public class PostgreSQLConfig implements ApplicationRunner {
//    private final DataSource dataSource;
//    private final JdbcTemplate jdbcTemplate;
//
//    public PostgreSQLConfig(DataSource dataSource,
//                            JdbcTemplate jdbcTemplate) {
//        this.dataSource = dataSource;
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        try (Connection connection = dataSource.getConnection()){
//            System.out.println("[프뚜] > dataSource Class > " + dataSource.getClass());
//            System.out.println("[프뚜] > URL > " + connection.getMetaData().getURL());
//            System.out.println("[프뚜] > userName > " + connection.getMetaData().getUserName());
//
//            Statement statement = connection.createStatement();
//
//        }
//
//        jdbcTemplate.execute("INSERT INTO \"Doc\" VALUES ('TEST_TITLE')");
//    }
//
//}
//
