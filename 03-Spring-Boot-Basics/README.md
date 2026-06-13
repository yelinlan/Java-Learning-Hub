# Spring Boot 基础学习模块

## 📚 概述

Spring Boot 是 Spring 框架的快速开发框架，它通过自动配置、起步依赖等特性，大大简化了 Spring 应用的开发。本模块介绍 Spring Boot 的基础概念和配置。

## 🎯 学习目标

- [ ] 理解 Spring Boot 的自动配置原理
- [ ] 掌握配置文件的使用
- [ ] 学习属性绑定
- [ ] 理解 Spring Boot 的启动流程
- [ ] 掌握外部化配置

## 📖 学习内容

### 1. Spring Boot 核心特性

**自动配置（Auto-Configuration）**
- 根据类路径中的依赖自动配置
- 通过 `@SpringBootApplication` 启用
- 可以通过 `@EnableAutoConfiguration` 或 `@AutoConfigurationPackage` 控制

**起步依赖（Starter Dependencies）**
- 简化依赖管理
- 一个依赖包含多个相关组件
- 例如：spring-boot-starter-web

**内嵌服务器**
- 无需部署 WAR 文件
- 直接运行 JAR 文件
- 提高开发效率

### 2. 配置文件

**支持格式**
- application.properties
- application.yml / application.yaml

**优先级**
1. 命令行参数
2. 系统环境变量
3. application-{profile}.properties
4. application.properties
5. 默认配置

**示例配置：**
```yaml
# 应用配置
spring:
  application:
    name: my-app
  profiles:
    active: dev

# 服务器配置
server:
  port: 8080
  servlet:
    context-path: /api

# 日志配置
logging:
  level:
    root: INFO
    com.example: DEBUG
  file: logs/app.log

# 自定义属性
app:
  name: My Application
  version: 1.0.0
```

### 3. 属性绑定

**方式一：@Value 注解**
```java
@Component
public class AppConfig {
    @Value("${app.name}")
    private String appName;
}
```

**方式二：@ConfigurationProperties（推荐）**
```java
@Configuration
@ConfigurationProperties(prefix = "app")
public class AppProperties {
    private String name;
    private String version;
    
    // Getter and Setter
}
```

### 4. 配置文件优先级详解

**优先级从高到低：**
1. 命令行参数
   ```bash
   java -jar app.jar --server.port=9090
   ```

2. 系统环境变量
   ```bash
   export SPRING_DATASOURCE_URL=jdbc:mysql://...
   ```

3. 应用配置文件（profile-specific）
   - application-dev.properties
   - application-prod.properties

4. 应用配置文件（默认）
   - application.properties
   - application.yml

5. 类路径中的默认配置

## 💻 实践建议

### 基础实践
1. 创建简单的 Spring Boot 应用
2. 修改服务器端口和上下文路径
3. 学习配置文件的使用

### 进阶实践
1. 使用 @ConfigurationProperties 绑定配置
2. 不同环境的配置管理（dev, prod）
3. 自定义自动配置类

### 高级实践
1. 配置中心集成
2. 动态配置刷新
3. 配置加密

## 🔑 关键概念

### @SpringBootApplication
组合注解，包含：
- `@SpringBootConfiguration` - Spring Boot 配置标记
- `@EnableAutoConfiguration` - 启用自动配置
- `@ComponentScan` - 组件扫描

### 自动配置原理
1. Spring Boot 启动时扫描 classpath
2. 根据 `spring.factories` 配置加载自动配置类
3. 通过条件注解（@Conditional...）判断是否应用配置
4. 如果条件满足，自动创建 Bean

### 条件注解
- `@ConditionalOnClass` - 当类存在时
- `@ConditionalOnMissingClass` - 当类不存在时
- `@ConditionalOnProperty` - 当属性值满足条件时
- `@ConditionalOnBean` - 当 Bean 存在时
- `@ConditionalOnMissingBean` - 当 Bean 不存在时

## 📝 常见配置

### 数据库配置
```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/mydb
    username: root
    password: password
    driver-class-name: com.mysql.cj.jdbc.Driver
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
```

### 日志配置
```yaml
logging:
  level:
    root: INFO
    org.springframework.web: DEBUG
    com.myapp: DEBUG
  pattern:
    console: "%d{yyyy-MM-dd HH:mm:ss} [%thread] %-5level %logger{36} - %msg%n"
  file: logs/app.log
  file-max-size: 10MB
  file-max-history: 10
```

## 🚀 快速开始

```bash
# 进入本模块
cd 03-Spring-Boot-Basics

# 构建项目
mvn clean install

# 运行应用
mvn spring-boot:run

# 或
java -jar target/app.jar

# 使用不同的配置文件
mvn spring-boot:run -Dspring-boot.run.arguments="--spring.profiles.active=dev"
```

## 📚 推荐阅读

- [Spring Boot 官方文档](https://spring.io/projects/spring-boot)
- 《Spring Boot in Action》
- [Spring Boot Auto-Configuration](https://docs.spring.io/spring-boot/docs/current/reference/html/using.html#using.auto-configuration)

## ❓ 常见问题

Q: 如何禁用某个自动配置？
A: 使用 `@EnableAutoConfiguration(exclude = {...})` 或在配置文件中设置。

Q: 如何自定义配置属性？
A: 创建配置类使用 @ConfigurationProperties 绑定。

Q: 配置文件位置有哪些？
A: classpath:/, classpath:/config/, file:/, file:/config/

---

**掌握配置是使用 Spring Boot 的关键！** ⚙️