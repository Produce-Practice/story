<template>
  <!-- 随笔全列表，未实现分页 -->
  <div>
    <section class="blog">
      <div class="container">
        <div class="row text-center clearfix">
          <div class="col-sm-8 col-sm-offset-2">
            <h2 class="title-one">随笔</h2>
            <p class="blog-heading"></p>
          </div>
        </div>
        <div class="row">
          <div class="col-sm-4" v-for="(note,index) in notes" :key="index">
            <div class="single-blog">
              <!-- 用户头像 -->
              <img v-bind:src="note.userImg" alt />
              <!-- 标题 -->
              <h2>{{note.title}}</h2>
              <div class="blog-content">
                <!-- 内容 -->
                <p>{{note.content}}</p>
              </div>
              <ul class="post-meta">
                <li>
                   <!-- 该idea的详情页 传送这个note 到About.vue-->
                  <router-link :to="{path: '/about', query: {item: note}}">
                    <i class="glyphicon glyphicon-comment"></i>
                  </router-link>
                </li>
                <li>
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
import "../assets/css/common.css";
import axios from "axios";
import Footer from "../components/Footer.vue";
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
      baseURL: "http://localhost:8080",
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
