<template>
  <div>
    <div class="main_box" v-for="(draft,index) in draftList" :key="index">
      <div class="box_header">
        <div class="box_user">
          <div class="user_avatar">
            <img :src="draft.avatar" />
          </div>
          <div class="box_user_right">
            <div class="user_name">
              {{draft.author}}
              <span>草稿 :</span>
            </div>
            <div class="comment_date">2020年8月22日</div>

            <div class="comment_delete" @click="reply">删除</div>
            <div class="comment_reply" @click="reply">去发送</div>
          </div>
        </div>
        <div class="box_content">{{draft.data}}</div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "myDraftinfo",
  data() {
    return {
      draftList: [
        {
          author: 123 ,
          data:
            "今天回回家今天回家今天回家今天回家今天回家今天回家今天回家今天回家今天回家今天回家回家",
          num: 12,
          avatar:
            "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1141259048,554497535&fm=26&gp=0.jpg",
          secondFlag: false
        },
        {
          author: 32322 ,
          data:
            "今天回回家今天回家今天回家今天回家今天回家今天回家今天回家今天回家今天回家今天回家回家",
          num: 23,
          avatar:
            "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1141259048,554497535&fm=26&gp=0.jpg",
          secondFlag: false
        },
        {
          author: 2233 ,
          data:
            "今天回回家今天回家今天回家今天回家今天回家今天回家今天回家今天回家今天回家今天回家回家",
          num: 567,
          avatar:
            "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1141259048,554497535&fm=26&gp=0.jpg",
          secondFlag: false
        }
      ]
    };
  },
  methods: {
    spreadMore() {
      this.secondFlag = !this.secondFlag;
    },
    reply() {
      this.$store.commit("setToWho", "回复" + this.Cinfo.author);
      this.$emit("child-event");
    }
  },

  computed: {
    article: function() {
      return this.data.substring(0, 80) + "...";
    }
  }
};
</script>

<style lang="less" scoped>
.main_box {
  width: 600px;
  padding-bottom: 30px;
  height: auto;
  color: #7d7d7d;
  font-size: 12px;
  box-shadow: 0px 2px 4px 0px rgba(121, 146, 180, 0.54);
}
.box_header {
  padding-top: 10px;
  span {
    font-size: 12px;
  }
}

.user_avatar {
  margin-left: 20px;
  position: absolute;
  width: 45px;
  height: 45px;
  box-shadow: 0px 2px 4px 0px rgba(121, 146, 180, 0.54);
  border-radius: 50%;
  img {
    position: absolute;
    left: 2px;
    top: 2px;
    width: 40px;
    height: 40px;
    border-radius: 50%;
  }
}

.user_name {
  position: absolute;
  left: 80px;
  top: 10px;
  span {
    margin-left: 10px;
  }
}

.comment_info {
  position: absolute;
  right: 90px;
}

.comment_reply {
  position: absolute;
  right: 50px;
  top: 15px;
  font-size: 12px;
  margin-top: 1 0px;
  transition: all 0.3s;
}
.comment_reply:hover {
  color: #686ec7;
  cursor: pointer;
}

.comment_delete {
  position: absolute;
  right: 10px;
  top: 15px;
  font-size: 12px;
  margin-top: 1 0px;
  transition: all 0.3s;
}

.comment_delete:hover {
  color: #686ec7;
  cursor: pointer;
}

.comment_date {
  position: absolute;
  left: 80px;
  font-size: 12px;
  margin-top: 30px;
  letter-spacing: 2px;
}

.box_user {
  position: relative;
  height: 60px;
}
.box_content {
  padding: 0px 20px;
  letter-spacing: 1px;
  line-height: 15px;
}

.second_show-enter-active,
.second_show-leave-active {
  transition: all 1s ease;
}
.second_show-enter,
.second_show-leave-to {
  opacity: 0;
}
</style>