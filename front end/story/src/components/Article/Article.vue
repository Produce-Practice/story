<template>
  <div>
    <!-- 文章内容组件 -->
    <article class="main_box">
      <header>
        <h1>{{PageInfo.title}}</h1>
        <hr>
        <div class="head_function">
          <el-page-header @back="goBack" content="热评页" style="font-size:10px;"></el-page-header>
        </div>
      </header>
      <div class="entry-content">
        <p>{{PageInfo.article}}</p>
      </div>
      <div class="entry-footer">
        <p>———— {{PageInfo.author}}</p>
      </div>
      <div class="icon_content">
        <i class="eye">
          <svg
            t="1598281181752"
            class="icon"
            viewBox="0 0 1024 1024"
            version="1.1"
            xmlns="http://www.w3.org/2000/svg"
            p-id="4069"
            width="20"
            height="20"
          >
            <path
              d="M511.3 288.8c46.6 0 94.6 9.5 142.6 28.3 42.4 16.6 83.8 39.8 123.1 69.1 42.2 31.4 70.5 61.4 86.8 80.9 17.2 20.6 26 35.6 29.8 43.6-3.9 8.1-12.9 23-30.2 43.8-16.5 19.8-44.9 49.9-86.9 81.5-39.2 29.6-80.6 53-122.8 69.7-48 19-95.9 28.6-142.5 28.6-46.4 0-94.3-9.6-142.2-28.4-42.3-16.6-83.6-39.9-122.9-69.3-42.1-31.5-70.5-61.5-87-81.1-17.3-20.7-26.2-35.6-30.1-43.6 3.8-8 12.6-23 29.8-43.7 29.6-35.7 63.5-63.9 86.7-81.3 39.2-29.4 80.6-52.8 122.9-69.5 48.1-19 96.2-28.6 142.9-28.6m0-64c-247.5 0-447.2 225-448.1 286.7-0.9 59.6 200.6 286.7 448.1 286.7s447-227.1 448.1-286.7c1.1-61.7-200.6-286.7-448.1-286.7z"
              p-id="4070"
              fill="#2c2c2c"
            ></path>
            <path
              d="M512.2 512.2m-192.1 0a192.1 192.1 0 1 0 384.2 0 192.1 192.1 0 1 0-384.2 0Z"
              p-id="4071"
              fill="#2c2c2c"
            ></path>
          </svg>
        </i>
        <span>{{PageInfo.eye}}</span>
        <i class="icon">
          <svg
            t="1597996768855"
            class="icon"
            viewBox="0 0 1024 1024"
            version="1.1"
            xmlns="http://www.w3.org/2000/svg"
            p-id="7280"
            width="16"
            height="16"
          >
            <path
              d="M890.2 208.2c-91.8-91.9-242.1-91.9-334 0L544.4 220c-18.2 18.2-47.6 18.2-65.8 0l-11.8-11.8c-91.9-91.9-242.1-91.9-334 0C41 300 24.7 533.9 203.6 722.1 304 827.8 412.4 882.3 470 905.9c26.6 10.9 56.5 10.9 83 0 57.6-23.6 166-78.1 266.4-183.8 178.9-188.2 162.6-422 70.8-513.9z"
              p-id="7281"
              fill="#2c2c2c"
              @click="clickStar($event)"
            ></path>
          </svg>
        </i>
        <span>{{PageInfo.star}}</span>
      </div>
    </article>
  </div>
</template>

<script>
export default {
  name: "myArticle",
  data() {
    return {
      PageInfo: {
        article:
          "本人今年34么用处的一种人吧！种人吧！本人今年34岁，结婚6年，育有一女，4岁，父母健全，在建筑局上班，为人低调，做事一般，可以说没什么前途也没什本人今年34岁，结婚6年，育有一女，4岁，父母健全，在建筑局上班，为人低调，做事一般，可以说没什么前途也没什么用处的一种人吧！本人今年34岁，结婚6年，育有一女，4岁，父母健全，在建筑局上班，为人低调，做事一般，可以说没什么前途也没什本人今年34岁，结婚6年，育有一女，4岁，父母健全，在建筑局上班，为人低调，做事一般，可以说没什么前途也没什么用处的一种人吧！本人今年34岁，结婚6年，育有一女，4岁，父母健全，在建筑局上班，为人低调，做事一般，可以说没什么前途也没什本人今年34岁，结婚6年，育有一女，4岁，父",
        author: "张三",
        title: "慢一步，差一步-网易云热评墙",
        star: 1234,
        eye: 123,
      },

      flag: false
    };
  },
  methods: {
    goBack() {
      this.$router.go(-1);
    },
    clickStar(e) {
      if (this.flag == true) {
        return;
      }
      e.target.style.fill = "#d81e06";
      this.PageInfo.star++;
      this.flag = true;
    }
  }
};
</script>

<style>
.el-page-header__content {
  color: #303133;
  font-size: 15px;
}
</style>


<style lang="less" scoped>
.main_box {
  width: 800px;
  height: auto;
  h1 {
    height: 50px;
    font-size: 20px;
    line-height: 60px;
  }
}
.main_box hr {
  width: 100%;
  height: 1px;
  border: 0;
  background: #efefef;
  margin: 15px 0;
}

.entry-content {
  background: #f9f9f9;
  margin-top: 20px;
  padding: 40px;
  color: #656d78;
  letter-spacing: 1px;
  line-height: 35px;
}
.entry-footer {
  width: 100%;
  padding: 20px 0px;
  font-size: 16px;
  color: #656d78;
  p {
    float: right;
  }
}
.icon_content {
  position: relative;
  width: 100%;
  padding: 20px 0px;
  .icon {
    position: absolute;

    right: 20px;
  }

  .eye {
    position: absolute;
    top: 18px;
    right: 100px;
  }

  span:nth-child(4) {
    position: absolute;
    right: 15px;
    font-size: 10px;
    line-height: 18px;
    font-weight: 100px;
  }

  span:nth-child(2) {
    position: absolute;
    right: 100px;
    font-size: 10px;
    line-height: 18px;
    font-weight: 100px;
  }
}
.icon path {
  transition: all 0.5s;
}
.icon:hover {
  .icon path {
    fill: #d81e06;
    transition: all 0.5s;
  }
}
.icon:active {
  .icon path {
    fill: #d81e06;
    transition: all 0.5s;
  }
}
</style>