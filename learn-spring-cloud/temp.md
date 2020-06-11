1. 选择镜像

![image-20200608213601788](C:\Users\barry\AppData\Roaming\Typora\typora-user-images\image-20200608213601788.png)

2. 填写maven信息

![image-20200608213629541](C:\Users\barry\AppData\Roaming\Typora\typora-user-images\image-20200608213629541.png)

3. 选择依赖：web、eureka client

![image-20200608213722170](C:\Users\barry\AppData\Roaming\Typora\typora-user-images\image-20200608213722170.png)

4. 





自定义元数据信息，以可用来区分服务器的一些特性，例如cpu，内存等

```
# 自定义元数据信息，在eureka server 配置加上：
eureka.instance.metadata-map.author:BarryLee
```

打开： http://localhost:7900/eureka/status  可以看到

![image-20200608222305661](C:\Users\barry\AppData\Roaming\Typora\typora-user-images\image-20200608222305661.png)

```
# 自定义元数据信息，在eureka-provider加上：
eureka.instance.metadata-map.author:barryhahaha
```

打开： http://localhost:7900/eureka/apps  可以看到

![image-20200608222954631](C:\Users\barry\AppData\Roaming\Typora\typora-user-images\image-20200608222954631.png)

