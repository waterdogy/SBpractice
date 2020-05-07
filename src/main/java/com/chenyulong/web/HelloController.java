package com.chenyulong.web;

import com.chenyulong.entity.CoreUser;
import com.chenyulong.entity.Demo;
import com.chenyulong.entity.Properties;
import com.chenyulong.service.CoreUserService;
import com.chenyulong.util.ResultMsg;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class HelloController {

    @Autowired
    private Properties properties;

    @Autowired
    private CoreUserService coreUserService;

    @RequestMapping("/")
    public String hello(){
        return "Hello World!";
    }

    @RequestMapping("/getDemo")
    public Demo getDemo(){
        Demo demo = new Demo();
        demo.setId(1);
        demo.setName("Pony");
        return demo;
    }

    @RequestMapping("/getProperty")
    public String properties(){
        return properties.getHello();
    }

    @RequestMapping(value = "/getUser")
    public CoreUser getUser(){
        CoreUser coreUser = coreUserService.queryById(1);
        System.out.println(coreUser.getCode()+coreUser.getName());
        return coreUser;
    }

    @RequestMapping(value = "/getAllUser")
    public List<CoreUser> getAllUser(){
        PageHelper.startPage(1,1);
        return coreUserService.queryAll();
    }

    @PostMapping(value = "/checkUser")
    public String checkUser(@RequestBody CoreUser jsonObject,
                            HttpServletRequest request){
        CoreUser coreUser = coreUserService.queryById(1);
        String ans = "No";
        if (coreUser.getName().equals(jsonObject.getName())) {
            ans = "Yes";
        }
        System.out.println(ans);
        return ans;
    }

    @PostMapping(value = "/insertUser")
    public String insertUser(@RequestBody CoreUser coreUser) {
        long id = coreUserService.insertUser(coreUser);
        return String.valueOf(id);
    }

    @GetMapping(value = "/insertDupUser")
    public ResultMsg<String> insertDupUser() {
        CoreUser coreUser = new CoreUser();
        coreUser.setName("Hello");
        coreUser.setCode("202");

        coreUserService.insertUser(coreUser);
        return ResultMsg.success("success");
    }


}
