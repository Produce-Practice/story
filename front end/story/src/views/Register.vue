<!-- 登陆界面 -->
<template>
    <div class="all">
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

            <el-input type="password" v-model="password" class="input_style"></el-input><br>

            <div class="user_pass">
                重复密码:
            </div>

            <el-input type="password" v-model="repeatPassword" class="input_style"></el-input><br>

            </div>

        <div>
          <el-row class="but">
            <el-button @click="register()" type="danger">注&nbsp;&nbsp;&nbsp;册</el-button>
          </el-row>
        </div>

    </div>
    <Footer></Footer>
</div>
</template>

<script>
// 导入Footer，需在下方components注明
import Footer from '../components/Footer.vue';
import storage from '../utils/storage';
import http from '../utils/http';

export default {

  name: 'register',

  data () {

    return {

      userAccount: '',
      password: '',
      repeatPassword: ''

    }
  },

  //注明Footer
  components: {
    Footer
  },
  
  created: function () {
  
  },

  methods: {

    register: function () {

      var _this = this;

      if (this.userAccount == null || this.password == null || this.repeatPassword == null || this.password == '') {

        this.$message.warning("用户名或密码不能为空!");

      } else if (this.password != this.repeatPassword) {

        this.$message.warning("两次密码输入不一致!");

      } else {

        http({

            // 假设后台需要的是表单数据这里你就可以更改
            headers: {

            "Content-Type": "application/json;charset=UTF-8"
            
            },

            method: 'post',
            url: 'http://localhost:8080/register',

            data: {

                userAccount: this.userAccount,
                password: this.password,
                userName: 'hello'

            },

            responseType: 'json'

            }).then(function (res) {

                console.log(res);

                var code = res.code;
                var info = res.info;

                if (res.code == 200) {
                
                    _this.$message.success("注册成功！");
                    _this.$router.push("/login");
                
                } else {
                    
                    _this.$message.error(info);

                }

            }).catch(function (err) {

                console.log(err);
            
        });

      }

    },

  },

}
</script>

<style lang="less" scoped>

footer {
  position: absolute;
  top: 800px;
  left: 0px;
  z-index: 100;
}

.all {

    // position: relative;
    // height: 100vh;
    // background-color: #2d3a4b;

}

.but {
  margin: 60px 132px;
  
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
    height: 380px;
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
    // line-height: 30px;
    // margin-top: 30px;
    // padding: 0;

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


.errorTip {
    position: absolute;
    top: 200px;
    left: 50px;
    font-size: 14px;
    letter-spacing: 2px;
    color: red;
}


</style>
