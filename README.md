# Spring MyBatis Starter

Spring Boot 结合MyBatis的示例启动项目，包含POJO、Mapper、XML源代码自动生成工具。

## 运行工程依赖的组件

### DB(必选)

DB采用的是PostgreSQL，PostgreSQL采用宽松的BSD协议。安装数据库后，需要在数据库中创建dolphin库，创建book表。



```sql
-- Table: public.book

-- DROP TABLE public.book;

CREATE TABLE public.book
(
  id bigint NOT NULL, -- 主键
  name character varying(1024), -- 书籍名称
  isbn character varying(16) NOT NULL -- ISBN
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.book
  OWNER TO postgres;
COMMENT ON TABLE public.book
  IS '书籍表';
COMMENT ON COLUMN public.book.id IS '主键';
COMMENT ON COLUMN public.book.name IS '书籍名称';
COMMENT ON COLUMN public.book.isbn IS 'ISBN';
```



### 连接池管理（Connection Pool）

连接池使用HikariCP，一个非常轻量级的高性能连接池组件。（貌似现在没起作用）



## 运行项目

### 自动生成POJO\Mapper\XML

切换到项目目录，运行命令：

```bash
gradle mybatisGenerate
```

即可在对应的目录下生成目标文件。

### 获取数据

curl或者浏览器访问：`http://localhost:18080/api/book/all`。



![获取数据结果](https://raw.githubusercontent.com/hualongdata/spring-examples/master/spring-mybatis-starter/image/Selection_002.png)





## 工程目录结构

- [start-web](start-web)：控制器、Web配置、Boot启动类，Web接口层代码，HTTP请求入口层
- [start-business](start-business)：业务逻辑层
- [start-data](start-data)：数据访问层
- [start-common](start-common)：一些公共和通用功能
- [start-code-autogenerator](start-code-autogenerator)：POJO、Mapper、XML代码自动生成

## IDE

- 下载 Jetbrains IDEA: `https://www.jetbrains.com/idea/`
- 安装 Lombok 插件：**Preferences** -> **Plugins** -> **Browse repositories** -> 搜索`Lombok plugin` 安装
    插件地址：`https://plugins.jetbrains.com/plugin/6317-lombok-plugin`
- 使用 IDEA 打开项目目录，并导入为 **Gradle** 工程

## 关于使用 `gradlew` 下载 Gradle 安装包很慢问题。

解决方案：

**创建目录**

```
cd ~/
mkdir -p .gradle/wrapper/dists
```

*Windows*

进行用户主目录，再创建 `.gradle/wrapper/dists` 目录。（注意：可能你需要在 CMD 中创建带`.`字符的目录）

**下载 gradle-3.2.1-all.tar.gz 包**

```
cd .gradle/wrapper/dists
wget http://file.hualongdata.com/gradle-3.2.1-all.tar.gz
tar zxf gradle-3.2.1-all.tar.gz
```


