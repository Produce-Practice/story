<template>
  <!-- <el-aside> -->
  <div class="createCenter">
    <el-col :span="12">
      <div class="header">
        <el-button
          type="primary"
          shape="rectangle"
          class="el-icon-s-promotion"
          @click.native="createIdea()"
        >&nbsp;&nbsp;创作</el-button>
      </div>
      <el-menu default-active="2" class="el-menu-vertical-demo">
        <el-menu-item index="1">
          <i class="el-icon-s-custom"></i>
          <span slot="title">个人中心</span>
        </el-menu-item>

        <el-submenu index="2">
          <template slot="title">
            <i class="el-icon-s-opportunity"></i>
            <span>创作中心</span>
          </template>
          <el-menu-item-group>
            <el-menu-item index="2-1">草稿箱</el-menu-item>
            <el-menu-item index="2-2">已投递</el-menu-item>
          </el-menu-item-group>
        </el-submenu>

        <el-submenu index="3">
          <template slot="title">
            <i class="el-icon-s-comment"></i>
            <span>消息中心</span>
          </template>
          <el-menu-item-group>
            <el-menu-item index="3-1">@我</el-menu-item>
            <el-menu-item index="3-2">收到的赞</el-menu-item>
          </el-menu-item-group>
        </el-submenu>
      </el-menu>
    </el-col>
    <Footer></Footer>
    <!-- <transition name="mess-content">
      <div class="message-content">
        <router-view></router-view>
      </div>
    </transition>-->
  </div>
  <!-- </el-aside>     -->
</template>

<script >
import Footer from "@/components/Footer.vue";
export default {
  name: "createCenter",
  components: {
    Footer
  },
  inject: ["reload"],

  data() {
    return {};
  },

  methods: {
    createIdea() {
      this.$router.push("/user/createIdea");
    }
  }
};
</script>

<style scoped lang="less">
// .createCenter {
// }

.message-content {
  top: 54px;
  width: 630px;
  height: auto;
  min-height: 350px;
  height: auto;
  position: absolute;
  left: 220px;
  padding: 24px 16px;
  box-shadow: 0px 2px 4px 0px rgba(121, 146, 180, 0.54);
  border-radius: 4px;
}
footer{
  bottom: -550px;
}
.el-col-12 {
  width: 200px;
  margin-left: 180px;
}

.el-button {
  padding: 12px 45px;
  font-size: 18px;
  border-radius: 4px;
}

.header {
  border-right: solid 1px rgb(233, 232, 232);
  width: 200px;
  height: 60px;
  text-align: center;
  // font-size: 20px;
  font-weight: bold;
}

.header button {
  margin-top: 5%;
}
</style>