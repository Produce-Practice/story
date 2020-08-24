package com.story.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.story.constants.Constants;
import com.story.dao.CommentDao;
import com.story.domain.Comment;
import com.story.service.CommentService;
import com.story.util.JSONUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("commentService")
@Transactional
public class CommentServiceImpl implements CommentService {

    @Resource
    private CommentDao commentDao;

    // 保存评论
    @Override
    public JSONObject saveComment(JSONObject message) {

        Integer result = commentDao.saveComment(message);
        if (result != 1) {
            return JSONUtil.errorJSON(Constants.INSERT_FAILED);
        } else {
            return JSONUtil.successJSON(Constants.INSERT_SUCCESS);
        }

    }

    // 更新评论：评论内容和时间
    @Override
    public JSONObject updateComment(JSONObject jsonObject) {

        Integer result = commentDao.updateComment(jsonObject);
        if (result != 1) {
            return JSONUtil.errorJSON(Constants.UPDATE_FAILED);
        } else {
            return JSONUtil.successJSON(Constants.UPDATE_SUCCESS);
        }

    }

    // 删除评论
    @Override
    public JSONObject deleteComment(JSONObject jsonObject) {

        Integer result = commentDao.deleteComment(jsonObject);
        if (result != 1) {
            return JSONUtil.errorJSON(Constants.DELETE_FAILED);
        } else {
            return JSONUtil.successJSON(Constants.DELETE_SUCCESS);
        }

    }

    // idea详情页显示所有评论
    @Override
    public JSONObject listCommentsByIdeaId(JSONObject message) {
        String ideaId = message.getString("ideaId");
        List<Comment> comments = commentDao.findByIdeaIdAndParentCommentNull(ideaId);
        List<JSONObject> parentComments = new ArrayList<>();
        for (Comment comment : comments) {
            //System.out.println(comment);
            JSONObject nowComment = JSONObject.parseObject(JSONObject.toJSONString(comment));
            List<Comment> allReplys = new ArrayList<>();
            combineChildren(comment, allReplys);
            //System.out.println(allReplys);
            nowComment.put("childrenComments", allReplys);
            parentComments.add(nowComment);
        }
        if (parentComments.size() > 0) {
            return JSONUtil.successJSON(parentComments);
        } else {
            return JSONUtil.errorJSON(Constants.QUERY_FAILED);
        }
    }

    // 搜寻子评论
    private void combineChildren(Comment comment, List<Comment> allReplys) {
        String ideaId = comment.getIdeaId();
        Integer commentId = comment.getCommentId();
        List<Comment> replys = commentDao.findByIdeaIdAndParentId(ideaId,commentId);
        for (Comment reply : replys) {
            allReplys.add(reply);
            combineChildren(reply, allReplys);
        }
    }

    // 消息中心的消息
    @Override
    public JSONObject notifyMessages(JSONObject jsonObject) {
        List<JSONObject> notifyMessages = commentDao.notifyMessages(jsonObject);
        if (notifyMessages != null) {
            return JSONUtil.successJSON(notifyMessages);
        } else {
            return JSONUtil.errorJSON(Constants.QUERY_FAILED);
        }
    }

    //父子层级关系
    /*private JSONObject combineChildren(List<Comment> comments) {
        JSONObject parentComment = new JSONObject();
        for (int i = 0; i < comments.size(); i++) {
            Comment comment = comments.get(i);
            String ideaId = comment.getIdeaId();
            Integer commentId = comment.getCommentId();
            List<Comment> replys = commentDao.findByIdeaIdAndParentId(ideaId,commentId);
            //递归查找子评论
            JSONObject combineChildren = combineChildren(replys);
            JSONObject nowComment = new JSONObject();
            nowComment.put("comment",comment);
            nowComment.put("childComments",combineChildren);
            parentComment.put(Integer.toString(i),nowComment);
        }
        return parentComment;
    }*/

}
