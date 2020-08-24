package com.story.service;

import com.alibaba.fastjson.JSONObject;

public interface CommentService {
    JSONObject saveComment(JSONObject message);

    JSONObject listCommentsByIdeaId(JSONObject jsonObject);

    JSONObject updateComment(JSONObject jsonObject);

    JSONObject deleteComment(JSONObject jsonObject);

    JSONObject notifyMessages(JSONObject jsonObject);
}
