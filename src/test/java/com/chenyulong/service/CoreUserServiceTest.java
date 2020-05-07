package com.chenyulong.service;

import com.chenyulong.entity.CoreUser;
import com.chenyulong.starter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = starter.class)
public class CoreUserServiceTest {
    @Autowired
    private CoreUserService coreUserService;

    @Test
    public void testInsertUser() {
        CoreUser coreUser = new CoreUser();
        coreUser.setName("Hello");
        coreUser.setCode("202");

        int num = coreUserService.insertUser(coreUser);
        System.out.println(num);
    }

    @Test
    public void testDeleteUser(){
        String deleteCode = "202";
        int num = coreUserService.deleteByCode(deleteCode);
        System.out.println(num);
    }

    @Test
    public void testInsertUserDup() {
//        CoreUser coreUser = new CoreUser();
//        coreUser.setName("Hello");
//        coreUser.setCode("202");
//
//        int num = coreUserService.insertUser(coreUser);
//        System.out.println(num);
    }
}
