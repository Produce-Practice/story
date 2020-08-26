<template>
  <div class="public">
    <div class="form">
      <el-form ref="form" :model="form" label-width="80px">
        <el-form-item>
          <span class="do">发布想法</span>
        </el-form-item>
        <el-form-item label="想法类型">
          <el-select v-model="form.region" placeholder="请选择想法类型" @change="select"> 
            <!-- <el-option label="书评" value="book"></el-option>
            <el-option label="乐评" value="music"></el-option>
            <el-option label="影评" value="video"></el-option>
            <el-option label="随笔" value="note"></el-option> -->
            <el-option 
              v-for="(item, index) in typeList" 
              :key="parseInt(index)"
              :label="item.typeName"
              :value="parseInt(item.typeId)"
            >
            </el-option>
          </el-select>
        </el-form-item>
        <!-- <el-form-item label="活动性质">
    <el-checkbox-group v-model="form.type">
      <el-checkbox label="美食/餐厅线上活动" name="type"></el-checkbox>
      <el-checkbox label="地推活动" name="type"></el-checkbox>
      <el-checkbox label="线下主题活动" name="type"></el-checkbox>
      <el-checkbox label="单纯品牌曝光" name="type"></el-checkbox>
    </el-checkbox-group>
  </el-form-item>
  <el-form-item label="特殊资源">
    <el-radio-group v-model="form.resource">
      <el-radio label="线上品牌商赞助"></el-radio>
      <el-radio label="线下场地免费"></el-radio>
    </el-radio-group>
        </el-form-item>-->
        <el-form-item>
          <el-button type="primary" @click.native="publish()">发布</el-button>
          <el-button @click.native="cancel()">取消</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>

import http from '@/utils/http';
import storage from '@/utils/storage';

export default {

  data() {
    
    return {
      form: {
        name: "",
        region: "",
        date1: "",
        date2: "",
        delivery: false,
        type: [],
        resource: "",
        desc: ""
      },
      typeList: [],
      selectedType: [],
      status: null

    };
  },

  created() {

    console.log(this.$store.getters.getTypeList)

    this.typeList = JSON.parse(this.$store.getters.getTypeList);

    // this.typeList.push({
    //   typeId: 1,
    //   typeName: '音乐'
    // })

  },

  methods: {

    select(item) {

      storage.set("typeId", item);
      this.$store.commit('keepArticleType', storage.get('typeId'));

    },

    publish() {

      var _this = this;

      var user = JSON.parse(_this.$store.getters.getUser);
      var article = JSON.parse(_this.$store.getters.getArticle);

      console.log("article:" + article);

      console.table(article);

      if (article.visibility == 1) {  // 修改

        this.status = "update";

      } else {

        
        this.status = "post";

      }

      http({

            // 假设后台需要的是表单数据这里你就可以更改
            headers: {

            "Content-Type": "application/json;charset=UTF-8"
            
            },

            method: 'post',
            url: 'http://localhost:8080/idea/ideaPost',

            data: {

                ideaId: article.ideaId,
                typeId: article.typeId,
                title: article.title,
                content: article.content,
                typeId: article.typeId,
                visibility: article.visibility,
                likes: article.likes,
                visits: article.visits,
                status: _this.status

            },

            responseType: 'json'

            }).then(function (res) {

                console.log(res);

                var code = res.code;
                var info = res.info;

                storage.remove("artile");

                storage.remove("typeId");

                if (res.code == 200) {
                
                    _this.$message.success("提交成功！");
                    _this.$router.replace("/user/createCenter/draft");
                
                } else {
                    
                    _this.$message.error(info);

                }

            }).catch(function (err) {

              _this.$message.error("系统错误！");
        
        });

    },

    cancel() {

      this.$router.push("/user/createIdea");
    
    }
  
  }

};
</script>

<style lang="less" scoped>
.public {
  // background: rgba(94, 91, 91, 0.8);
  // position: fixed;
  // z-index: 15;
  // top: 0;
  // left: 0;
  // width: 100%;
  // height: 100%;
  opacity: 0.6;
  background-color: rgb(177, 175, 175);

  bottom: 0;

  left: 0;

  position: fixed;
  width: 100%;
  z-index: 998;
}

.form {
  // position: relative;
  // top: 20px;
  // left: 20px;
  position: absolute;
  transform: translate(-50%, 50%);
  left: 50%;
  right: 50%;
  width: 400px;
  height: 400px;
  background-color: rgb(231, 231, 231);
  z-index: 13;
}

.do {
  font-size: 25px;
  font-weight: bold;
  color: black;
  position: relative;
  top: 15px;
  left: -65px;
}
</style>