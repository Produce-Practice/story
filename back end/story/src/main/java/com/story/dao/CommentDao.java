package com.story.dao;

import com.alibaba.fastjson.JSONObject;
import com.story.domain.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("commentDao")
@Mapper
public interface CommentDao {

    Integer saveComment(JSONObject jsonObject);

    List<Comment> findByIdeaIdAndParentCommentNull(String ideaId);

    List<Comment> findByIdeaIdAndParentId(String ideaId, Integer parentId);

    Integer updateComment(JSONObject jsonObject);

    Integer deleteComment(JSONObject jsonObject);

    Integer countComments(String ideaId);

    List<JSONObject> notifyMessages(JSONObject jsonObject);
}
