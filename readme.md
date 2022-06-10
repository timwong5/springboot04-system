# Notebook

1.首页配置 注意所有页面的静态资源需要使用thymeleaf接管 @{}  
2.国际化
添加中英文切换标签链接
自定义地区解析器组件 新建MyLocaleResolver，作为自己的国际化地区解析器
3.登录功能的实现 在主程序同级目录下新建controller包，在其中新建类loginController，处理登录请求
登录拦截器 在config目录下，新建一个登录拦截器类LoginHandlerInterceptor
4.CRUD环节 查找所有员工
点击dashboard.html页面中的Customers展示跳转到list.html页面显示所有员工信息