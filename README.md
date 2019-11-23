---------------------
这个项目是一个小demo

项目中用到了SpringBoot+vue+thymeleaf

数据库Mysql 5.5，tomcat7.0，jdk 1.8

需要一张表：Hero

CREATE TABLE `hero` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `hp` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6194 DEFAULT CHARSET=utf8;

springboot的配置文件：
```
#database
spring.datasource.url=jdbc:mysql://127.0.0.1:3306/数据库名?characterEncoding=UTF-8
spring.datasource.username=
spring.datasource.password=
spring.datasource.driver-class-name=com.mysql.jdbc.Driver

#mybatis
mybatis.mapper-locations=classpath:mapper/*.xml
mybatis.type-aliases-package=com.yongyou.yfl.pojo
 
#thymeleaf
spring.thymeleaf.mode=LEGACYHTML5
spring.thymeleaf.encoding=UTF-8
spring.thymeleaf.content-type=text/html
spring.thymeleaf.cache=false
```