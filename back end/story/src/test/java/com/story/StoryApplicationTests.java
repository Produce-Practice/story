package com.story;

import com.alibaba.fastjson.JSONArray;
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

    @Test
    void test1() {

        String userAccount = "275518";
        User user = userDao.getUserByUserAccount(userAccount);
        JSONObject message = new JSONObject();

        message.put("userId",user.getUserId());
        List<JSONObject> ideas = ideaDao.listAllIdeasByInvisible(message);

        System.out.println(ideas);

    }

    @Test
    void test4() {

        JSONObject user = new JSONObject();

        user.put("userId", 1);

        List<JSONObject> ideaList = ideaDao.listAllIdeasByVisible(user);

        for (JSONObject idea: ideaList) {

            System.out.println(idea);

        }

//        System.out.println(ideaList);

        System.out.println(ideaList.size());

    }

    @Test
    void hello() {

        JSONObject idea = new JSONObject();

        idea.put("title", "《说好不哭》");

        idea.put("content", "说不哭,眼泪却止不住毕竟曾拥有过你一段路,决定祝福我会算数,就像当初说要爱你,给了全部。");

        idea.put("typeId", 2);

        idea.put("likes", 2);

        idea.put("visits", 20);

        idea.put("userId", 4);

        ideaDao.saveIdea(idea);

    }

    @Test
    void test() {

    }


}
