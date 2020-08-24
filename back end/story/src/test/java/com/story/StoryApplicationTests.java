package com.story;

import com.alibaba.fastjson.JSONObject;
import com.story.dao.CommentDao;
import com.story.dao.IdeaDao;
import com.story.dao.UserDao;
import com.story.domain.Comment;
import com.story.domain.Idea;
import com.story.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;

@SpringBootTest
class StoryApplicationTests {

    @Autowired
    private IdeaDao ideaDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private CommentDao commentDao;
    @Test
    void contextLoads() {
    }

    @Test
    void testSaveIdea() {
        Idea idea = new Idea();
        idea.setIdeaId("2");
        idea.setTitle("c");
        idea.setContent("cdf");
        idea.setLikes(100);
        idea.setVisits(1000);
        idea.setTypeId(2);
        idea.setUserId(1);
        String s = JSONObject.toJSONString(idea);
        JSONObject jsonObject = JSONObject.parseObject(s);
        ideaDao.updateIdea(jsonObject);
    }

    @Test
    void testDeleteIdea() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("ideaId",1);
        ideaDao.deleteIdea(jsonObject);
    }

    @Test
    void testListIdea() {
        System.out.println(ideaDao.listAllIdeas());
    }

    @Test
    void testListIdeaByUserId() {
        System.out.println(ideaDao.listIdeasByUserId(4,0,5));
    }

    @Test
    void testListIdeaByTitle() {
        System.out.println(ideaDao.listIdeasByTitle("a",0,5));
    }

    @Test
    void testSaveUser() {
        User user = new User();
        user.setUserAccount("271880");
        user.setUserName("Wen");
        user.setPassword("999");
        user.setRoleId(1);
        String s = JSONObject.toJSONString(user);
        JSONObject jsonObject = JSONObject.parseObject(s);
        userDao.updateUser(jsonObject);
    }

    @Test
    void testListUsers() {
        System.out.println(userDao.listUsers(1,1));
    }

    @Test
    void testGetUserByUserAccount() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userAccount",271880);
        System.out.println(userDao.getUserByUserAccount("271880"));
    }

    @Test
    void testfindByIdeaIdAndParentCommentNull() {
        String ideaId = "1";
        List<Comment> comments = commentDao.findByIdeaIdAndParentCommentNull(ideaId);
        System.out.println(comments);
        for (Comment comment : comments) {
            Integer commentId = comment.getCommentId();
            List<Comment> commentList = commentDao.findByIdeaIdAndParentId(ideaId, commentId);
            System.out.println(commentList);
        }
    }


}
