<template>
  <div>
    <div class="message_box">

      <!-- 左边侧边导航 -->
      <div class="left-sidebar">
        <div class="logo">
          <a href="index.html">
            <img src="@/assets/logo1.png" title="logo">
          </a>
          <h1>Message site</h1>
        </div>
        <div class="top-nav">
          <ul>
            <li>
              <router-link to="/">首页</router-link>
            </li>
            <li>
              <router-link to="/user/messageCenter/info" @click.native="replyme">回复我的</router-link>
            </li>
            <li>
              <router-link to="/user/messageCenter/info" @click.native="atme">@我的</router-link>
            </li>
            <li>
              <router-link to="/user/messageCenter/info" @click.native="praiseme">收到的赞</router-link>
            </li>
          </ul>
        </div>
      </div>
      <div class="message-content-head">
        <span>{{ this.message }}</span>
      </div>
      <!-- 左边导航结束 -->

      <!-- 右边内容区域  子路由 -->
      <transition name="mess-content">
        <div class="message-content">
          <router-view :messagedata="datadetails"></router-view>
        </div>
      </transition>
      <!-- 内容区域结束 -->
      
    </div>
    <Footer></Footer>
  </div>

</template>

<script>
import storage from '@/utils/storage';
import http from '@/utils/http';
import Footer from "@/components/Footer.vue";
export default {
  name: "messageCenter",

  components: {
    Footer
  },

  data() {
    return {
      message: "回复我的",
      datadetails: ""
    };
  },

  methods: {
    replyme() {
      this.message = "回复我的";
      this.$axios({
        methods: "get",
        url: "/parameter/demoList"
      }).then(res => {
        this.datadetails = res.data.comments;
        console.log(this.datadetails);
      });
    }
  }
};
</script>

<style lang="less" scoped>
 .message_box {
  margin-top: 50px;
  width: 800px;
  padding-bottom: 30px;
  height: 500px;
  // position: absolute;
  position: relative;
  left: 45%;
  transform: translateX(-50%);
}
.left-sidebar {
  position: absolute;
  background: #fff;
  border-bottom: 10px solid #42b983;
  width: 200px;
}
.logo {
  text-align: center;
  padding: 24px 10px;
  background: #42b983;
}
.logo h1 {
  font-family: "Merriweather Sans", sans-serif;
  font-size: 0.8em;
  color: #fff;
  margin-top: 6px;
}
.top-nav {
  background: #fff;
  font-family: "Merriweather Sans", sans-serif;
  font-size: 0.8em;
}
.top-nav ul li a {
  color: rgb(80, 80, 80);
  font-weight: bold;
  font-size: 1em;
  font-family: "Merriweather Sans", sans-serif;
  display: inline-block;
  -webkit-transition: all 0.5s;
  -moz-transition: all 0.5s;
  -o-transition: all 0.5s;
  -ms-transition: all 0.5s;
  transition: all 0.5s;
  padding: 18px;
  display: block;
}
.top-nav ul li a:hover {
  background: rgba(223, 223, 223, 0.98);
  color: #42b983;
}
.message-content-head {
  position: relative;
  left: 220px;
  width: 630px;
  height: 42px;
  border-radius: 4px;
  color: #666;
  padding: 0 16px;
  box-shadow: 0px 2px 4px 0px rgba(121, 146, 185, 0.54);
  span {
    line-height: 42px;
    font-size: 14px;
  }
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
</style>