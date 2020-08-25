<template>
  <!-- 电影全列表，为实现分页 -->
  <div>
    <section class="blog">
      <div class="container">
        <div class="row text-center clearfix">
          <div class="col-sm-8 col-sm-offset-2">
            <!-- idea的type -->
            <h2 class="title-one">电影分享推荐</h2>
            <p class="blog-heading"></p>
          </div>
        </div>
        <div class="row">
          <!-- 渲染列表，包括用户头像，标题名，内容  只获取热度前六个-->
          <div class="col-sm-4" v-for="(video,index) in videos" :key="index">
            <div class="single-blog">
              <!-- 用户头像 -->
              <router-link :to="{path: '/ideaInfo', query: {item: video}}">
              <img v-bind:src="video.userImg" alt />
              </router-link>
              <!-- idea标题 -->
              <router-link :to="{path: '/ideaInfo', query: {item: video}}">
              <h2>{{video.title}}</h2>
              </router-link>
              
              <div class="blog-content">
                <!-- idea内容 -->
                <router-link :to="{path: '/ideaInfo', query: {item: video}}">
                <p>{{video.content}}</p>
                </router-link>
              </div>
              
              <ul class="post-meta">
                <li>
                  <!-- 点击评论跳转到idea详情页 将整个music对象传到about-->
                  <router-link :to="{path: '/ideaInfo', query: {item: video}}">
                    <i class="glyphicon glyphicon-comment"></i>
                    {{video.commentCount}}
                  </router-link>
                </li>
                <!-- 点赞 +1-->
                <li @click="video.views++">
                  <i class="glyphicon glyphicon-heart"></i>
                  {{video.likes}}
                </li>
                <!-- 热度 -->
                 <div class="view">
                  <i class="glyphicon glyphicon-eye-open"></i>
                  {{video.views}}
                </div>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </section>
    <Footer></Footer>
  </div>
</template>
<script>
import storage from '@/utils/storage';
import http from '@/utils/http';
// 列表的样式
import "@/assets/css/common.css";
import axios from "axios";
import Footer from "@/components/Footer.vue";
export default {
  data() {
    return {
      videos: [],
      instance: null
    };
  },
  components: {
    Footer
  },
  created() {
    this.instance = axios.create({
      baseURL: "http://localhost:8081",
      timeout: 1000
    });
    this.getvideo();
  },
  methods: {
    getvideo() {
      this.instance
        .get("/video.json")
        .then(res => {
          this.videos = res.data;
          console.log(this.videos);
        })
        .catch(err => {
          console.log(err);
        });
    }
  }
};
</script>