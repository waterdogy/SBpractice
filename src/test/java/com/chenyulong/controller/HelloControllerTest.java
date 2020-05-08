package com.chenyulong.controller;


import com.alibaba.fastjson.JSON;
import com.chenyulong.entity.CoreUser;
import com.chenyulong.service.CoreUserService;
import com.chenyulong.starter;
import com.chenyulong.util.CodeMsg;
import com.chenyulong.util.ResultMsg;
import com.chenyulong.web.HelloController;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


//@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
//@SpringBootTest(classes = starter.class)
public class HelloControllerTest {
    @Mock
    private CoreUserService coreUserService;

    private MockMvc mockMvc;

    @InjectMocks
    private HelloController helloController;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(helloController).build();
    }

    @Test
    public void testGetUser() throws Exception{
        CoreUser coreUser = new CoreUser();
        coreUser.setCode("202");
        coreUser.setName("Hello");

        Mockito.when(coreUserService.queryById(1)).thenReturn(coreUser);

        mockMvc.perform(get("/getUser"))
                .andExpect(content()
                        .json("{\"code\":\"202\",\"name\":\"Hello\"}"));
    }

    @Test
    public void testCheckUser() throws Exception {
        CoreUser coreUser = new CoreUser();
        coreUser.setCode("202");
        coreUser.setName("Hello");

        Mockito.when(coreUserService.queryById(1)).thenReturn(coreUser);

        mockMvc.perform(post("/checkUser")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"code\":\"202\",\"name\":\"Hello\"}"))
                .andExpect(content().string("Yes"));
    }

    @Test
    public void testInsertUser() throws Exception {
        CoreUser coreUser = new CoreUser();
        coreUser.setCode("202");
        coreUser.setName("Hello");
        String userJson = JSON.toJSONString(coreUser);


        Mockito.when(coreUserService.insertUser(coreUser)).thenReturn(101);

        mockMvc.perform(post("/insertUser")
                .contentType(MediaType.APPLICATION_JSON)
                .content(userJson))
                .andExpect(content().string("101"));
    }

    @Test
    public void testValid() throws Exception {
        CoreUser coreUser = new CoreUser();
        long id = 0;
        coreUser.setId(id);
        coreUser.setCode("202");
        coreUser.setName("Hello");
        CoreUser wrongCoreUser = new CoreUser();
        String userJson = JSON.toJSONString(coreUser);
        String userJsonWrong = JSON.toJSONString(wrongCoreUser);
        ResultMsg successMsg = ResultMsg.success("success");
        ResultMsg errorMsg = ResultMsg.error(CodeMsg.SERVER_ERROR);

        mockMvc.perform(post("/valid")
                .contentType(MediaType.APPLICATION_JSON)
                .content(userJson)).andExpect(content().json(JSON.toJSONString(successMsg)));

        mockMvc.perform(post("/valid")
                .contentType(MediaType.APPLICATION_JSON)
                .content(userJsonWrong)).andExpect(content().json(JSON.toJSONString(errorMsg)));

    }
}
