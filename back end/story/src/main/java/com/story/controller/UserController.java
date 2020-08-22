package com.story.controller;

import com.alibaba.fastjson.JSONObject;
import com.story.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = {"/user"}, method = RequestMethod.POST)
public class UserController {

    private static Logger logger = Logger.getLogger(CommonController.class);

    @Autowired
    private UserService userService;


    @RequestMapping(value = {"/updatePassword"}, method = RequestMethod.POST)
    public JSONObject updatePassword(@RequestBody JSONObject message) {

        return userService.updatePassword(message);

    }


    @RequestMapping(value = {"/listUsers"}, method = RequestMethod.POST)
    public JSONObject listUsers(@RequestBody JSONObject message) {

        return userService.listUsers(message);

    }

}