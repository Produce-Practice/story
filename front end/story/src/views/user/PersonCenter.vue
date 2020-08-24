<template>
    <div>
        <!-- 修改footer的位置，只要改变下方css中footer的bottom的值 -->
        <Footer></Footer>
    </div>    
</template>

<script>
import Footer from '@/components/Footer.vue';
export default {
    name: 'personCenter',
    components:{
        Footer
    },
    data() {
        return {
            
        }

    },

    methods: {

    }
}
</script>

<style scoped>
footer{
    bottom: -450px;
}
</style>