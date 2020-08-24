import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/user/Home.vue";
import Login from "../views/user/Login.vue";
import NotFound from "../views/user/NotFound.vue";
import Navigation from "../components/Navigation.vue";
import Footer from "../components/Footer.vue";

// import Register from '../views/user/Register.vue'
import Book from "../views/user/Book.vue";
import Music from "../views/user/Music.vue";
import Note from "../views/user/Note.vue";
import Video from "../views/user/Video.vue";
import UpdatePassword from "../views/user/UpdatePassword.vue";
import CreateCenter from "../views/user/CreateCenter.vue";
import CreateIdea from "../views/user/CreateIdea.vue";
import IdeaInfo from '../views/user/IdeaInfo.vue'

Vue.use(VueRouter);

const routes = [{
        path: "/user/createIdea",
        name: "createIdea",
        components: {
            default: CreateIdea,
            nav: Navigation
        },
        children: [{
            path: "public",
            name: "public",
            component: () =>
                import ("@/components/createCenter/Public")
        }, ]
    },

    {
        path: "/ideaInfo",
        name: "ideaInfo",
        components: {
            default: IdeaInfo,
            nav: Navigation
        }
    },

    {
        path: "/login",
        name: "login",
        components: {
            default: Login,
            nav: Navigation
                // footer: Footer
        }
    },

    {
        path: "/",
        name: "home",
        components: {
            default: Home,
            nav: Navigation
                // footer: Footer
        }
    },

    {
        path: "/user/createCenter",
        name: "createCenter",

        components: {
            default: CreateCenter,
            nav: Navigation
        },
        children: [{
                path: "personCenter",
                name: "personCenter",
                component: () =>
                    import ("@/views/user/PersonCenter")
            },
            {
                path: "favourInfo",
                name: "favourInfo",
                component: () =>
                    import ("@/views/user/MyFavour")
            },

            {
                path: "messageInfo",
                name: "messageInfo",
                component: () =>
                    import ("@/views/user/MessageInfo")
            },

            {
                path: "draft",
                name: "draft",
                component: () =>
                    import ("@/views/user/Draft")
            },

            {
                path: "record",
                name: "record",
                component: () =>
                    import ("@/views/user/Record")
            }
        ]
    },

    {
        path: "/user/updatePassword",
        name: "updatePassword",
        components: {
            default: UpdatePassword,
            nav: Navigation
        }
    },

    {
        path: "/notFound",
        name: "notFound",
        component: NotFound
    },

    {
        path: "/book",
        name: "book",
        components: {
            default: Book,
            nav: Navigation
        }
    },

    {
        path: "/music",
        name: "music",
        components: {
            default: Music,
            nav: Navigation
        }
    },

    {
        path: "/note",
        name: "note",
        components: {
            default: Note,
            nav: Navigation
        }
    },

    {
        path: "/video",
        name: "video",
        components: {
            default: Video,
            nav: Navigation
        }
    },

    {
        path: "*", // 访问路径不存在时, 重定向到登录界面
        redirect: "/notFound"
    }
];

const router = new VueRouter({
    mode: "history",
    base: process.env.BASE_URL,
    routes
});

const originalPush = VueRouter.prototype.push;
VueRouter.prototype.push = function push(location) {
    return originalPush.call(this, location).catch(err => err);
};

export default router;