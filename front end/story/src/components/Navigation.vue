<template>
  <header class="head-section">
    <div class="navbar navbar-default navbar-static-top container">
      <div class="navbar-header">
        <button
          class="navbar-toggle"
          data-target=".navbar-collapse"
          data-toggle="collapse"
          type="button"
        >
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <!-- 项目名 -->
        <a class="navbar-brand" href="/">
          拾一片光阴
          <span>与你诉说</span>
        </a>
      </div>

      <div class="navbar-collapse collapse">
        <ul class="nav navbar-nav">
          <!-- <li>
            <router-link to="/">首页</router-link>
          </li> -->
          <li>
            <!-- 跳转到书籍全列表 -->
            <router-link to="/book">书评</router-link>
          </li>
          <li>
            <!-- 跳转到音乐全列表 -->
            <router-link to="/music">乐评</router-link>
          </li>
          <li>
            <!-- 跳转到电影全列表 -->
            <router-link to="/video">影评</router-link>
          </li>
          <li>
            <!-- 跳转随笔全列表 -->
            <router-link to="/note">随笔</router-link>
          </li>

          <li>

          <el-dropdown>
            <span class="el-dropdown-link">
              <el-avatar shape="circle" :src="squareUrl"></el-avatar>
            </span>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item><router-link to="/login">登录</router-link></el-dropdown-item>
              <el-dropdown-item><router-link to="/createCenter">创作中心</router-link></el-dropdown-item>
              <el-dropdown-item><router-link to="/messageCenter">消息中心</router-link></el-dropdown-item>
              <el-dropdown-item><router-link to="/updatePassword">修改密码</router-link></el-dropdown-item>
              <el-dropdown-item><span @click="exit()">退出</span></el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
          </li>
        </ul>
      </div>
    </div>
  </header>
</template>

<script>

import storage from "../utils/storage.js"

export default {
  data() {

    return {
      squareUrl: "https://cube.elemecdn.com/9/c2/f0ee8a3c7c9638a54940382568c9dpng.png",
    }

  },

  methods: {
    exit() {

      console.log("exit")

      var _this = this

      _this.message = 'logout'

      this.axios({

        method: 'post',

        url: 'http://localhost:8080/logout',

        headers: {

          'Content-Type': 'application/json;charset=utf-8'

        },

        data: {

          message: _this.message

        },

        responseType: 'json'

      }).then(function (response) {

        var info = response.data.info;
        var code = response.data.code;

        console.log(response);

        if (code == 200) {

          storage.remove('user');

          _this.$router.replace('/');
          _this.$message.success('退出成功');

        } else if (code == 400) {
          
          _this.$message.error('遭遇异常！')
       
        } else {
        
          _this.$message.error('未知错误...')
        
        }
      
      }).catch(function (error) {

        
          console.log(error);
      
          _this.$message.error('系统错误！')
      
      })

    }
  }

}
</script>

<style lang="less" scoped>

.el-dropdown-link {
    cursor: pointer;
    // color: #409EFF;
}

.profile-top {
  align-items: center;
  background: #dfecf1;
  height: 50px;
}
.pic {
  position: relative;
  float: left;
  left: 35%;
  width: 25%;
}
.pic img {
  width: 100%;
  border-radius: 50%;
  border: 5px solid #fff;
}

.head-section {
  border-bottom: 1px solid #eee;
}
.head-section .navbar {
  min-height: 85px;
  margin-bottom: 0;
}
.head-section .navbar-default {
  background-color: #fff;
}
.navbar-default {
  border: none;
}
.navbar-brand {
  color: #bcc0cd;
  font-size: 30px;
  font-weight: 100;
  line-height: 30px;
  margin-top: 30px;
  padding: 0;
}
a,
a:hover,
a:focus {
  text-decoration: none;
  outline: none;
}
.navbar-brand span {
  color: #48cfad;
  font-size: 20px;
}
.head-section .navbar-collapse ul.navbar-nav {
  float: right;
  z-index: 199;
}
.head-section .navbar-nav > li {
  padding-bottom: 25px;
  padding-top: 30px;
  padding-left: 35px;
}
.search {
  width: 50px;
  height: 35px;
  padding: 2px;
  border: 2px solid #dadada;
}
.search i {
  font-size: 20px;
}
.dropdown img {
  width: 50px;
  height: 50px;
  border-radius: 50%;
  padding: 2px;
  border: 1px solid #dadada;
}
.dropdown-menu {
  margin-top: -5px;
  padding: 0;
  box-shadow: none;
}
.dropdown-menu i {
  background: #f36868;
  float: right;
  padding: 3px;
  font-size: 13px;
  display: block;
  color: #fff;
  border-radius: 4px;
  -webkit-border-radius: 4px;
  -moz-border-radius: 4px;
  -o-border-radius: 4px;
  font-style: normal;
}
.dropdown-menu a {
  color: #999;
  font-size: 14px;
  font-weight: 300;
  background: none;
}
.dropdown-menu li:hover {
  background: #dfdfdff5;
  color: #fff;
}
.head-section .navbar-nav > li > a {
  padding-bottom: 5px;
  padding-top: 5px;
  border-radius: 3px;
  -webkit-border-radius: 3px;
  -moz-border-radius: 3px;
  margin-left: 2px;
  line-height: 30px;
  -webkit-transition: all 0.3s ease;
  -moz-transition: all 0.3s ease;
  -ms-transition: all 0.3s ease;
  -o-transition: all 0.3s ease;
  transition: all 0.3s ease;
}
.head-section .nav li a,
.head-section .nav li.active ul.dropdown-menu li a {
  color: #999;
  font-size: 20px;
  font-weight: 800;
  background: none;
}
.head-section .navbar-nav > li > a:hover {
  background: #9ea3a2;
  color: #fff;
}
</style>