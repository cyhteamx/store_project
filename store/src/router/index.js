import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      redirect: '/order'
    },
    {
      // path: '/store',
      // component: resolve => require(['../components/common/Home.vue'], resolve),
      // meta: {title: '首页'},
      path: '/',
      component: resolve => require(['../components/common/Home.vue'], resolve),
      meta: { title: '自述文件' },
      children: [
        {
          path: '/order',
          component: resolve => require(['../components/order/Order.vue'], resolve),
          meta: {title: '订单'}
        }, {
          path: '/product_list',
          component: resolve => require(['../components/product/Product.vue'], resolve),
          meta: {title: '商品'}
        }, {
          path: '/category_list',
          component: resolve => require(['../components/product/ProductCategory.vue'], resolve),
          meta: {title: '商品类目'}
        }
      ]
    }, {
      path: '/login',
      component: resolve => require(['../components/login/Login.vue'], resolve)
    }
  ]
})
