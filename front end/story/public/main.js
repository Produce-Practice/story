import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'

// 导入的是assets中的css，vue ui下载的版本不同，样式不对
import './assets/css/bootstrap.min.css'
//通过vue ui下载的jquery和bootstrap中的min.js
import 'jquery/dist/jquery.min.js'
import 'bootstrap/dist/js/bootstrap.min.js'
Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
