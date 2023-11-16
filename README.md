# starr_blog
1、项目描述：
项目是基于springboot+Vue实现的前后端分离的多用户管理的个人博客系统，实现基本的用户注册，用户登录功能，不同用户登录后台的权限不同，可以实现用户管理，文章发表，设置标签等增删改查操作。

2、开发环境
	JDK1.8
	IntelliJ IDEA 2021.1
	Visual Studio Code
	Mysql 5.7

3、技术选型
	后端
> SpringBoot : 容器+MVC框架
> SpringSecurity : 认证和授权框架
> MyBatis : ORM框架
> PageHelper : Mybatis通用分页插件
	前端
> Vue-cli4 : Vue.js 开发的标准工具
> Vue-router : 路由框架 
> Vuex : 全局状态管理框架
> Axios : 前端HTTP框架
> Element : UI库 
> v-charts : 基于Echarts的图表框架
> mavon-editor : 基于vue的markdown编辑器

4、数据库设计
1)	article 表存储文章信息，包括文章的 ID、标题、内容、html 版本、用户 ID、文章所属类别的 ID、文章标签、封面资源地址、阅读量、是否允许评论、添加时间、修改时间、状态。
2)	article_tag_relation 表存储文章和标签之间的关系，包括关系的 ID、文章的 ID、标签的 ID。
3)	category 表存储文章分类信息，包括分类的 ID、用户的 ID、分类名称、分类描述。
4)	comment 表存储评论信息，包括评论的 ID、文章的 ID、评论人名称、评论人邮箱、评论内容、评论创建时间、评论修改时间、评论状态。
5)	record表存储用户记录，包括用户id,最新评论数，总评论数，最新阅读数，总阅读数，以及记录创建的时间
6)	tag表存储标签信息，标签的id、标签的名称
7)	role表存储角色的信息，中文名和英文名
8)	user表存储用户信息，用户名，密码，邮箱，头像资源地址，添加时间，修改时间，状态
9)	user_role_relation表存储用户角色关系，1为管理员，默认角色为 2，表示普通用户。
![image](https://github.com/star-start/starr_blog/assets/111479382/56974424-1a15-4139-a46f-ba99883d0f37)

 
5、数据库表描述
表 article 结构描述
字段名	数据类型	是否允许为空	默认值	备注
article_id	int	NO	NULL	文章表主键id，自增
title	varchar(64)	NO	NULL	文章标题
content	mediumtext	NO	NULL	文章内容
html	mediumtext	NO	NULL	文章markdown后html
user_id	int	NO	NULL	用户id，外键，参照 user 表的 user_id
category_id	int	NO	NULL	文章所属类别的id，外键，参照 category 表的 category_id
article_tags	varchar(64)	NO	NULL	文章标签，多个以逗号分隔
summary	varchar(200)	NO	NULL	文章封面资源地址
views	bigint	NO	0	文章阅读量
enable_comment	tinyint	NO	1	0-不允许评论 1-允许评论
create_time	datetime	NO	CURRENT_TIMESTAMP	添加时间
update_time	datetime	NO	CURRENT_TIMESTAMP	修改时间
status	tinyint	NO	1	0-删除


表 article_tag_relation 结构描述
字段名	数据类型	是否允许为空	默认值	备注
relation_id	int	NO	NULL	关系表id，自增
article_id	int	NO	NULL	文章id，外键，参照 article 表的 article_id
tag_id	int	NO	NULL	标签id，外键，参照 tag 表的 tag_id


表 category 结构描述
字段名	数据类型	是否允许为空	默认值	备注
category_id	int	NO	NULL	分类表主键，自增
user_id	int	NO	NULL	用户id
category_name	varchar(64)	NO	NULL	分类名
category_describe	varchar(64)	NO	NULL	分类描述


表 comment 结构描述
字段名	数据类型	是否允许为空	默认值	备注
comment_id	int	NO	NULL	评论表主键id，自增
article_id	int	NO	NULL	文章id
commentator_name	varchar(64)	NO	NULL	评论人名称
commentator_email	varchar(64)	NO	NULL	评论人邮箱
comment_content	varchar(200)	NO	NULL	评论内容
comment_create_time	datetime	NO	CURRENT_TIMESTAMP	评论创建时间
commentator_location	varchar(64)	NO	NULL	评论人位置
reply_content	varchar(200)	NO	NULL	回复内容
reply_create_time	datetime	NO	CURRENT_TIMESTAMP	回复创建时间
status	tinyint	NO	2	状态，0-删除 1-正常 2-待审核


表 record 结构描述
字段名	数据类型	是否允许为空	默认值	备注
record_id	int	NO	NULL	用户记录表主键id，自增
user_id	int	NO	NULL	用户id
new_comments	int	NO	0	最新评论数
comments_count	int	NO	0	总评论数
new_views	bigint	NO	0	最新阅读数
views_count	bigint	NO	0	总阅读数
record_create_time	datetime	NO	CURRENT_TIMESTAMP	记录创建时间


表 tag 结构描述
字段名	数据类型	是否允许为空	默认值	备注
tag_id	int	NO	NULL	标签表主键id，自增
tag_name	varchar(64)	NO	NULL	标签名称，唯一


表 role 结构描述
字段名	数据类型	是否允许为空	默认值	备注
role_id	int	NO	NULL	角色表主键id，自增
role_name	varchar(64)	YES	NULL	角色英文名称
role_name_zh	varchar(64)	YES	NULL	角色中文名称


表 user 结构描述
字段名	数据类型	是否允许为空	默认值	备注
user_id	int	NO	NULL	用户表主键id，自增
username	varchar(64)	NO	NULL	用户名
password	varchar(64)	NO	NULL	密码
email	varchar(64)	NO	NULL	邮箱
avatar	varchar(255)	NO	NULL	头像资源地址
create_time	datetime	NO	CURRENT_TIMESTAMP	添加时间
update_time	datetime	NO	CURRENT_TIMESTAMP	修改时间
status	tinyint	NO	1	0-删除 1-正常


表 user_role_relation 结构描述
字段名	数据类型	是否允许为空	默认值	备注
relation_id	int	NO	NULL	用户角色关系表id，自增
user_id	int	NO	NULL	用户id
role_id	int	NO	2	角色id
其中，默认角色为 2，表示普通用户。

 
6、组织架构
后端：
 ![image](https://github.com/star-start/starr_blog/assets/111479382/6d726e9f-9c13-4b13-9384-716964277d5b)



前端：是在开源软件上找的源码，大致阅读后基本可以理解内容，也可以对内容做修改。
 ![image](https://github.com/star-start/starr_blog/assets/111479382/6b449280-6be4-4d66-8b68-6d1c827b5be1)


7、环境部署
项目已经同步上GitHub，地址：https://github.com/star-start/STAR-BLOG
1.	clone 项目到本地，IDE工具（我用的IDEA）打开starblog后端项目
2.	提前在本地 Mysql 中创建一个空的数据库 starblog，在根目录下找到lovecanfly.sql，在该新建数据库中执行。同时修改项目resources 目录下的 application.properties 中关于数据的配置（如密码等）
3.	Maven仓库顺利引入后，启动 StarblogApplication
4.	访问：http://localhost:8081
5.	IDE工具（我用的WebStorm）打开 vuelovecanfly 前端项目，根目录终端命令行依次输入 npm install安装依赖、npm run serve 启动项目
6.	访问：http://localhost:8080
8、效果图
首页：
 ![image](https://github.com/star-start/starr_blog/assets/111479382/a8ea3ee4-2236-4ac1-8ccb-367c6d3f7c0c)

注册：
 ![image](https://github.com/star-start/starr_blog/assets/111479382/9347ae79-485d-4e50-908f-cbaa0ba2361a)

登录页面：
 ![image](https://github.com/star-start/starr_blog/assets/111479382/a5419d99-8730-4952-b1a1-9abd21b5b872)

首页：
 
 ![image](https://github.com/star-start/starr_blog/assets/111479382/2c31d24e-0650-4643-89ba-c86498b0203d)
![image](https://github.com/star-start/starr_blog/assets/111479382/d1a3a541-0433-4b21-8e90-6e716528799c)
![image](https://github.com/star-start/starr_blog/assets/111479382/6d0e1edb-048e-4075-926e-954cfbe5ffcc)

 


普通用户后台：
 ![image](https://github.com/star-start/starr_blog/assets/111479382/08961a10-8441-4632-b212-d62220147ffd)

 ![image](https://github.com/star-start/starr_blog/assets/111479382/4902221a-06b7-4880-bd02-6163fce2bea2)

 ![image](https://github.com/star-start/starr_blog/assets/111479382/49fe7a04-d0ca-4178-9f6b-e1c08c9e1c2d)

 ![image](https://github.com/star-start/starr_blog/assets/111479382/4a4524fe-bd45-45c7-a82e-ca069e29b71a)

 ![image](https://github.com/star-start/starr_blog/assets/111479382/4c1b678b-1366-40a7-b921-d3b8e538a69f)

管理员后台：
 
 ![image](https://github.com/star-start/starr_blog/assets/111479382/175622ee-e8c4-48b7-8eff-7de128c33e0d)

 ![image](https://github.com/star-start/starr_blog/assets/111479382/3fee0418-8309-41b0-97bb-a006d46cbfb9)

 ![image](https://github.com/star-start/starr_blog/assets/111479382/8b951545-98c7-40ed-9719-e525f0de5006)

 
管理员后台其他页面类似就不截图了。
测试用户：（只能进首页，没有权限进后台）
 ![image](https://github.com/star-start/starr_blog/assets/111479382/d333df6c-f7c1-4228-aae0-33b46e41856c)

 ![image](https://github.com/star-start/starr_blog/assets/111479382/3c29f9ce-081b-4a6e-b5e8-3b60e7e1beed)


9、一些代码的理解：（下面两个比较特别）
Web.SecurityConfig.java
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserService userService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());

    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers(  "/","/css/**","/js/**","/fonts/**","/img/**", "/index.html", "/favicon.ico","/upload/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/home/**").permitAll()
                .antMatchers("/admin/**").hasRole("admin")
                .anyRequest().authenticated()//其他的路径都是登录后即可访问
                .and()
                .formLogin()
                .loginPage("/login_p") //未登录但 访问需登录接口时 的重定向接口
                .loginProcessingUrl("/login") //作为前端登录接口（username,password）
                .successHandler(
                        new AuthenticationSuccessHandler() {
                            @Override
                            public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
                                httpServletResponse.setContentType("application/json;charset=utf-8");
                                ObjectMapper om = new ObjectMapper();
                                PrintWriter out = httpServletResponse.getWriter();
                                out.write(om.writeValueAsString(new RepMsg("success","登陆成功！")));
                                out.flush();
                                out.close();
                            }
                        })
                .failureHandler(
                        new AuthenticationFailureHandler() {
                            @Override
                            public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
                                httpServletResponse.setContentType("application/json;charset=utf-8");
                                String msg = "";
                                if (e instanceof BadCredentialsException ||
                                        e instanceof UsernameNotFoundException) {
                                    msg = "账户名或者密码输入错误!";
                                } else if (e instanceof LockedException) {
                                    msg = "账户被锁定，请联系管理员!";
                                } else if (e instanceof CredentialsExpiredException) {
                                    msg = "证书过期，请联系管理员!";
                                } else if (e instanceof AccountExpiredException) {
                                    msg = "账户过期，请联系管理员!";
                                } else if (e instanceof DisabledException) {
                                    msg = "账户暂未审核通过，请联系管理员!";
                                } else {
                                    msg = "登录失败!";
                                }
                                httpServletResponse.setStatus(401);
                                ObjectMapper om = new ObjectMapper();
                                PrintWriter out = httpServletResponse.getWriter();
                                out.write(om.writeValueAsString(new RepMsg("error",msg)));
                                out.flush();
                                out.close();
                            }
                        })
                .usernameParameter("username")
                .passwordParameter("password")
                .permitAll()
                .and()
                .logout()
                .logoutSuccessHandler(new LogoutSuccessHandler() {
                    @Override
                    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
                        httpServletResponse.setContentType("application/json;charset=utf-8");
                        ObjectMapper om = new ObjectMapper();
                        PrintWriter out = httpServletResponse.getWriter();
                        out.write(om.writeValueAsString(new RepMsg("success","注销成功！")));
                        out.flush();
                        out.close();
                    }
                })
                .permitAll()
                .and()
                .csrf()
                .disable()//禁用csrf防御机制(跨域请求伪造)，这么做在测试和开发会比较方便。
                .exceptionHandling()
                .accessDeniedHandler(new AccessDeniedHandler(){
                    @Override
                    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
                        httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
                        httpServletResponse.setContentType("application/json;charset=utf-8");
                        ObjectMapper om = new ObjectMapper();
                        PrintWriter out = httpServletResponse.getWriter();
                        out.write(om.writeValueAsString(new RepMsg("error","权限不足，请联系管理员！")));
                        out.flush();
                        out.close();
                    }
                });
    }
}


理解：
使用Spring Security框架的Java配置类，用于配置Web应用的安全性。这个类扩展了WebSecurityConfigurerAdapter类，实现了认证、授权、忽略、登录、注销等功能。
在这段代码中，使用了@Configuration注解将这个类标记为Spring的配置类。使用@Autowired注解自动装配了一个UserService对象，用于处理用户相关信息。
configure(AuthenticationManagerBuilder auth)方法中，使用了auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder())方法来配置认证管理器，使用BCryptPasswordEncoder类来加密密码。
configure(WebSecurity web)方法中，使用web.ignoring().antMatchers()方法忽略了一些资源，这些资源将不会受到Spring Security的保护。
configure(HttpSecurity http)方法中，使用了http.authorizeRequests()方法来配置授权规则，使用antMatchers()方法指定的路径只有拥有指定的角色才能访问。使用formLogin()方法配置登录功能，使用loginPage()方法指定登录页面，使用loginProcessingUrl()方法指定登录接口，使用successHandler()方法指定登录成功的处理器，使用failureHandler()方法指定登录失败的处理器。使用logout()方法配置注销功能，使用logoutSuccessHandler()方法指定注销成功的处理器。使用exceptionHandling()方法配置异常处理器，使用accessDeniedhandler()方法指定访问拒绝时的处理器。
这段代码还定义了几个内部类，分别是AuthenticationSuccessHandler、AuthenticationFailureHandler、LogoutSuccessHandler和AccessDeniedHandler。这些类实现了对应的接口，用于在认证成功、认证失败、注销成功、访问拒绝时执行相应的处理。
在这段代码中，使用了ObjectMapper和PrintWriter类来将处理结果以JSON格式写入响应中，这样前端就可以通过Ajax请求来获取处理结果。

2.异常处理
 
理解：
使用@RestControllerAdvice注解的Java类，用于处理控制器中抛出的异常。
使用@ExceptionHandler注解的方法用于处理特定类型的异常，在这里，方法sqlException()用于处理SQLException类型的异常。
方法中使用了instanceof关键字来判断异常是否为SQLIntegrityConstraintViolationException类型，如果是，则返回一个"该数据有关联数据，操作失败!"的错误消息。否则，返回一个"数据库异常，操作失败!"的错误消息。
这段代码的作用是在控制器中捕获SQLException异常，并返回相应的错误消息。
小tips: SQLIntegrityConstraintViolationException是Java中的一种异常类型，它是SQLException的子类。该异常表示数据库中的一个完整性约束被违反了。
例如，在数据库中有一个外键约束，表示一个表的一列只能包含另一个表的某一列的值。如果试图将一个不存在于另一个表的值插入到该列中，就会抛出SQLIntegrityConstraintViolationException异常。


10、项目改进
如果可以上传头像，普通用户可以更改自己的信息这样子会更完善一点。
寒假的时候继续跟进项目，现在来不及啦~~还有Docker部署。。。

