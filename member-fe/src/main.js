// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui'
import axios from 'axios'
import VueAxios from 'vue-axios'
import 'element-ui/lib/theme-chalk/index.css'
import './assets/index.css' //自定义css样式
// 导入api接口
import api from './axios/api'
// 将api挂载到vue的原型上
Vue.prototype.$api = api;

Vue.config.productionTip = false;

Vue.use(ElementUI);
Vue.use(VueAxios, axios);

// // 这里是从后台获取的用户角色，假设为admin
// const role = 'admin';
// // 在进入一个页面前会触发 router.beforeEach 事件
// router.beforeEach((to, from, next) => {
//   if(to.meta.roles.includes(role)) {
//     next();
//   } else {
//     // next({path: '/404'});
//     Vue.prototype.$alert('您无权访问！', '提示', {
//       confirmButtonText: '确定',
//       callback: action => {
//         // this.$message({
//         //   type: 'info',
//         //   message: `action: ${ action }`
//         // });
//       }
//     });
//   }
// });

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
});
