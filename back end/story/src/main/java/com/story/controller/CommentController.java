package com.story.controller;

import com.alibaba.fastjson.JSONObject;
import com.story.service.CommentService;
import org.apache.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = {"/idea"}, method = RequestMethod.POST)
public class CommentController {
    private static Logger logger = Logger.getLogger(CommentController.class);

    @Autowired
    CommentService commentService;

    // 保存评论
    @RequestMapping(value = {"/saveComment"}, method = RequestMethod.POST)
    @RequiresRoles("user")
    public JSONObject saveComment(@RequestBody JSONObject message) {

        return commentService.saveComment(message);

    }

    // 显示所有评论
    @RequestMapping(value = {"/comments"}, method = RequestMethod.POST)
    public JSONObject comments(@RequestBody JSONObject message) {

        return commentService.listCommentsByIdeaId(message);

    }

    //更新评论
    @RequestMapping(value = {"/updateComment"}, method = RequestMethod.POST)
    public JSONObject updateComment(@RequestBody JSONObject message) {

        return commentService.updateComment(message);

    }

    // 删除评论
    @RequestMapping(value = {"/deleteComment"}, method = RequestMethod.POST)
    public JSONObject deleteComment(@RequestBody JSONObject message) {

        return commentService.deleteComment(message);

    }

}
