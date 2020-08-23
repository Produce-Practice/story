import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import NotFound from '../views/NotFound.vue'
import Navigation from '../components/Navigation.vue'
import Footer from '../components/Footer.vue'

import Register from '../views/Register.vue'
import Book from '../views/Book.vue'
import Music from '../views/Music.vue'
import Note from '../views/Note.vue'
import Video from '../views/Video.vue'
import UpdatePassword from '../views/UpdatePassword.vue'
import CreateCenter from '../views/CreateCenter.vue'
import MessageCenter from '../views/MessageCenter.vue'


Vue.use(VueRouter)

const routes = [

    {
        path: '/login',
        name: 'Login',
        components: {
            default: Login,
            nav: Navigation,
            // footer: Footer
        }
    },

    {
        path: '/',
        name: 'Home',
        components: {
            default: Home,
            nav: Navigation,
            // footer: Footer
        }
    },

    {
        path: '/createCenter',
        name: 'CreateCenter',
        components: {
            default: CreateCenter,
            nav: Navigation
        }
    },


    {
        path: '/messageCenter',
        name: 'MessageCenter',
        components: {
            default: MessageCenter,
            nav: Navigation
        }
    },

    {
        path: '/updatePassword',
        name: 'UpdatePassword',
        components: {
            default: UpdatePassword,
            nav: Navigation
        }
    },

    {
        path: '/register',
        name: 'register',
        components: {
            default: Register,
            nav: Navigation
        }
    },

    {
        path: '/notFound',
        name: 'NotFound',
        component: NotFound
    },

    {
        path: '/book',
        name: 'Book',
        components: {
            default: Book,
            nav: Navigation
        }
    },

    {
        path: '/music',
        name: 'Music',
        components: {
            default: Music,
            nav: Navigation
        }
    },


    {
        path: '/note',
        name: 'Note',
        components: {
            default: Note,
            nav: Navigation
        }
    },

    {
        path: '/video',
        name: 'Video',
        components: {
            default: Video,
            nav: Navigation
        }
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