<template>
  <div>
    <!-- 四个session内容大致一样，就是获取对象不同，第一个是书籍，
    第二个是音乐，第三个是电影，第四个是随笔-->
    <section class="blog">
      <div class="container">
        <div class="row text-center clearfix">
          <div class="col-sm-8 col-sm-offset-2">
            <!-- idea的type -->
            <h2 class="title-one">书籍分享推荐</h2>
            <p class="blog-heading"></p>
          </div>
          <div class="exchange-btn">
             <!-- 更新推荐列表 -->
            <button class="change">
              <i class="glyphicon glyphicon-refresh"></i>
            </button>
            <!-- 跳转到Book.vue 获取全部书籍分享列表 -->
            <button class="more">
              <router-link to="/book">
                更多
                <i class="glyphicon glyphicon-menu-right"></i>
              </router-link>
            </button>
          </div>
        </div>
        <div class="row">
          <!-- 渲染列表，包括用户头像，标题名，内容  只获取热度前六个-->
          <div class="col-sm-4" v-for="(book,index) in books" :key="index">
            <div class="single-blog" v-if="index<6">
              <!-- 用户头像 -->
              <img v-bind:src="book.userImg" alt />
              <!-- idea标题 -->
              <h2>{{book.title}}</h2>
              <div class="blog-content">
                <!-- idea内容 -->
                <p>{{book.content}}</p>
              </div>
              <ul class="post-meta">
                <li>
                  <!-- 点击评论跳转到idea详情页 将整个book对象传到about-->
                  <router-link :to="{path: '/about', query: {item: book}}">
                    <i class="glyphicon glyphicon-comment"></i>
                  </router-link>
                </li>
                <!-- 点赞 +1-->
                <li>
                  <i class="glyphicon glyphicon-heart"></i>
                </li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </section>
    <section class="blog">
      <div class="container">
        <div class="row text-center clearfix">
          <div class="col-sm-8 col-sm-offset-2">
            <!-- idea的type -->
            <h2 class="title-one">音乐分享推荐</h2>
            <p class="blog-heading"></p>
          </div>
           <div class="exchange-btn">
             <!-- 更新推荐列表 -->
            <button class="change">
              <i class="glyphicon glyphicon-refresh"></i>
            </button>
            <!-- 跳转到Music.vue 获取全部音乐列表 -->
            <button class="more">
              <router-link to="/music">
                更多
                <i class="glyphicon glyphicon-menu-right"></i>
              </router-link>
            </button>
          </div>
        </div>
        <div class="row">
          <div class="col-sm-4" v-for="(music, index) in musics" :key="index">
            <div class="single-blog" v-if="index<6">
              <!-- 用户头像 -->
              <img v-bind:src="music.userImg" alt />
              <!-- idea标题 -->
              <h2>{{music.title}}</h2>
              <div class="blog-content">
                <!-- idea内容 -->
                <p>{{music.content}}</p>
              </div>
              <ul class="post-meta">
                <li>
                  <!-- 该idea的详情页 传送这个music 到About.vue-->
                  <router-link :to="{path: '/about', query: {item: music}}">
                    <i class="glyphicon glyphicon-comment"></i>
                  </router-link>
                </li>
                <!-- 点赞 -->
                <li>
                  <i class="glyphicon glyphicon-heart"></i>
                </li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </section>
    <section class="blog">
      <div class="container">
        <div class="row text-center clearfix">
          <div class="col-sm-8 col-sm-offset-2">
            <!-- idea的type -->
            <h2 class="title-one">电影分享推荐</h2>
            <p class="blog-heading"></p>
          </div>
           <div class="exchange-btn">
             <!-- 更新推荐列表 -->
            <button class="change">
              <i class="glyphicon glyphicon-refresh"></i>
            </button>
            <!-- 跳转到Video.vue 获取全部的电影列表 -->
            <button class="more">
              <router-link to="/video">
                更多
                <i class="glyphicon glyphicon-menu-right"></i>
              </router-link>
            </button>
          </div>
        </div>
        <div class="row">
          <div class="col-sm-4" v-for="(video,index) in videos" :key="index">
            <div class="single-blog" v-if="index<6">
              <!-- 用户头像 -->
              <img v-bind:src="video.userImg" alt />
              <!-- idea标题 -->
              <h2>{{video.title}}</h2>
              <div class="blog-content">
                <!-- idea内容 -->
                <p>{{video.content}}</p>
              </div>
              <ul class="post-meta">
                <li>
                  <!-- 跳转idea详情页 传送这个video到About.vue -->
                  <router-link :to="{path: '/about', query: {item: video}}">
                    <i class="glyphicon glyphicon-comment"></i>
                  </router-link>
                </li>
                <!-- 点赞 -->
                <li>
                  <i class="glyphicon glyphicon-heart"></i>
                </li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </section>
    <section class="blog">
      <div class="container">
        <div class="row text-center clearfix">
          <div class="col-sm-8 col-sm-offset-2">
            <!-- idea的type -->
            <h2 class="title-one">随笔推荐</h2>
            <p class="blog-heading"></p>
          </div>
           <div class="exchange-btn">
             <!-- 更新推荐列表 -->
            <button class="change">
              <i class="glyphicon glyphicon-refresh"></i>
            </button>
            <button class="more">
              <!-- 跳转到Note.vue获取全部随笔列表 -->
              <router-link to="/note">
                更多
                <i class="glyphicon glyphicon-menu-right"></i>
              </router-link>
            </button>
          </div>
        </div>
        <div class="row">
          <div class="col-sm-4" v-for="(note,index) in notes" :key="index">
            <div class="single-blog" v-if="index<6">
              <!-- 用户头像 -->
              <img v-bind:src="note.userImg" alt />
              <!-- idea标题 -->
              <h2>{{note.title}}</h2>
              <div class="blog-content">
                <!-- idea内容 -->
                <p>{{note.content}}</p>
              </div>
              <ul class="post-meta">
                <li>
                  <!-- 跳转到该idea的详情页 传送整个note到About.vue -->
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
import Footer from '../components/Footer.vue'
export default {
  data() {
    return {
      books: [],
      musics: [],
      videos: [],
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
    this.getbook();
    this.getmusic();
    this.getvideo();
    this.getnote();
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
    },
    getmusic() {
      this.instance
        .get("/music.json")
        .then(res => {
          this.musics = res.data;
          console.log(this.musics);
        })
        .catch(err => {
          console.log(err);
        });
    },
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
    },
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
<style lang="less" scoped>
.exchange-btn {
  position: relative;
  float: right;
  right: 20px;
  width: 150px;
  margin-top: 5.7em;
}
.change {
  outline: none;
  border: none;
  background: #cfcfcf;
  color: rgb(255, 255, 255);
  font-size: 15px;
  width: 50px;
  border-radius: 25px;
}

.more {
  outline: none;
  border: none;
  background: #cfcfcf; 
  font-size: 15px;
  width: 75px;
  border-radius: 25px;
  margin-left:10px ;
}
.more a{
   color: #fff;
   text-decoration: none;
}
.change,.more i{
  padding-top:5px;
}
.change:hover, .more:hover {
  background: #8b857e;
}
</style>