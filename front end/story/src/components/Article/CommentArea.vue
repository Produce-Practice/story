<template>
  <div class="main_box2">
    <div class="userComment">
    </div>
    <div style="margin: 0px 0;font-size:18px;color:#656d78">发表评论</div>
    <div class="textarea">
      <el-input
        type="textarea"
        :placeholder="this.$store.state.toWho"
        v-model="textarea"
        maxlength="100"
        show-word-limit
      >hello</el-input>
    </div>
    <div class="footer">
      <el-button>发表评论</el-button>
    </div>
  </div>
</template>

<script>
export default {
  name: "myCommentArea",
  data() {
    return {
      textarea: "",
    };
  }
};
</script>

<style>
.el-textarea__inner {
  min-height: 100px;
  height: 150px;
  color: #656d78;
}
</style>


<style lang="less" scoped>
.main_box2 {
  margin-top: 100px;
  width: 800px;
  padding-bottom: 30px;
  height: auto;
}
.textarea {
  margin-top: 50px;
  min-height: 150px;
}

.footer {
  margin-top: 30px;
  span {
    font-size: 10px;
  }
}
// .el-button:hover{
//     background: #3375FF;
//     color: #fff;
// }
</style>