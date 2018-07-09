/**
 * 配置编译环境和线上环境之间的切换
 *
 * baseUrl: 老项目域名地址
 * khglUrl: 客户管理域名地址
 * dicUrl : 字典服务器地址
 * routerMode: 路由模式
 * imgBaseUrl: 图片所在域名地址
 * welUrl :默认欢迎页
 *
 */


let baseUrl = '';
let iconfontVersion = ['567566_r22zi6t8noas8aor', '599693_0b5sleso3f1j1yvi'];
let iconfontUrl = `//at.alicdn.com/t/font_$key.css`;
let codeUrl = `/user/code`
if (process.env.NODE_ENV == 'development') {
  baseUrl = `http://127.0.0.1:8888`;
} else if (process.env.NODE_ENV == 'production') {
  baseUrl = `http://127.0.0.1`;
}

export {
  baseUrl,
  iconfontUrl,
  iconfontVersion,
  codeUrl
}
