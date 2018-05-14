# store_project
store_project

1.项目简介

	该项目包含前端及后台，前端用vue.js 2.0实现，后台使用spring boot 2.0.1.RELEASE,spring cloud Finchley.RC1实现，数据库使用关系型mysql,非关系数据库选用redis,项目管理使用gradle。项目前后端分离，后期可以考虑做一个移动端app。

2.前端部分

	该部分主要讲解前端部分，前端使用vue.js 2.0实现,实现了前后端的分离。

	2.1 前端建构:

	store
	--build 			build文件夹：打包配置的文件夹

	--config 			相关配置文件

	--src               资源文件

	----assets			存放图片等静态资源

	----common      	公用相关资源

	----components		页面部分

	----router			路由

	----App.vue         App.vue是我们的主组件，所有页面都是在App.vue下进行切换的。其实你也可以理解为所有的路由也是App.vue的子组件。所以我将router标示为App.vue的子组件

	----main.js         main.js是我们的入口文件，主要作用是初始化vue实例并使用需要的插件。

	--static

	具体详细解释如下:

	Vue.js】vue项目目录作用

	1. build文件夹：打包配置的文件夹

	　　1.1  webpack.base.conf.js ：打包的核心配置

	　　1.2  build.js：构建生产版本，项目开发完成之后，通过build.js打包（加载base与prod，读取完之后通过webjpack命令对项目进行打包）

	　　1.3  webpack.prod.conf.js：被build.js调用，webpack生产包的一个配置。基础代码都在1.1里面写，1.3是对1.1的扩展与补充

	　　1.4  dev-client.js：热更新的插件，进行对客户端进行重载

	　　1.5  dev-server.js：服务器。（背后的原理是启动一个express框架，这是一个基于node做的一个后端框架，后端框架可以在前端起一个服务）

	　　1.6  vue-loader.conf.js：被base加载，

	　　1.7  utils.js：工具类，公共的配置

	2. config文件夹：打包的配置，webpack对应的配置

	　　2.1 index.js：可与1.1合并成一个文件，但由于spa想做一个清晰的架构，因此把它们拆分开了

	3. src文件夹：开发项目的源码

	4. App.vue ： 入口组件

	5. static文件夹：静态资源，图片

	6. .babelrc：ES6解析的配置

	7. .gitignore：忽略某个或一组文件git提交的一个配置

	8. index.html：单页面的入口，通过webpack的打包构建之后，会对src源码进行编译，最终把它们插入到html里面来

	9. package.json：基础配置，告诉我们项目的信息（版本号、项目姓名、依赖）

	10. node_modulues：项目的安装依赖

2.2 前端使用vue.js 2.0实现,UI部分使用element-ui,使用element-ui怎么做响应式布局目前不是太懂，没用过，暂不考虑。网络请求使用axios实现，请求公共参数在拦截器部分加入，请求响应部分也做相应的拦截处理，具体参考源码:/store_project/store/src/main.js。

2.3 定义一个存放全局变量js文件，主要方便相关参数修改及管理。

2.4 日期格式化使用moment.js实现。

2.5 前端流程
	
	2.5.1 登录页面

		前端请求后台接口/jwt/auth获取access_token,后台设置接口/jwt/auth为相应白名单,请求该资源得到access_token,并把请求该资源得到access_token存储到本地localStorage。之后请求都需要携带相应的access_token后台进行权限认证。

	2.5.2 登录账号相关菜单权限控制，暂未实现。

	2.5.3 登录页面

2.6 开发环境运行

	npm run dev

	目前前端和后台交互需要跨域,Mac环境,终端使用命令:open -a "Google Chrome" --args --disable-web-security --user-data-dir

	注意:一定先彻底退出chrome浏览器,windows环境自行百度。

	生产环境使用ngnix解决跨域问题。


3.后台部分
	
	后台使用spring boot 2.0.1.RELEASE,spring cloud Finchley.RC1实现，数据库使用关系型mysql,非关系数据库选用redis,项目管理使用gradle。详情见以下模块说明。
	
	3.1 后端结构

	microservice-store-cloud

	--microservice-store-eureka 					           服务注册中心

	--microservice-store-config 					           配置,暂未实现

	--microservice-store-zuul						             网关,请求先通过网关，网关先做相应的权限认证，认证通过后转发

	--microservice-store-auth						             认证中心微服务

	--microservice-store-common                    通用资源

	--microservice-store-common-mapper				        mybatis的mapper部分

	--microservice-store-web-admin					           后台管理系统微服务

	--microservice-store-service-user-api			       用户服务API

	--microservice-store-service-user               用户微服务

	--microservice-store-service-product-api        产品服务API

	--microservice-store-service-product            产品微服务

	3.2 初始化sql

		数据库使用mysql,简历数据库store,建议账号密码为store/store

		初始化sql路劲:/SQL/store.sql

	3.3 服务注册中心

		服务注册中心microservice-store-eureka,用于微服务注册及发现。暂未考虑高可用。

	3.4 配置中心

		配置中心microservice-store-config,暂未实现

	3.5 网关

		微服务网关microservice-store-zuul,主要用于转发及权限认证,高可用可以使用ngnix。

    3.5.1 微服务之间的调用
    
        最初微服务之间的调用都是通过网关,新增授权后,通过网关转发时,由于网关只能自上而下转发携带相应的header,由下游微服务通过网关转发时，相应的header并不能转发,故header中的access_token丢失。并且通过网关转发，由于一直在获取access_token导致死循环问题。
        
        修改为微服务之间的调用直接调用,不在通过网关转发。
        
    3.5.2 网关stripPrefix属性配置
    
        zuul:
            routes:
                users:
                    path: /user/**
                    stripPrefix: false
    
    假设请求路劲:/user/list
    stripPrefix: false时转发到user微服务的/user/list接口
    stripPrefix: true时转发到user微服务的/list接口

    3.6 认证中心
    
    3.6.1 jwt认证
        
    3.6.2 client认证

        
















