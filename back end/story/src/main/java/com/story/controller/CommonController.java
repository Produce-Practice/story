package com.story.controller;

import com.alibaba.fastjson.JSONObject;
import com.story.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class CommonController {

    private static Logger logger = Logger.getLogger(CommonController.class);

    @Autowired
    private UserService userService;


    /**
     * @param jsonObject
     * @return
     */
    @RequestMapping(value = {"/login"}, method = RequestMethod.POST)
    @ResponseBody
    public JSONObject login(@RequestBody JSONObject jsonObject) {

        return userService.login(jsonObject);

    }


    /**
     * 必须为GET方法
     *
     * @return
     */
    @RequestMapping(value = {"/notLogin"}, method = RequestMethod.GET)
    @ResponseBody
    public JSONObject notLogin() {

        return userService.notLogin();

    }

    @RequestMapping(path = "/unauthorized/{message}", method = RequestMethod.GET)
    public JSONObject unauthorized(@PathVariable String message) {

        return userService.unauthorized(message);

    }

    @RequestMapping(value = {"/register"}, method = RequestMethod.POST)
    public JSONObject register(@RequestBody JSONObject message) {

        return userService.register(message);

    }

    @RequestMapping(value = {"/listTypes"}, method = RequestMethod.POST)
    public JSONObject listTypes(@RequestBody JSONObject message) {

        return userService.listTypes(message);

    }

}