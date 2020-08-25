<template>
  <!-- 随笔全列表，为实现分页 -->
  <div>
    <section class="blog">
      <div class="container">
        <div class="row text-center clearfix">
          <div class="col-sm-8 col-sm-offset-2">
            <!-- idea的type -->
            <h2 class="title-one">随笔推荐</h2>
            <p class="blog-heading"></p>
          </div>
        </div>
        <div class="row">
          <!-- 渲染列表，包括用户头像，标题名，内容  只获取热度前六个-->
          <div class="col-sm-4" v-for="(note,index) in notes" :key="index">
            <div class="single-blog">
              <!-- 用户头像 -->
              <router-link :to="{path: '/ideaInfo', query: {item: note}}">
              <img v-bind:src="note.userImg" alt />
              </router-link>
              <!-- idea标题 -->
              <router-link :to="{path: '/ideaInfo', query: {item: note}}">
              <h2>{{note.title}}</h2>
              </router-link>
              
              <div class="blog-content">
                <!-- idea内容 -->
                <router-link :to="{path: '/ideaInfo', query: {item: note}}">
                <p>{{note.content}}</p>
                </router-link>
              </div>
              
              <ul class="post-meta">
                <li>
                  <!-- 点击评论跳转到idea详情页 将整个note对象传到about-->
                  <router-link :to="{path: '/ideaInfo', query: {item: note}}">
                    <i class="glyphicon glyphicon-comment"></i>
                    {{note.commentCount}}
                  </router-link>
                  
                </li>
                <!-- 点赞 +1-->
                <li @click="note.likes++">
                  <i class="glyphicon glyphicon-heart"></i>
                  {{note.likes}}
                </li>
                <!-- 热度 -->
                 <div class="view">
                  <i class="glyphicon glyphicon-eye-open"></i>
                  {{note.views}}
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
      notes: [],
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
    this.getnote();
  },
  methods: {
    getnote() {
      this.instance
        .get("/note.json")
        .then(res => {
          this.notes = res.data;
          console.log(this.notes);
        })
        .catch(err => {
          console.log(err);
        });
    }
  }
};
</script>
