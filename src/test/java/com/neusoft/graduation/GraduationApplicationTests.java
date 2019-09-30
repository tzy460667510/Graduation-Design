package com.neusoft.graduation;

import com.neusoft.graduation.entity.User;
import com.neusoft.graduation.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GraduationApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void contextLoads() {

    }

}
