import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      redirect: '/login'
    },
    {
      path: '/store',
      component: resolve => require(['../components/common/Home.vue'], resolve),
      children: [
        {
          path: '/',
          component: resolve => require(['../components/order/Order.vue'], resolve)
        },
        {
          path: '/product_list',
          component: resolve => require(['../components/product/Product.vue'], resolve)
        }
      ]
    }, {
      path: '/login',
      component: resolve => require(['../components/login/Login.vue'], resolve)
    }
  ]
})
