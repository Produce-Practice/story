import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    isShow: false,
    toWho: "请输入内容"
  },
  mutations: {
    changeShow(state) {
      state.isShow = !state.isShow;
    },
    setToWho(state, data) {
      state.toWho = data;
    }
  },
  actions: {},

  getters: {}
});
