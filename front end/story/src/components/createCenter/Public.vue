<template>
  <div class="public">
    <div class="form">
      <el-form ref="form" :model="form" label-width="80px">
        <el-form-item>
          <span class="do">发布想法</span>
        </el-form-item>
        <el-form-item label="想法类型">
          <el-select v-model="form.region" placeholder="请选择想法类型">
            <el-option label="书评" value="book"></el-option>
            <el-option label="乐评" value="music"></el-option>
            <el-option label="影评" value="video"></el-option>
            <el-option label="随笔" value="note"></el-option>
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
      }
    };
  },

  methods: {
    publish() {},

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