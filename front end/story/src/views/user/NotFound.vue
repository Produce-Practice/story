<template>
 <div>
     <div class="theme">
      <div class="no">
        404
      </div>
      <p>Page not Found</p>
     </div>
     <Footer></Footer>
 </div>
</template>
 
<script>
import Footer from '@/components/Footer.vue';
export default {

    name: 'NotFound',

    components: {
        Footer
    }
};

</script>
 
<style lang="less" scoped>
footer{
    bottom: -550px;
}

.theme p {
    font-size: 40px;
    font-weight: bold;
    top: 365px;
    left: 610px;
    position: absolute;
}


.no {

    font-size: 180px;
    font-weight: bold;
    top: 180px;
    left: 610px;
    position: absolute;
}

</style>