<template>
  <div class="main_box">
    <!-- 整合 一级评论  二级评论  发送对话框  -->
    <div class="box_header">
      <span>Comments |</span>
      <!-- 评论条数 从 VUEX 中获取来 -->
      {{this.$store.state.commentCount}} 条评论
    </div>

    <myCommentFirst v-for="(item, index) in comments" :key="index" :FirstComment="item"></myCommentFirst>

    <myCommentArea class="mycomment-area"></myCommentArea>
  </div>
</template>

<script>
import storage from '@/utils/storage';
import myCommentArea from "@/components/article/CommentArea";
import myCommentFirst from "@/components/article/CommentFirst";
import http from '@/utils/http';
export default {
  name: "myUserComment",
  props:['comments'],

  data() {
    return {
      secondFlag: false,
    };
  },
  components: { myCommentArea, myCommentFirst }
};
</script>

<style lang="less" scoped>
.main_box {
  width: 740px;
  padding: 0px 30px;
  padding-bottom: 30px;
  height: auto;
  color: #7d7d7d;
}
.box_header {
  span {
    font-size: 26px;
  }
}

.user_avatar {
  margin-left: 20px;
  position: absolute;
  border: 1px solid #7d7d7d;
  width: 56px;
  height: 56px;
  border-radius: 50%;
  img {
    position: absolute;
    left: 2.5px;
    top: 2px;
    width: 50px;
    height: 50px;
    border-radius: 50%;
  }
}

.user_name {
  position: absolute;
  left: 110px;
  font-size: 18px;
  span {
    margin-left: 10px;
  }
}

.comment_info {
  position: absolute;
  right: 90px;
  margin-top: 20px;
}

.comment_reply {
  position: absolute;
  right: 10px;
  font-size: 18px;
  margin-top: 20px;
  transition: all 0.3s;
}
.comment_reply:hover {
  color: #686ec7;
}

.comment_date {
  position: absolute;
  left: 110px;
  font-size: 18px;
  margin-top: 30px;
  letter-spacing: 2px;
}

.box_user {
  position: relative;
  margin-top: 20px;
  height: 60px;
}
.box_content {
  margin-top: 20px;
  padding-left: 110px;
}

.second_show-enter-active,
.second_show-leave-active {
  transition: all 1s ease;
}
.second_show-enter,
.second_show-leave-to {
  opacity: 0;
}

.mycomment-area {
  transform: translateX(-30px);
}
</style>