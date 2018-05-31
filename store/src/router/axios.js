/**
 *
 * http配置
 *
 */

import axios from 'axios'
import store from '../store'
import router from '../router/router'
import { getToken, setToken, removeToken } from '@/util/auth'
import { Message } from 'element-ui'
import errorCode from '@/const/errorCode'
import NProgress from 'nprogress' // progress bar
import 'nprogress/nprogress.css'// progress bar style

// 超时时间
axios.defaults.timeout = 30000
// 跨域请求，允许保存cookie
axios.defaults.withCredentials = true
NProgress.configure({ showSpinner: false })// NProgress Configuration
let msg
// HTTPrequest拦截
axios.interceptors.request.use(config => {
  NProgress.start() // start progress bar
  config.headers.common['Content-Type'] = 'application/json;charset=UTF-8';
  
  // if (store.getters.access_token) {
  //   config.headers['Authorization'] = 'Bearer ' + getToken() // 让每个请求携带token--['X-Token']为自定义key 请根据实际情况自行修改
  // }
  if (store.getters.access_token) {
    config.headers.common['access-token'] = getToken();
  }
  
  // const token = localStorage.getItem('access-token');
  // // token = 'eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsInVzZXJJZCI6IjEiLCJuYW1lIjoiYWRtaW4iLCJleHAiOjE1MjU4OTExNzN9.ailZYBohJfO36Vz7xRtxnhhiYgnHp4UXcW1wK3UzJGn7zPZKEg-3bpoH4cxacZoFRx-7L3d5T1fKAydmgoiUUFHSc4iVpU7cv3ZCxjNNE8ZDD6r0Qiusf_Eyo8mXgWl5Hl4u8BcKbzH9lLCGvEEdpvHvi_fm62IhcZfIQ8f1964';
  // if (token) {
  //   // Bearer是JWT的认证头部信息
  //   // config.headers.common['Authorization'] = 'Bearer ' + token;
  //   config.headers.common['access-token'] = token;
  // }
  
  return config
}, error => {
  return Promise.reject(error)
})

// HTTPresponse拦截
axios.interceptors.response.use(data => {
  NProgress.done()
  return data
}, error => {
  NProgress.done()
  let errMsg = error.toString()
  let code = errMsg.substr(errMsg.indexOf('code') + 5)
  Message({
    message: errorCode[code] || errorCode['default'],
    type: 'error'
  })
  return Promise.reject(new Error(error))
})

export default axios
