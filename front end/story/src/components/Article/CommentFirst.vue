<template>
  <div class="main_box1">
    <!-- 一级评论 组件 -->
    <div class="box_header">
      <div class="box_user">
        <div class="user_avatar">
          <img :src="avatar">
        </div>
        <div class="box_user_right">
          <div class="user_name">
            {{Cinfo.author}}
            <span>说道 :</span>
          </div>
          <div class="comment_date">2020年8月22日</div>

          <div class="comment_reply" @click="reply">@回复</div>
          <div class="comment_info">
            <svg
              xmlns="http://www.w3.org/2000/svg"
              class="icon"
              viewBox="0 0 1024 1024"
              width="20"
              height="20"
              t="1598102497601"
              p-id="3533"
              version="1.1"
              @click="spreadMore"
            >
              <path
                fill="#515151"
                d="M 896 128 H 128 a 32 32 0 0 0 -32 32 v 576 a 32 32 0 0 0 32 32 h 288 v -64 H 160 V 192 h 704 v 512 h -256 c -8.832 0 -16.832 3.584 -22.656 9.376 l -159.968 160 l 45.248 45.248 L 621.248 768 H 896 a 32 32 0 0 0 32 -32 V 160 a 32 32 0 0 0 -32 -32"
                p-id="3534"
              ></path>
              <path
                fill="#515151"
                d="M 560 448 a 48 48 0 1 0 -95.968 -0.032 A 48 48 0 0 0 560 448 M 240 448 a 48 48 0 1 0 95.968 0.032 A 48 48 0 0 0 240 448 M 784 448 a 48 48 0 1 0 -95.968 -0.032 A 48 48 0 0 0 784 448"
                p-id="3535"
              ></path>
            </svg>
          </div>
        </div>
      </div>
      <div class="box_content">
        {{Cinfo.article}}
      </div>
      <transition name="second_show">
        <myCommentSecond v-show="this.secondFlag"></myCommentSecond>
      </transition>
    </div>
  </div>
</template>

<script>
import myCommentSecond from "@/components/Article/CommentSecond";
export default {
  name: "myCommentFirst",
  props:['Cinfo'],
  data() {
    return {
      num: 12,
      avatar:
        "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1141259048,554497535&fm=26&gp=0.jpg",
      secondFlag: false,
    };
  },
  methods: {
    spreadMore() {
      this.secondFlag = !this.secondFlag;
    },
    reply(){
        this.$store.commit('setToWho','回复'+this.Cinfo.author);
     
    }
  },
  components: { myCommentSecond }
};
</script>

<style lang="less" scoped>
.main_box1 {
  width: 740px;
  padding: 0px 30px;
  padding-bottom: 30px;
  height: auto;
  color: #7d7d7d;
}
.box_header {
  span {
    font-size: 18px;
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
  letter-spacing: 1px;
}

.second_show-enter-active,
.second_show-leave-active {
  transition: all 1s ease;
}
.second_show-enter,
.second_show-leave-to {
  opacity: 0;
}

.comment_reply:hover{
    cursor: pointer;
}
</style>