# PDF完整实例
SpringBoot + FreeMarker + FlyingSaucer 实现pdf在线预览下载

## 运行方式
### 方式一：IDEA开发工具中运行
本工程为微服务工程,项目导入到IEAD中即可进行调试和运行验证
### 方式二：maven手动打包
```aidl
# 项目根目录下编译
mvn clean package
# 运行
java -jar target/demo-pdf-0.0.1-SNAPSHOT.jar
# 浏览器访问
http://localhost:8999
```

## 2021年10月27日
1、ftl模板调整为对象参数填充  
2、支持字体自定义（仿宋GB2312、黑体、宋体等）  
3、图片支持base64动态填充  
4、升级flying-saucer-pdf组件版本为最新版  
5、接下来准备研究echarts的支持

## 交流方式
微信：  
![RUNOOB 图标](src/main/resources/static/imgs/qst1.png)  
QQ：157195079
