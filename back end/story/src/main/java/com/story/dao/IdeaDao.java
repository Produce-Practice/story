package com.story.dao;

import com.alibaba.fastjson.JSONObject;
import com.story.domain.User;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Repository("storyDao")
@Mapper
public interface IdeaDao {

    Integer updateIdea(JSONObject jsonObject);

    Integer saveIdea(JSONObject jsonObject);

    Integer deleteIdea(JSONObject jsonObject);

    Integer listIdeas(JSONObject jsonObject);

}
