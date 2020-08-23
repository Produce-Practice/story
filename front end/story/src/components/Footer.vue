<template>
<!-- 相对定位，在每个界面最下方使用 -->
  <footer class="footer">
    <p class="foot">拾一片光阴与你诉说</p>
    <p class="team">&copy; Copyright - 2020 - WHUT(武汉理工大学) - 007大战中软国际</p>
  </footer>
</template>
<style lang="less" scoped>
.footer {
  background-color: #f6f6f6;
  padding: 25px 0;
  color: #43484e;
  font-size: 16px;
  position: relative;
  // bottom: 0%;
  float: left;
  width: 100%;
  margin-top: 1px;
  text-align: center;
}
.foot {
  font: 15px "Trebuchet MS", Arial, Helvetica, sans-serif;
  color: #74bcec;
}
.team {
  font-family: serif;
  font-size: 15px;
}
</style>
