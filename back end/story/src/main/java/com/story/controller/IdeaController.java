package com.story.controller;

import com.alibaba.fastjson.JSONObject;
import com.story.domain.Idea;
import com.story.service.IdeaService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = {"/idea"}, method = RequestMethod.POST)
public class IdeaController {

    private static Logger logger = Logger.getLogger(IdeaController.class);

    @Autowired
    private IdeaService ideaService;

    @RequestMapping(value = {"/saveIdea"}, method = RequestMethod.POST)
    public JSONObject saveIdea(@RequestBody JSONObject message) {

        return ideaService.saveIdea(message);

    }

    @RequestMapping(value = {"/updateIdea"}, method = RequestMethod.POST)
    public JSONObject updateIdea(@RequestBody JSONObject message) {

        return ideaService.updateIdea(message);

    }

    @RequestMapping(value = {"/deleteIdea"}, method = RequestMethod.POST)
    public JSONObject deleteIdea(@RequestBody JSONObject message) {

        return ideaService.deleteIdea(message);

    }

    @RequestMapping(value = {"/listIdeasByUserId"}, method = RequestMethod.POST)
    public JSONObject listIdeasByUserId(@RequestBody JSONObject message) {

        return ideaService.listIdeasByUserId(message);

    }

    @RequestMapping(value = {"/listIdeasByTypeId"}, method = RequestMethod.POST)
    public JSONObject listIdeasByTypeId(@RequestBody JSONObject message) {

        return ideaService.listIdeasByTypeId(message);

    }

    @RequestMapping(value = {"/listIdeasByTitle"}, method = RequestMethod.POST)
    public JSONObject listIdeasByTitle(@RequestBody JSONObject message) {

        return ideaService.listIdeasByTitle(message);

    }

    @RequestMapping(value = {"/listIdeasByHeat"}, method = RequestMethod.POST)
    public JSONObject listAllIdeas(@RequestBody JSONObject message) {

        return ideaService.listIdeasByHeat(message);

    }
}