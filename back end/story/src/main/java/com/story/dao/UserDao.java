package com.story.dao;

import com.alibaba.fastjson.JSONObject;
import com.story.domain.User;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Repository("userDao")
@Mapper
public interface UserDao {

    User getUserByUserAccount(String userAccount);

    JSONObject getRoleByUserAccount(String userAccount);

    List<JSONObject> listUsers();

    void saveUser(JSONObject user);

    Integer updateUser(JSONObject jsonObject);

}