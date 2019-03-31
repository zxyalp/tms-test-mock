package com.hello.tms.mock.service;

import com.hello.tms.mock.model.User;
import com.hello.tms.mock.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testHasMatchUser(){
        boolean b1 = userService.hasMatchUser("admin", "123456");
        boolean b2 = userService.hasMatchUser("admin", "1111");
        Assert.assertTrue(b1);
        Assert.assertTrue(!b2);
    }


    @Test
    public void testFindUserByUserName(){
        User user = userService.findUserByUserName("admin");
        Assert.assertEquals(user.getUserName(), "admin");
    }

    @Test
    public void testAddLoginLog(){
        User user = userService.findUserByUserName("admin");
        user.setUserId(1);
        user.setUserName("admin");
        user.setLastIp("192.168.108.121");
        user.setLastVisit(new Date());
        userService.loginSuccess(user);
    }

}
