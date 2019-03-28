//package com.company.spring.boot.nacos.config;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.test.context.junit4.SpringRunner;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class XSpringBootNacosConfigApplicationTests {
//
//    @Test
//    public void contextLoads() {
//
//    }
//
//    @Test
//    public void BCryptPasswordEncoder(){
//        /**
//         * 生成nacos console 控制台密码，使用自定义密码,修改使用自定义密码是为了 集群Nacos
//         * 123456->$2a$10$Z3lDdcEI97pkk7uhc24dfOFOe8wLX6KRPu7IUR1znz/7mvElnzEn6
//         */
//        System.out.println(new BCryptPasswordEncoder().encode("123456"));
//    }
//
//}
