<template>
    <div class="md">
        <mavon-editor 
            v-model="content" 
            ref="md" 
            @change="change" 
            style="min-height: 600px"
        />

        <div class="btn">
            <el-button type="primary" @click="submit">提交</el-button>
            <el-button type="danger" @click="save">保存</el-button>
        </div>
        <Footer></Footer>
    </div>
    
</template>



<script>

import Footer from '@/components/Footer.vue'

import { mavonEditor } from 'mavon-editor'

export default {
    
    name: 'createIdea',

    // 注册
    components: {

        mavonEditor,
        Footer

    
    },

    data () {

        return {

            content: '', // 输入的markdown
            html: '',    // 及时转的html

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
            
            console.log(this.content);
            console.log(this.html);
        
        },

        save() {



        }

    },

    mounted() {

    }
}
</script>

<style scoped lang="less">

.md mavon-editor {

    width: 500px;

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


</style>