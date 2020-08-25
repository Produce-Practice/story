<template>
    <div class="md">

        <el-input placeholder="请输入标题..." v-model="title"></el-input>

        <mavon-editor 
            class="mavon"
            v-model="content" 
            ref="md" 
            @change="change" 
            style="min-height: 600px"
        />

        <div class="btn">
            <el-button type="primary" @click="submit()">提交</el-button>
            <el-button type="danger" @click="save()">保存</el-button>
        </div>
        <!-- <Footer></Footer> -->
        
    <router-view class="router-view"></router-view>

    </div>
    
</template>



<script>
import storage from '@/utils/storage';
import Footer from '@/components/Footer.vue'

import { mavonEditor } from 'mavon-editor'

import http from '@/utils/http';

export default {
    
    name: 'createIdea',

    // 注册
    components: {

        mavonEditor,
        Footer
    
    },

    data () {

        return {

            title: '',
            content: '', // 输入的markdown
            html: '',    // 及时转的html
            visibility: null,
            likes: 0,
            visits: 0,

        }
    },
    methods: {

        // 所有操作都会被解析重新渲染
        change (value, render) {
        
            // render 为 markdown 解析后的结果[html]
            this.html = render;
        
        },

        // 提交
        submit () { 

            var _this = this;
            
            console.log("-------------- content --------------")
            // 获取左侧
            console.log(this.content);


            console.log("-------------- html --------------")
            // 获取右侧
            console.log(this.html);

            this.visibility = 1;

            if (this.title == null || this.title == "") {

                this.$message.warning("标题不能为空!");

            } else if (this.content == null || this.content == "") {

                this.$message.warning("想法内容不能为空!");
            
            } else {

                var obj = new Object();
                obj.title = _this.title;
                obj.content = _this.content;
                obj.html = _this.html;
                obj.likes = _this.likes;
                obj.visits = _this.visits;
                obj.visibility = _this.visibility;

                storage.set("article", JSON.stringify(obj));
                _this.$store.commit('saveArticle', storage.get('article'));

                // _this.$router.push({
                //     path: '/user/createIdea/public',
                //     query: {

                //     }
                
                // }),

                _this.$router.push('/user/createIdea/public');

            }

        },

        save() {
            
            this.visibility = 0;

        }

    },

    mounted() {

    }
}
</script>

<style scoped lang="less">

// .el-input__inner {
//     -webkit-appearance: none;
//     background-color: #FFF;
//     background-image: none;
//     border-radius: 4px;
//     border: 1px solid #DCDFE6;
//     box-sizing: border-box;
//     color: #1c1d1f;
//     display: inline-block;
//     font-size: inherit;
//     height: 40px;
//     line-height: 40px;
//     outline: 0;
//     padding: 0 15px;
//     transition: border-color .2s cubic-bezier(.645,.045,.355,1);
//     width: 100%;
// }

.md {
    z-index: -10;
    width: 100%;
}

.md mavon-editor {

    width: 500px;
    z-index: -10;

}
.mavon{
    position: relative;
    z-index: 22;
}

.md button {

    padding: 14px 20px;
    font-size: 18px;
    margin: 12px;

}

.btn {
    min-width: 200px;
    margin-left: 85%;
}



.title span{
    width: 200px;
    height: 100px;
    border: 1px solid gray;
    border-radius: 4px;
    font-size: 20px;
    font-weight: 500;
    
}
.router-view{
    position: absolute;
    top: 0px;
    z-index: 999;
    width: 100%;
    height: 100%;
    background: #000;
}
</style>