<template>
  <div class="main_box2">
    <!-- 二级评论组件    -->
    <div class="box_user">
      <div class="user_avatar">
        <img :src="SecondComment.avatar">
      </div>
      <div class="box_user_right">
        <div class="user_name">
          {{SecondComment.author}}
          <span>说道 :</span>
        </div>
        <div class="comment_date">2020年8月22日</div>
        <div class="comment_reply">@回复</div>
      </div>
    </div>
    <div class="box_content">   
        <span class="which_user">@{{SecondComment.father}}:</span>
        {{SecondComment.comment}}
    </div>
  </div>
</template>

<script>
import storage from '@/utils/storage';
export default {
  name: "myComments",
  props:['SecondComment'],
  data() {
    return {
      num: 12,
      avatar:"https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1141259048,554497535&fm=26&gp=0.jpg",

    };
  }
};
</script>

<style lang="less" scoped>
.main_box2{
  margin-top: 30px;
  width: 710px;
  padding: 0px 30px;
  height: auto;
  color: #7d7d7d;
}
.main_box2 {
  span {
    font-size: 16px;
  }
}

.user_avatar {
  margin-left: 20px;
  position: absolute;
  border: 1px solid #7d7d7d;
  top: 5px;
  left: 20px;
  width: 46px;
  height: 46px;
  border-radius: 50%;
  img {
    position: absolute;
    left: 2.5px;
    top: 2px;
    width: 40px;
    height: 40px;
    border-radius: 50%;
  }
}
.user_name {
  position: absolute;
  left: 110px;
  top: 10px;
  font-size: 16px;
  span {
    margin-left: 10px;
  }
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
  font-size: 16px;
  margin-top: 30px;
  letter-spacing: 2px;
}
.which_user {
  margin-right: 10px;
}
.box_user {
  position: relative;
  margin-top: 20px;
  height: 60px;
}
.box_content {
  font-size: 16px;
  padding-left: 110px;
  letter-spacing: 1px;
}

</style>