# Spring Boot Web 应用开发模块

## 📚 概述

本模块介绍如何使用 Spring Boot 开发完整的 Web 应用，包括数据库集成、ORM 框架、连接池配置等内容。

## 🎯 学习目标

- [ ] 掌握 Spring Boot Web 应用开发
- [ ] 学习 MyBatis ORM 框架
- [ ] 理解数据库连接池（Druid）
- [ ] 掌握数据访问层的设计
- [ ] 学习日志管理

## 📖 学习内容

### 1. Spring Boot Web 应用

**核心依赖：**
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

**Web 开发要点：**
- RESTful API 开发
- 请求处理（@GetMapping, @PostMapping 等）
- 响应格式（JSON）
- 异常处理
- 参数验证

### 2. 数据库集成

**支持的数据库：**
- MySQL
- PostgreSQL
- H2（内存数据库）
- Oracle
- SQL Server

**JDBC 配置示例：**
```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/mydb
    username: root
    password: password
    driver-class-name: com.mysql.cj.jdbc.Driver
```

### 3. MyBatis 框架

**什么是 MyBatis？**
- 开源的 ORM 框架
- 半自动化映射
- SQL 由开发者编写
- 灵活且高效

**核心注解：**
- `@Select` - SELECT 查询
- `@Insert` - INSERT 插入
- `@Update` - UPDATE 更新
- `@Delete` - DELETE 删除
- `@Param` - 参数名绑定
- `@Results` - 结果集映射

**Mapper 接口示例：**
```java
@Mapper
public interface UserMapper {
    
    @Select("SELECT * FROM user WHERE id = #{id}")
    User selectById(Long id);
    
    @Insert("INSERT INTO user(name, email) VALUES(#{name}, #{email})")
    int insert(User user);
    
    @Update("UPDATE user SET name=#{name} WHERE id=#{id}")
    int update(User user);
    
    @Delete("DELETE FROM user WHERE id=#{id}")
    int deleteById(Long id);
}
```

### 4. 数据库连接池（Druid）

**为什么需要连接池？**
- 提高数据库访问性能
- 减少连接创建开销
- 管理连接生命周期

**Druid 特点：**
- 高性能
- 提供监控功能
- 支持 SQL 防火墙
- 集成 Spring Boot

**配置示例：**
```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/mydb
    username: root
    password: password
    driver-class-name: com.mysql.cj.jdbc.Driver
    # Druid 连接池配置
    type: com.alibaba.druid.pool.DruidDataSource
    druid:
      initial-size: 5
      max-active: 20
      max-idle: 15
      min-idle: 5
      max-wait: 60000
      validation-query: SELECT 1
      test-on-borrow: false
      test-on-return: false
      test-while-idle: true
      time-between-eviction-runs-millis: 60000
      min-evictable-idle-time-millis: 300000
```

### 5. 分层架构设计

```
┌─────────────────────────────────┐
│      Controller 层              │  HTTP 请求处理
└──────────────┬──────────────────┘
               │
┌──────────────▼──────────────────┐
│      Service 层                 │  业务逻辑处理
└──────────────┬──────────────────┘
               │
┌──────────────▼──────────────────┐
│      Mapper/Repository 层       │  数据访问
└──────────────┬──────────────────┘
               │
┌──────────────▼──────────────────┐
│      Database                   │  数据库
└─────────────────────────────────┘
```

**各层职责：**
- **Controller** - 接收请求，调用 Service
- **Service** - 业务逻辑处理，事务管理
- **Mapper** - 数据库操作，SQL 执行

### 6. 日志管理

**Spring Boot 默认日志框架：Logback**

**配置示例：**
```yaml
logging:
  level:
    root: INFO
    org.springframework: INFO
    org.springframework.web: DEBUG
    com.myapp: DEBUG
  pattern:
    console: "%d{yyyy-MM-dd HH:mm:ss} [%thread] %-5level %logger{36} - %msg%n"
  file: logs/app.log
```

**常用日志级别：**
- TRACE - 最详细
- DEBUG - 调试信息
- INFO - 一般信息
- WARN - 警告信息
- ERROR - 错误信息

## 💻 完整示例

### 1. 创建 User 实体类
```java
public class User {
    private Long id;
    private String name;
    private String email;
    
    // Getter and Setter
}
```

### 2. 创建 Mapper 接口
```java
@Mapper
public interface UserMapper {
    User selectById(Long id);
    List<User> selectAll();
    int insert(User user);
    int update(User user);
    int deleteById(Long id);
}
```

### 3. 创建 Service 类
```java
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    
    public User getUserById(Long id) {
        return userMapper.selectById(id);
    }
    
    @Transactional
    public void saveUser(User user) {
        userMapper.insert(user);
    }
}
```

### 4. 创建 Controller 类
```java
@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;
    
    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }
    
    @PostMapping
    public void createUser(@RequestBody User user) {
        userService.saveUser(user);
    }
}
```

## 🚀 快速开始

```bash
# 进入本模块
cd 04-Spring-Boot-Web

# 构建项目
mvn clean install

# 运行应用
mvn spring-boot:run

# 测试 API
curl http://localhost:8080/api/users/1
```

## 📚 推荐阅读

- [Spring Boot Data Access](https://spring.io/projects/spring-data)
- [MyBatis 官方文档](https://mybatis.org/mybatis-3/)
- [Druid 文档](https://github.com/alibaba/druid)

## ❓ 常见问题

Q: MyBatis 和 JPA 有什么区别？
A: MyBatis 是半自动 ORM，SQL 需要手写；JPA 是全自动 ORM，由框架生成 SQL。

Q: 何时使用事务？
A: 涉及多个数据库操作、需要保证数据一致性时使用事务。

Q: 如何优化数据库查询？
A: 使用连接池、合理设计索引、避免 N+1 查询问题。

---

**掌握 Web 应用开发的核心技能！** 🚀