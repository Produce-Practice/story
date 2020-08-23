<template>
  <div>
    <p>{{this.messagedata.title}}</p>
    <myMessage :Cinfo="messagedata" @child-event="toShow"></myMessage>
    <myMessage :Cinfo="messagedata" @child-event="toShow"></myMessage>
    <myMessage :Cinfo="messagedata" @child-event="toShow"></myMessage>


    <el-collapse-transition>
      <div v-show="show3" class="comment_box">
        <myCommentArea class="mycomment"></myCommentArea>
      </div>
    </el-collapse-transition>
  </div>
</template>

<script>
import myMessage from "@/components/MessageCenter/Message";
import myCommentArea from "@/components/Article/CommentArea";
export default {
  name: "message",
  components: { myMessage, myCommentArea },
  props: ["messagedata"],
  data() {
    return {
      show3: false
    };
  },
  methods: {
    toShow() {
      this.show3 = true;
    }
  }
};
</script>

<style lang="less" scoped>
.mycomment {
  transform: scale(0.74);
  position: relative;
  top: -120px;
  left: -95px;
}

.comment_box {
  width: 100%;
  height: 120px;
}

.transition-box {
  margin-bottom: 10px;
  width: 200px;
  height: 100px;
  border-radius: 4px;
  background-color: #409eff;
  text-align: center;
  color: #fff;
  padding: 40px 20px;
  box-sizing: border-box;
  margin-right: 20px;
}
</style>