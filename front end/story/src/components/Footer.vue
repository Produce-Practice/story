<template>
<!-- 相对定位，在每个界面最下方使用 -->
<!-- <el-footer> -->
  <footer class="footer">
    <p class="foot">拾一片光阴与你诉说</p>
    <p class="team">&copy; Copyright - 2020 - WHUT(武汉理工大学) - 007大战中软国际</p>
  </footer>
<!-- </el-footer> -->
</template>
<style lang="less" scoped>
.footer {
  background-color: #f6f6f6;
  padding: 25px 0px;
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
  font: 18px "Trebuchet MS", Arial, Helvetica, sans-serif;
  color: #4aa6e4;
  padding: 10px 10px;
}

.team {
  font-family: serif;
  font-size: 15px;
  font-weight: bold;
}
</style>
