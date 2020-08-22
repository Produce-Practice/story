import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import NotFound from '../views/NotFound.vue'

Vue.use(VueRouter)

const routes = [{
        path: '/',
        name: 'login',
        component: Login
    },

    {
        path: '/home',
        name: 'Home',
        component: Home
    },

    {
        path: '/notFound',
        name: 'NotFound',
        component: NotFound
    },

    {
        path: '*', // 访问路径不存在时, 重定向到登录界面
        redirect: '/notFound'
    }

]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

export default router