import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/user/Home.vue'
import Login from '../views/user/Login.vue'
import NotFound from '../views/user/NotFound.vue'
import Navigation from '../components/Navigation.vue'
import Footer from '../components/Footer.vue'

// import Register from '../views/user/Register.vue'
import Book from '../views/user/Book.vue'
import Music from '../views/user/Music.vue'
import Note from '../views/user/Note.vue'
import Video from '../views/user/Video.vue'
import UpdatePassword from '../views/user/UpdatePassword.vue'
import CreateCenter from '../views/user/CreateCenter.vue'
import PersonCenter from '../views/user/PersonCenter.vue'
import CreateIdea from '../views/user/CreateIdea.vue'

Vue.use(VueRouter)

const routes = [

    {
        path: '/user/createIdea',
        name: 'createIdea',
        components: {
            default: CreateIdea,
            nav: Navigation,
        },
    },

    {
        path: '/user/personCenter',
        name: 'personCenter',
        components: {
            default: PersonCenter,
            nav: Navigation,
            // footer: Footer
        }
    },

    {
        path: '/login',
        name: 'login',
        components: {
            default: Login,
            nav: Navigation,
            // footer: Footer
        }
    },

    {
        path: '/',
        name: 'home',
        components: {
            default: Home,
            nav: Navigation,
            // footer: Footer
        }
    },

    {
        path: '/user/createCenter',
        name: 'createCenter',
        components: {
            default: CreateCenter,
            nav: Navigation
        },

        children: [{
                path: 'messageInfo',
                name: 'messageInfo',
                components: () =>
                    import ('@/views/user/MessageInfo')
            },

            {
                path: 'favourInfo',
                name: 'favourInfo',
                component: () =>
                    import ('@/views/user/MyFavour'),
            },

            {
                path: 'draft',
                name: 'draft',
                component: () =>
                    import ('@/views/user/Draft'),
            },

            {
                path: 'record',
                name: 'record',
                component: () =>
                    import ('@/views/user/Record'),

            },

        ]



    },

    {
        path: '/user/updatePassword',
        name: 'updatePassword',
        components: {
            default: UpdatePassword,
            nav: Navigation
        }
    },

    {
        path: '/notFound',
        name: 'notFound',
        component: NotFound
    },

    {
        path: '/book',
        name: 'book',
        components: {
            default: Book,
            nav: Navigation
        }
    },

    {
        path: '/music',
        name: 'music',
        components: {
            default: Music,
            nav: Navigation
        }
    },


    {
        path: '/note',
        name: 'note',
        components: {
            default: Note,
            nav: Navigation
        }
    },

    {
        path: '/video',
        name: 'video',
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