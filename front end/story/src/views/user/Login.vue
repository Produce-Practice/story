<template>
<section class="blog">
  <div class="container">
      <div class="mydiv">
        <div class="headline">
          拾一片光阴, <span>与你诉说</span>
        </div>

        <!-- 用户名、密码输入 -->
        <div class="input">
            <div class="user_id">
                用户名:
            </div>
            <el-input type="text" v-model="userAccount" class="input_style"></el-input><br>
            <div class="user_pass">
                密码:
            </div>
            <el-input type="password" v-model="password" class="input_style" ></el-input><br>
        </div>

        <div>
          <el-row class="but">
            <el-button @click="login()" type="primary">登&nbsp;&nbsp;&nbsp;录</el-button>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <el-button @click="register()" type="danger">注&nbsp;&nbsp;&nbsp;册</el-button>
          </el-row>
        </div>
      </div>
  </div>
  <Footer></Footer>
</section>
</template>

<script>
import Footer from '@/components/Footer.vue';
import storage from '@/utils/storage';
// 列表的样式
import "@/assets/css/common.css";

export default {

  name: 'login',

  data () {

    return {

      userAccount: '',
      password: ''

    }
  },

  created: function () {

    var _this = this
    document.onkeydown = function (e) {
      
      if (window.event.keyCode == 13) {
        _this.login()
      }

    }
  
  },

  methods: {

    login: function () {

      var _this = this

      _this.message = 'login'

      this.axios({

        method: 'post',

        url: 'http://localhost:8080/login',

        headers: {

          'Content-Type': 'application/json;charset=utf-8'

        },

        data: {

          userAccount: _this.userAccount,
          password: _this.password

        },

        responseType: 'json'

      }).then(function (response) {
        
        var info = response.data.info;
        var code = response.data.code;

        if (code == 200) {

          // 创建user对象
          var user = new Object();
          user.token = info;
          user.userAccount = _this.userAccount;
          user.password = _this.password;

          // 提交user(含token)
          storage.set('user', JSON.stringify(user));
          _this.$store.commit('createUser', storage.get('user'));

          // console.log(JSON.parse(_this.$store.getters.getUser).userAccount);

          _this.$router.replace('/home');
          _this.$message.success('登录成功');

        } else if (code == 400 && info == 'incorrect') {

          _this.$message.error('用户名或密码输入错误！');

        } else {

          _this.$message.error('账号不存在！');

        }

      }).catch(function (error) {

          _this.$message.error('系统错误！');

      })

    },

    register() {
      
      this.$router.push('/register');
      
    }

  },

}
</script>

<style lang="less" scoped>

.but {
  text-align: center;
  
}


.but button {
  font-size: 20px;
  padding: 12px 16px;
  margin: 25px 25px;
}


.mydiv {

    position: absolute;
    top: 175px;
    left: 550px;
    background: rgb(255, 255, 255);
    width: 400px;
    height: 360px;
    border: 4px solid rgb(248, 248, 248);

}


.headline {

    position: relative;
    top: 20px;
    text-align: center;
    font-size: 22px;
    letter-spacing: 2px;

    color: #5675db;
    font-weight: 100;

}

.headline span {
    color: #48cfad;
    font-size: 20px;
}


.user_id {

    position: relative;
    left: 10px;
    top: 0px;

}


.user_pass {

    position: relative;
    left: 10px;
    top: 0px;
    margin-top: 15px;

}


.input {

    position: relative;
    left: 50px;
    top: 50px;
    width: 300px;
    height: 200px;
    font-size: 15px;

}


.input_style {

    width: 300px;
    height: 40px;

}


</style>
