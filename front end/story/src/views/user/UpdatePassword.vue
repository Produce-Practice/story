<template>
    <div class="all">
        <div class="content">
            <div class="form sign-in">
                <h2>修改密码</h2>
                <label>
                    <span>原密码</span>
                    <input type="password" v-model="oldPassword" />
                </label>
                <label>
                    <span>新密码</span>
                    <input type="password" v-model="newPassword" />
                </label>
                <label>
                    <span>确认新密码</span>
                    <input type="password" v-model="confirmNewPassword" />
                </label>
                <p class="forgot-pass">
                    <a href="javascript:">忘记密码?</a>
                </p>
                <button type="button" class="submit" @click="update">修改</button>
            </div>
        </div>
        <Footer></Footer>
    </div>
</template>

<script>
import Footer from '@/components/Footer.vue';
import storage from '@/utils/storage';
import http from '@/utils/http';

export default {

  name: 'updatePasswrod',

  components: {
      Footer
  },

  data () {

    return {

      oldPassword: '',
      newPassword: '',
      confirmNewPassword: ''

    }
  },

  created: function () {
  
  },

  methods: {

    update: function () {

      var _this = this;

      if (this.oldPassword == null || this.newPassword == null || this.confirmNewPassword == null || this.newPassword == '') {

        this.$message.warning("密码不能为空!");

      } else if (this.newPassword != this.confirmNewPassword) {

        this.$message.warning("两次密码输入不一致!");

      } else {

        http({

            // 假设后台需要的是表单数据这里你就可以更改
            headers: {

            "Content-Type": "application/json;charset=UTF-8"
            
            },

            method: 'post',
            url: 'http://localhost:8080/user/updatePassword',

            data: {

                userAccount: JSON.parse(_this.$store.getters.getUser).userAccount,
                oldPassword: _this.oldPassword,
                password: _this.newPassword

            },

            responseType: 'json'

            }).then(function (res) {

                console.log(res);

                var code = res.code;
                var info = res.info;

                if (res.code == 200) {
                
                    _this.$message.success("修改成功!");

                    storage.remove("user");
                    _this.$router.replace("/login");
                
                } else {
                    
                    _this.$message.error(info);

                }

            }).catch(function (err) {

                _this.$message.error(err);
            
        });

      }

    },

  },

}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
footer{
    position: absolute;
    bottom: -650px;
}



*,
*:before,
*:after {
    box-sizing: border-box;
    margin: 0;
    padding: 0;
}

.all {
    position: absolute;
    width: 100%;
    height: 85%;
    background-color: whitesmoke;
    background-size: cover;
}

input,
button {
    border: none;
    outline: none;
    background: none;
    font-family: "Open Sans", Helvetica, Arial, sans-serif;
}

.content {
    overflow: hidden;
    position: absolute;
    left: 50%;
    top: 50%;
    width: 640px;
    height: 550px;
    margin: -270px 0 0 -300px;
    background: #fff;
}

.form {
    position: relative;
    width: 640px;
    height: 100%;
    transition: -webkit-transform 0.6s ease-in-out;
    transition: transform 0.6s ease-in-out;
    transition: transform 0.6s ease-in-out, -webkit-transform 0.6s ease-in-out;
    padding: 50px 0px 0;
}

button {
    display: block;
    margin: 0 auto;
    width: 260px;
    height: 36px;
    border-radius: 30px;
    color: #fff;
    font-size: 15px;
    cursor: pointer;
}

h2 {
    width: 100%;
    font-size: 26px;
    text-align: center;
}

label {
    display: block;
    width: 260px;
    margin: 25px auto 0;
    text-align: center;
}

label span {
    font-size: 12px;
    color: #909399;
    text-transform: uppercase;
}

input {
    display: block;
    width: 100%;
    margin-top: 5px;
    padding-bottom: 5px;
    font-size: 16px;
    border-bottom: 1px solid rgba(0, 0, 0, 0.4);
    text-align: center;
}

.forgot-pass {
    margin-top: 15px;
    text-align: center;
    font-size: 12px;
    color: #cfcfcf;
}

.forgot-pass a {
    color: #cfcfcf;
}

.submit {
    margin-top: 40px;
    margin-bottom: 20px;
    background: #d4af7a;
    text-transform: uppercase;
}

.sign-in {
    transition-timing-function: ease-out;
}
</style>
