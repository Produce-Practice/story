package com.story.dao;

import com.alibaba.fastjson.JSONObject;
import com.story.domain.Idea;
import com.story.domain.Type;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("storyDao")
@Mapper
public interface IdeaDao {

    Integer updateIdea(JSONObject jsonObject);

    Integer saveIdea(JSONObject jsonObject);

    Integer deleteIdea(JSONObject jsonObject);

    List<JSONObject> listIdeasByUserId(JSONObject jsonObject);

    List<JSONObject> listIdeasByTypeId(JSONObject jsonObject);

    List<JSONObject> listIdeasByTitle(JSONObject jsonObject);

    List<Idea> listAllIdeas();

    JSONObject listOneIdea(JSONObject jsonObject);

    Integer updateIdeaVisibility(JSONObject jsonObject);

    Type getTypeByTypeName(JSONObject jsonObject);

    List<JSONObject> listAllIdeasByVisible(JSONObject message);

    List<JSONObject> listAllIdeasByInvisible(JSONObject message);
}
