package com.story.serviceImpl;

import com.alibaba.fastjson.JSONObject;
import com.story.constants.Constants;
import com.story.dao.CommentDao;
import com.story.dao.IdeaDao;
import com.story.domain.Idea;
import com.story.service.IdeaService;
import com.story.util.JSONUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

@Service("ideaService")
@Transactional
public class IdeaServiceImpl implements IdeaService {

    @Resource
    private IdeaDao ideaDao;
    @Resource
    private CommentDao commentDao;

    @Override
    public JSONObject saveIdea(JSONObject message) {
        Integer result = ideaDao.saveIdea(message);
        if (result != 1) {
            return JSONUtil.errorJSON(Constants.INSERT_FAILED);
        } else {
            return JSONUtil.successJSON(Constants.INSERT_SUCCESS);
        }
    }

    @Override
    public JSONObject updateIdea(JSONObject message) {
        Integer result = ideaDao.updateIdea(message);
        if (result != 1) {
            return JSONUtil.errorJSON(Constants.UPDATE_FAILED);
        } else {
            return JSONUtil.successJSON(Constants.UPDATE_SUCCESS);
        }
    }

    @Override
    public JSONObject deleteIdea(JSONObject message) {
        Integer result = ideaDao.deleteIdea(message);
        if (result != 1) {
            return JSONUtil.errorJSON(Constants.DELETE_FAILED);
        } else {
            return JSONUtil.successJSON(Constants.DELETE_SUCCESS);
        }
    }

    /**
     * 根据userId查找idea
     */
    @Override
    public JSONObject listIdeasByUserId(JSONObject message) {
        String msg = message.getString("idea");
        Integer currentPage = message.getInteger("currentPage");
        Integer pageSize = message.getInteger("pageSize");
        Integer currentBegin = (currentPage - 1) * pageSize;
        Integer userId = message.getInteger("userId");
        List<Idea> ideas = ideaDao.listIdeasByUserId(userId, currentBegin, pageSize);
        if (ideas != null) {

            return JSONUtil.successJSON(ideas);

        } else {

            return JSONUtil.errorJSON(Constants.QUERY_FAILED);

        }
    }

    /**
     * 根据typeId查找idea

     */
    @Override
    public JSONObject listIdeasByTypeId(JSONObject message) {
        String msg = message.getString("idea");
        Integer currentPage = message.getInteger("currentPage");
        Integer pageSize = message.getInteger("pageSize");
        Integer currentBegin = (currentPage - 1) * pageSize;
        Integer typeId = message.getInteger("typeId");
        List<Idea> ideas = ideaDao.listIdeasByTypeId(typeId, currentBegin, pageSize);
        if (ideas != null) {

            return JSONUtil.successJSON(ideas);

        } else {

            return JSONUtil.errorJSON(Constants.QUERY_FAILED);

        }
    }

    /**
     * 根据idea的title来查找id，用的是%title%
     */
    @Override
    public JSONObject listIdeasByTitle(JSONObject message) {
        Integer currentPage = message.getInteger("currentPage");
        Integer pageSize = message.getInteger("pageSize");
        Integer currentBegin = (currentPage - 1) * pageSize;
        String title = "%" + message.getString("title") + "%";
        List<Idea> ideas = ideaDao.listIdeasByTitle(title, currentBegin, pageSize);
        if (ideas != null) {

            return JSONUtil.successJSON(ideas);

        } else {

            return JSONUtil.errorJSON(Constants.QUERY_FAILED);

        }
    }

    /**
     * 根据热度查找
     */
    @Override
    public JSONObject listIdeasByHeat(JSONObject message) {
        List<Idea> ideaList = ideaDao.listAllIdeas();
        for (Idea idea : ideaList) {
            Integer commentNum = commentDao.countComments(idea.getIdeaId());
            idea.setCommentCount(commentNum);
        }
        //然后通过比较器来实现排序
        ideaList.sort(new Comparator<Idea>() {
            //降序排序
            @Override
            public int compare(Idea idea1, Idea idea2) {
                Integer idea1Heat = idea1.getCommentCount() + idea1.getLikes() + idea1.getVisits();
                Integer idea2Heat = idea2.getCommentCount() + idea2.getLikes() + idea2.getVisits();
                return idea2Heat.compareTo(idea1Heat);
            }
        });
        if (ideaList.size() > 0) {
            return JSONUtil.successJSON(ideaList);
        } else {
            return JSONUtil.errorJSON(Constants.QUERY_FAILED);
        }
    }

}
