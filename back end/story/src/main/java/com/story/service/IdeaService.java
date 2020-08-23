package com.story.service;

import com.alibaba.fastjson.JSONObject;

public interface IdeaService {

    JSONObject listCommentsByIdeaId(Integer ideaId);

}
