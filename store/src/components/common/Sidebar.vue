<template>
  <div class="sidebar">
    <el-menu class="sidebar-el-menu" :default-active="onRoutes" :collapse="collapse" background-color="#324157"
             text-color="#bfcbd9" active-text-color="#20a0ff" unique-opened router>
      <template v-for="item in items">
        <template v-if="item.subs.length">
          <el-submenu :index="item.url" :key="item.url">
            <template slot="title">
              <i :class="item.icon"></i><span slot="title">{{ item.name }}</span>
            </template>
            <el-menu-item v-for="(subItem,i) in item.subs" :key="i" :index="subItem.url">
              {{ subItem.name }}
            </el-menu-item>
          </el-submenu>
        </template>
        <template v-else>
          <el-menu-item :index="item.url" :key="item.url">
            <i :class="item.icon"></i><span slot="title">{{ item.name }}</span>
          </el-menu-item>
        </template>
      </template>
    </el-menu>
  </div>
</template>

<script>
  import bus from './bus';
  import axios from 'axios';

  var config = require('config')
  config = process.env.NODE_ENV === 'development' ? config.dev : config.build
  const ERR_OK = 200;

  export default {
    data() {
      return {
        collapse: false,
        items: [
        ]
      }
    },
    created() {
      // 通过 Event Bus 进行组件间通信，来折叠侧边栏
      bus.$on('collapse', msg => {
        this.collapse = msg;
      });
    // 如果url里有openid, 设置进cookie
    // var openid = this.$route.query.openid;
    // if(typeof openid !== 'undefined') {
    //   var exp = new Date();
    //   exp.setTime(exp.getTime() + 3600 * 1000);//过期时间60分钟
    //   document.cookie = 'openid=' + openid + ";expires=" + exp.toGMTString();
    // }
    // //获取openid
    // if(getCookie('openid') == null) {
    //   location.href = config.openidUrl + '?returnUrl=' +  encodeURIComponent(config.sellUrl + '/#/');
    // }
    // this.classMap = ['decrease', 'discount', 'special', 'invoice', 'guarantee'];
    // let selectedGoods = window.selectedGoods;
    // selectedGoods = selectedGoods ? JSON.parse(selectedGoods) : [];
      axios.get('/admin/menu/list').then(response => {
        response = response.data;
        if (response.code === ERR_OK) {
          this.items = response.data;
        }
      });
    },
    computed: {
      onRoutes() {
        return this.$route.path.replace('/', '');
      }
    }
  }
</script>

<style scoped>
  .sidebar{
    display: block;
    position: absolute;
    left: 0;
    top: 70px;
    bottom:0;
  }
  .sidebar-el-menu:not(.el-menu--collapse){
    width: 250px;
  }
  .sidebar > ul {
    height:100%;
  }
</style>
