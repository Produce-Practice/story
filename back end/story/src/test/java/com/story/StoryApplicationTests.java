package com.story;

import com.alibaba.fastjson.JSONObject;
import com.story.dao.UserDao;
import com.story.domain.User;
import com.story.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class StoryApplicationTests {

    @Resource
    private UserDao userDao;


    @Autowired
    private UserService userService;


    @Test
    void contextLoads() {
    }

    @Test
    void test() {

        JSONObject cc = new JSONObject();

        cc.put("userName", "sun");
        cc.put("userAccount", "275518");
        cc.put("password", "666");

        userService.register(cc);

    }

}
