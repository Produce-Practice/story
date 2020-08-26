<template>
  <!-- 书籍分享详情列表，未实现分页 -->
  <div>
    <section class="blog">
      <div class="container">
        <div class="row text-center clearfix">
          <div class="col-sm-8 col-sm-offset-2">
            <!-- idea的type -->
            <h2 class="title-one">书籍分享推荐</h2>
            <p class="blog-heading"></p>
          </div>
        </div>
        <div class="row">
          <!-- 渲染列表，包括用户头像，标题名，内容  只获取热度前六个-->
          <div class="col-sm-4" v-for="(book,index) in books" :key="index">
            <div class="single-blog" @click="book.views++">
              <!-- 用户头像 -->
              <router-link :to="{path: '/ideaInfo', query: {item: book}}">
                <img v-bind:src="book.userImg" alt />
              </router-link>
              <!-- idea标题 -->
              <router-link :to="{path: '/ideaInfo', query: {item: book}}">
                <h2>{{book.title}}</h2>
              </router-link>

              <div class="blog-content">
                <!-- idea内容 -->
                <router-link :to="{path: '/ideaInfo', query: {item: book}}">
                  <p>{{book.content}}</p>
                </router-link>
              </div>

              <ul class="post-meta">
                <li @click="book.commentCount++">
                  <!-- 点击评论跳转到idea详情页 将整个book对象传到about-->
                  <router-link :to="{path: '/ideaInfo', query: {item: book}}">
                    <i class="glyphicon glyphicon-comment"></i>
                    {{book.commentCount}}
                  </router-link>
                </li>
                <!-- 点赞 +1-->
                <li @click="book.likes++">
                  <i class="glyphicon glyphicon-heart"></i>
                  {{book.likes}}
                </li>
                <!-- 热度 -->
                <div class="view">
                  <i class="glyphicon glyphicon-eye-open"></i>
                  {{book.views}}
                </div>
              </ul>
            </div>
          </div>
        </div>
        <p class="blog-heading"></p>
      </div>
    </section>
    <Footer></Footer>
  </div>
</template>

<script>
// 列表的样式
import "../../assets/css/common.css";
import axios from "axios";
import Footer from "@/components/Footer.vue";
export default {
  data() {
    return {
      books: [],
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
    this.getbook();
  },
  methods: {
    getbook() {
      this.instance
        .get("/book.json")
        .then(res => {
          this.books = res.data;
          console.log(this.books);
        })
        .catch(err => {
          console.log(err);
        });
    }
  }
};
</script>