package com.story.domain;

import java.sql.Timestamp;

public class Comment {

    private Integer commentId;

    private String content;

    private Timestamp commentTime;

    //詹一帆改动：8.23===================
    private String ideaId;

    private Integer userId;

    private Integer parentId;
    ///==================================

    public String getIdeaId() {
        return ideaId;
    }

    public void setIdeaId(String ideaId) {
        this.ideaId = ideaId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Timestamp commentTime) {
        this.commentTime = commentTime;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", content='" + content + '\'' +
                ", commentTime=" + commentTime +
                ", ideaId='" + ideaId + '\'' +
                ", userId=" + userId +
                ", parentId=" + parentId +
                '}';
    }
}
