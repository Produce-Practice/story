<template>
    <div class="all">
        <div class="center">
            个人资料
            <button @click="edit_state?edit():save()">{{message}}</button>
            <br />——————————————————————————————————————————————
            <div>
                头
                <span></span>像
                <span></span>：
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

            <div>
                昵
                <span></span>称
                <span></span>：
                <input type="text" v-model="nickname" :readonly="edit_state" />
            </div>

            <div>
                性
                <span></span>别
                <span></span>：
                <input type="radio" name="radios" value="男" v-model="sex" :disabled="choseState" />男
                <span></span>
                <input type="radio" name="radios" value="女" v-model="sex" :disabled="choseState" />女
            </div>

            <div>
                邮
                <span></span>箱
                <span></span>：
                <input type="email" v-model="email" :readonly="edit_state" />
            </div>

            <div>
                个性签名：
                <textarea v-model="signature" cols="50" rows="8" :readonly="edit_state"></textarea>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    
    name: "personCenter",
    
    data() {

        return {

            message: "修 改",
            nickname: "Mystory",
            sex: "男",
            email: "1062653191@qq.com",
            signature: "Welcome to mysory!",
            edit_state: true,
            choseState: true,
            imageUrl: "",
        
        };
    
    },
    methods: {
    
        edit: function () {
    
            this.choseState = this.edit_state = false;
            this.message = "保 存";
    
        },
    
        save: function () {
    
            //保存信息到数据库
            this.choseState = this.edit_state = true;
            this.message = "修 改";
    
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
        
        },
    
    },

};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.all {
    background-color: whitesmoke;
    padding-top: 10px;
    padding-bottom: 10px;
}

.center {
    width: 1000px;
    margin-left: 10px;
    padding: 30px 0 20px 30px;
    font-size: 20px;
    background-color: white;
}

.center div {
    margin-top: 20px;
    margin-left: 50px;
    font-size: 18px;
}

img {
    height: 50px;
    vertical-align: middle;
}

input {
    font-size: 18px;
    height: 22px;
    border-style: solid;
    border-width: 0px;
    outline: none;
}

textarea {
    vertical-align: top;
    font-size: 18px;
    outline: none;
}

span {
    padding: 0.5em;
}

button {
    position: absolute;
    margin-left: 750px;
    width: 80px;
    height: 30px;
    font-size: 15px;
    background: rgb(51, 152, 235);
    color: white;
    border: 0px;
    border-radius: 5px;
    outline: none;
}

.avatar-uploader{
    display: inline;
    vertical-align: middle;
}

/* .el-upload__input{
    display: none;
} */

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
    width: 78px;
    height: 78px;
    line-height: 78px;
    text-align: center;
}
.avatar {
    width: 78px;
    height: 78px;
    display: block;
}
</style>
