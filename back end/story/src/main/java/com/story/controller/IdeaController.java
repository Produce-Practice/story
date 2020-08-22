package com.story.controller;

import com.alibaba.fastjson.JSONObject;
import com.story.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = {"/user/idea"}, method = RequestMethod.POST)
public class IdeaController {

    private static Logger logger = Logger.getLogger(IdeaController.class);


}