<template>
  <div>
    <div class="message-content-head">
      <span>已发送</span>
    </div>
    <myRecordinfo :Cinfo="messagedata" @child-event="toSend"></myRecordinfo>
    <myRecordinfo :Cinfo="messagedata" @child-event="toSend"></myRecordinfo>
    <myRecordinfo :Cinfo="messagedata" @child-event="toSend"></myRecordinfo>

    <div class="pagination">
      <el-pagination
        background
        layout="prev, pager, next"
        :page-count="pageCount"
        :current-page="currentPage"
        :page-size="3"
        @current-change="currentchange"
      ></el-pagination>
    </div>
  </div>
</template>

<script>
import myRecordinfo from "@/components/createCenter/RecordInfo";
import myComment from "@/components/article/CommentArea";
export default {
  name: "message",
  components: { myRecordinfo, myComment },
  data() {
    return {

      show3: false,
      pageCount: 7,
      currentPage: 1,
      messagedata: {
        title: "好标题"
      }
    };
  },
  methods: {
    
    toSend() {

      alert("去创造中心发送");
    
    },
    currentchange: function(currentPage) {

      this.currentPage = currentPage;
      console.log(this.currentPage);
      console.log("发送http请求");
    
    }
  
  },
  beforeMount() {
      //
  }
};
</script>

<style lang="less">
.el-pagination {
  width: 500px;
}
</style>


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

.pagination {
  width: 400px;
  padding-left: 100px;
  padding-top: 30px;
}
.message-content-head {
  position: relative;
  width: 600px;
  height: 42px;
  border-radius: 4px;
  color: #666;
  padding: 0 16px;
  box-shadow: 0px 2px 4px 0px rgba(121, 146, 185, 0.54);
  span {
    line-height: 42px;
    font-size: 14px;
  }
  margin-bottom: 20px;
}
</style>