<template>
  <!-- <el-aside> -->
  <div class="createCenter">
    <div class="sider">
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
          <el-menu-item index="1" @click="toPerson">
            <i class="el-icon-s-custom"></i>
            <span slot="title" >个人中心</span>
          </el-menu-item>

          <el-submenu index="2">
            <template slot="title">
              <i class="el-icon-s-opportunity"></i>
              <span>创作中心</span>
            </template>
            <el-menu-item-group>
              <el-menu-item index="2-1" @click="toDraft">草稿箱</el-menu-item>
              <el-menu-item index="2-2" @click="toRecord">已投递</el-menu-item>
            </el-menu-item-group>
          </el-submenu>

          <el-submenu index="3">
            <template slot="title">
              <i class="el-icon-s-comment"></i>
              <span>消息中心</span>
            </template>
            <el-menu-item-group>
              <el-menu-item index="3-1" @click="toReply">@我</el-menu-item>
              <el-menu-item index="3-2" @click="toFavour">收到的赞</el-menu-item>
            </el-menu-item-group>
          </el-submenu>
        </el-menu>
      </el-col>
    </div>
    <div class="router_class">
      <router-view></router-view>
    </div>
    <!-- <Footer></Footer> -->
  </div>
  <!-- </el-aside>     -->
</template>

<script>
import storage from '@/utils/storage';
import Footer from '@/components/Footer.vue'

import http from '@/utils/http';
export default {

  name: "createCenter",

  inject: ["reload"],

  components: {
    Footer
  },

  data() {
    return {
      
    }
  },

  methods: {

    toPerson() {

      this.$router.push("/user/createCenter/personCenter");

    },

    createIdea() {

      this.$router.push("/user/createIdea");

    },

    toReply() {

      this.$router.push("/user/createCenter/messageInfo");

    },
    
    toFavour() {

      this.$router.push("/user/createCenter/favourInfo");

    },

    toDraft() {

      this.$router.push({
        path:'/user/createCenter/draft',
        query:{
        }
      });

    },

    toRecord() {
       this.$router.push({
        path:'/user/createCenter/record',
        query:{
        }
      });
    }


  }
};
</script>

<style scoped lang="less">

// .createCenter {
// }


footer {
  position: absolute;
  bottom: -1250px;
}


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

.sider {
  position: absolute;
  left: 20%;
  transform: translateX(-50%);
}

.router_class{
  width: 800px;
  position: absolute;
  left: 50%;
  transform: translateX(-30%);
}
</style>