# SpringBoot-staging

# 集成 | Integration 
- **Lombok**：主要用于解决实体类美观度,@Data注释于类头,IDEA
需要安装插件File——Settings——plugins——Browse Repositories 搜索Lombok 安装重启IDEA即可。
- **Druid**: Druid Spring Boot Starter 用于帮助你在Spring Boot项目中轻松集成Druid数据库连接池和监控
- **Swagger**：实现对Controller-ApI管理,用法参照document Swagger和Swagger.java.vm 
- **Generator**: 实现自动生成相应模块代码,只需修改数据库配置信息即可(MpGenerator)
- **Mybatis-Plus**: Mybatis 增强工具包 - 只做增强不做改变，简化CRUD操作 可以安装插件MybatisX 同理Lombok

# 使用 | Use 
① **获取项目:git clone https://github.com/LJYYAnimo/SpringBoot-staging.git**  
② **修改配置:修改Web模块下的application.properties 数据库连接即可**  
③ **自动生成:修改Generator数据库配置 Run MpGenerator 即可生成对应的模块代码**  
④ **开箱即用:编写Web模块Controller代码,如需结合Swagger请看document Swagger.java.vm**  
⑤ **打包部署:IDEA右侧Maven Project 选择parent节点下的Lifecycle 打包前可以点击clean先清空所有模块的target 在通过点击package进行打包
打包完成之后进入到Web模块下的target在当前目录下打开cmd 输入java -jar staging-start.jar --server.port=8080**