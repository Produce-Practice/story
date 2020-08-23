<template>
  <!-- 电影全列表，为实现分页 -->
  <div>
    <section class="blog">
      <div class="container">
        <div class="row text-center clearfix">
          <div class="col-sm-8 col-sm-offset-2">
            <h2 class="title-one">电影分享</h2>
            <p class="blog-heading"></p>
          </div>
        </div>
        <div class="row">
          <div class="col-sm-4" v-for="(video,index) in videos" :key="index">
            <div class="single-blog">
              <!-- 用户头像 -->
              <img v-bind:src="video.userImg" alt />
              <!-- 标题 -->
              <h2>{{video.title}}</h2>
              <div class="blog-content">
                <!-- 内容 -->
                <p>{{video.content}}</p>
              </div>
              <ul class="post-meta">
                <li>
                   <!-- 该idea的详情页 传送这个video 到About.vue-->
                  <router-link :to="{path: '/about', query: {item: video}}">
                    <i class="glyphicon glyphicon-comment"></i>
                  </router-link>
                </li>
                <li>
                  <!-- 点赞 -->
                  <i class="glyphicon glyphicon-heart"></i>
                </li>
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