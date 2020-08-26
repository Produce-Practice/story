<template>
  <div>
      <div>
        <div class="form-wrapper">
          <div class="form-signin wow fadeInUp">
            <div class="login-wrap">
              <div class="userImage">
                <span>头像：</span>
                <el-upload
                  class="avatar-uploader"
                  action="https://jsonplaceholder.typicode.com/posts/"
                  :show-file-list="false"
                  :on-success="handleAvatarSuccess"
                  :before-upload="beforeAvatarUpload"
                >
                  <img v-if="imageUrl" :src="imageUrl" class="avatar" />
                  <i v-else class="el-icon-plus avatar-uploader-icon"></i>
                </el-upload>
              </div>
              <span>昵称：</span>
              <input
                type="text"
                v-model="userName"
                :readonly="edit_state"
                :style="{border:borderState+'px solid'}"
              />
              <div class="checkbox">
                <span>性别：</span>
                男：
                <input
                  type="radio"
                  name="radios"
                  value="男"
                  v-model="gender"
                  :disabled="choseState"
                />
                女：
                <input
                  type="radio"
                  name="radios"
                  value="女"
                  v-model="gender"
                  :disabled="choseState"
                />
              </div>
              <div class="mail">
                <span>邮箱：</span>
                <input
                  type="email"
                  v-model="email"
                  :readonly="edit_state"
                  :style="{border:borderState+'px solid'}"
                />
              </div>
              <div class="personalSignature">
                <span>个性签名：</span>
                <textarea v-model="sign" cols="50" rows="8" :readonly="edit_state"></textarea>
              </div>
              <button class="btn btn-lg btn-login" @click="edit_state?edit():save()">{{message}}</button>
            </div>
          </div>
        </div>
      </div>
    <!-- <Footer></Footer> -->
  </div>
</template>

<script>
import Footer from "@/components/Footer.vue";
import http from '@/utils/http';
export default {
  name: "PersonalInfo",
  components: {
    Footer
  },
  data() {
    return {    
      message: "修 改",
      userName:"云飞er",
      gender: "男",
      email:"913283849@qq.com",
      sign: "追求自由!",
      edit_state: true,
      choseState: true,
      borderState: "0",
      imageUrl: ""
    };
  },
  methods: {
    edit: function() {
      this.choseState = this.edit_state = false;
      this.borderState = "1";
      this.message = "保 存";
    },
    save: function() {
      //保存信息到数据库
      this.choseState = this.edit_state = true;
      this.borderState = "0";
      this.message = "修 改";
      var _this = this;
       http({

            // 假设后台需要的是表单数据这里你就可以更改
            headers: {

            "Content-Type": "application/json;charset=UTF-8"
            
            },

            method: 'post',
            url: 'http://localhost:8080/user/updateUser',

            data: {
                userName: _this.userName,
                avatar: "",
                userAccount: JSON.parse(_this.$store.getters.getUser).userAccount,
                gender: _this.gender,
                email: _this.email,
                sign: _this.sign
            },
      
            responseType: 'json'

            }).then(function (res) {
                console.log(res);

                var code = res.code;
                var info = res.info;

                if (res.code == 200) {
                
                    _this.$message.success("修改成功！");
                    _this.$router.push("/user/createCenter/personCenter");
                
                } else {
                     _this.$message.success("修改失败！");
                    _this.$message.error(info);

                }

            }).catch(function (err) {

                console.log(err);
            
        });
    },
    handleAvatarSuccess(res, file) {
      this.imageUrl = URL.createObjectURL(file.raw);
    },
    beforeAvatarUpload(file) {
      const isJPG = file.type === "image/jpeg";
      const isLt2M = file.size / 1024 / 1024 < 2;

      if (!isJPG) {
        this.$message.error("上传头像图片只能是 JPG 格式!");
      }
      if (!isLt2M) {
        this.$message.error("上传头像图片大小不能超过 2MB!");
      }
      return isJPG && isLt2M;
    }
  }
};
</script>
<style scoped>
.form-wrapper {
  padding-bottom: 70px;
}
.form-signin {
  width: 600px;
  margin-left: 55px;
  margin-top: 10px;
  background: #fff;
  box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04);
  border-radius: 3px;
  -moz-border-radius: 3px;
  -webkit-border-radius: 3px;
}
.userImage {
  height: 78px;
  overflow: hidden;
  z-index: -2;
  margin-bottom: 40px;
}
.login-wrap {
  padding: 20px;
  -webkit-border-radius: 3px;
  -moz-border-radius: 3px;
  border-radius: 3px;
}
.form-signin span {
  font-size: 20px;
  margin-left: 50px;
}
.form-signin input[type="text"] {
  margin-left: 20px;
  margin-bottom: 15px;
  border-radius: 3px;
  -webkit-border-radius: 3px;
  -moz-border-radius: 3px;
  border: 2px solid #eaeaea;
  box-shadow: none;
  font-size: 20px;
}
.form-signin .checkbox {
  text-align: left;
  font-weight: normal;
  font-weight: 300;
  font-size: 20px;
  margin-bottom: 14px;
}
.form-signin .checkbox > input {
  margin-right: 90px;
}
.mail {
  text-align: left;
  font-weight: normal;
  font-weight: 300;
  font-size: 20px;
  margin-bottom: 14px;
}
.personalSignature textarea {
  margin-left: 60px;
  margin-top: 20px;
  background: #fff;
  border-radius: 3px;
  -moz-border-radius: 3px;
  -webkit-border-radius: 3px;
}
.form-signin .btn-login {
  margin-left: 190px;
  margin-top: 50px;
  width: 25%;
  background: #48cfad;
  color: #fff;
  text-transform: uppercase;
  font-weight: 300;
  margin-bottom: 20px;
  border-radius: 3px;
  -webkit-border-radius: 3px;
  -moz-border-radius: 3px;
  -webkit-transition: all 0.3s ease;
  -moz-transition: all 0.3s ease;
  -ms-transition: all 0.3s ease;
  -o-transition: all 0.3s ease;
  transition: all 0.3s ease;
  border: 1px solid transparent;
}
.avatar-uploader {
  display: inline;
  vertical-align: middle;
}

.avatar-uploader .el-upload {
  border: 1px dashed #d9d9d9;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
}
.avatar-uploader .el-upload:hover {
  border-color: #409eff;
}

.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  border: 2px dashed #b3b3b3;
  border-radius: 6px;
  width: 78px;
  height: 78px;
  line-height: 78px;
  text-align: center;
  margin-right: 150px;
}
.avatar {
  width: 78px;
  height: 78px;
  display: block;
}
</style>
