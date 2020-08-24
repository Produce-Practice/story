package com.story.dao;

import com.alibaba.fastjson.JSONObject;
import com.story.domain.Idea;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("storyDao")
@Mapper
public interface IdeaDao {

    Integer updateIdea(JSONObject jsonObject);

    Integer saveIdea(JSONObject jsonObject);

    Integer deleteIdea(JSONObject jsonObject);

    List<Idea> listIdeasByUserId(Integer userId, Integer currentBegin, Integer pageSize);

    List<Idea> listIdeasByTypeId(Integer typeId, Integer currentBegin, Integer pageSize);

    List<Idea> listIdeasByTitle(String title, Integer currentBegin, Integer pageSize);

    List<Idea> listAllIdeas();

    Idea listOneIdea(JSONObject jsonObject);

}
