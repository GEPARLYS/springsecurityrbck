package com.springsecurity.test;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Author j
 * @Date 2019/9/8 19:40
 * @Version 1.0
 */
public class Client {
    @Test
    public void fun01(){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String admin = encoder.encode("user");
        System.out.println(admin);
    }
}
