package com.story.controller;

import com.alibaba.fastjson.JSONObject;
import com.story.constants.Constants;
import com.story.service.CommentService;
import com.story.service.UserService;
import com.story.util.FileUtil;
import com.story.util.JSONUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@CrossOrigin
@RestController
@RequestMapping(value = {"/user"}, method = RequestMethod.POST)
public class UserController {

    private static Logger logger = Logger.getLogger(CommonController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private CommentService commentService;

    @RequestMapping(value = {"/updatePassword"}, method = RequestMethod.POST)
    public JSONObject updatePassword(@RequestBody JSONObject message) {

        return userService.updatePassword(message);

    }


    @RequestMapping(value = {"/listUsers"}, method = RequestMethod.POST)
    public JSONObject listUsers(@RequestBody JSONObject message) {

        return userService.listUsers(message);

    }

    @RequestMapping(value = {"/updateUser"}, method = RequestMethod.POST)
    public JSONObject updateUser(@RequestBody JSONObject message) {

        return userService.updateUser(message);

    }

    @RequestMapping(value = {"/messageCenter"}, method = RequestMethod.POST)
    public JSONObject messageCenter(@RequestBody JSONObject message) {

        return commentService.notifyMessages(message);

    }
    @RequestMapping(value = "/uploadImage", method = RequestMethod.POST)
    public JSONObject uploadImageFile(@RequestParam("img") MultipartFile file) throws IOException {
        File fileDir = new File(Constants.DESTINATION);

        if(!fileDir.exists()) {

            // 如果没有目录应该创建目录
            fileDir.mkdirs();

        }

        // 获取图片名称
        String fileName = file.getOriginalFilename();

        // 生成文件总路径
        String path = Constants.DESTINATION + fileName;

        // 文件实现上传
        file.transferTo(new File(path));

        // 读取文件内容
        String content = FileUtil.readFileContent(path);

        JSONObject encrypt_json = new JSONObject();

        return JSONUtil.successJSON("上传成功");
    }
}