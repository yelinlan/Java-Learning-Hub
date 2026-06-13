# 设计模式与高级特性学习模块

## 📚 概述

设计模式是解决常见问题的可重用解决方案。本模块重点介绍代理模式（Proxy Pattern），这是 Spring AOP 的基础，同时学习 Lombok 工具简化开发。

## 🎯 学习目标

- [ ] 理解代理模式的概念
- [ ] 掌握静态代理的实现
- [ ] 学习 JDK 动态代理
- [ ] 理解 CGLIB 动态代理
- [ ] 使用 Lombok 简化代码
- [ ] 理解 Spring AOP 的基础

## 📖 学习内容

### 1. 代理模式简介

**什么是代理模式？**
- 创建型设计模式
- 为对象提供代理，以控制对该对象的访问
- 在原对象和客户端之间增加一层中间层

**使用场景：**
- 权限控制
- 日志记录
- 性能监控
- 事务管理
- 缓存

**代理模式结构：**
```
┌─────────────┐
│   Client    │
└──────┬──────┘
       │
       │ 使用
       │
┌──────▼──────────────┐
│  Proxy (代理对象)   │  
└──────┬──────────────┘
       │
       │ 委托
       │
┌──────▼──────────────┐
│ Subject (真实对象)  │
└─────────────────────┘
```

### 2. 静态代理

**原理：**
- 代理类在编译时就已经确定
- 代理类和真实类实现同一个接口

**示例：**
```java
// 公共接口
public interface UserService {
    void add(User user);
    void delete(Long id);
}

// 真实类
public class UserServiceImpl implements UserService {
    @Override
    public void add(User user) {
        System.out.println("添加用户");
    }
    
    @Override
    public void delete(Long id) {
        System.out.println("删除用户");
    }
}

// 代理类
public class UserServiceProxy implements UserService {
    private UserService userService;
    
    public UserServiceProxy(UserService userService) {
        this.userService = userService;
    }
    
    @Override
    public void add(User user) {
        System.out.println("权限检查");
        System.out.println("记录日志");
        userService.add(user);  // 委托真实对象处理
        System.out.println("提交事务");
    }
    
    @Override
    public void delete(Long id) {
        System.out.println("权限检查");
        userService.delete(id);
    }
}

// 使用
UserService userService = new UserServiceProxy(new UserServiceImpl());
userService.add(new User());
```

**静态代理的缺点：**
- 代理类数量多
- 代码重复
- 难以维护

### 3. JDK 动态代理

**原理：**
- 在运行时动态生成代理类
- 使用反射机制
- 必须实现接口

**核心类：**
- `Proxy` - 生成代理对象
- `InvocationHandler` - 处理器接口

**示例：**
```java
// 创建 InvocationHandler
public class UserServiceHandler implements InvocationHandler {
    private UserService userService;
    
    public UserServiceHandler(UserService userService) {
        this.userService = userService;
    }
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 前置通知
        System.out.println("权限检查");
        System.out.println("记录日志 - 方法名：" + method.getName());
        
        // 调用真实对象
        Object result = method.invoke(userService, args);
        
        // 后置通知
        System.out.println("提交事务");
        
        return result;
    }
}

// 生成代理对象
UserService userService = new UserServiceImpl();
UserServiceHandler handler = new UserServiceHandler(userService);
UserService proxy = (UserService) Proxy.newProxyInstance(
    UserService.class.getClassLoader(),
    new Class[]{UserService.class},
    handler
);

// 使用代理对象
proxy.add(new User());
```

**JDK 动态代理的限制：**
- 只能代理实现接口的类
- 不能代理没有接口的类

### 4. CGLIB 动态代理

**原理：**
- 字节码生成库
- 生成目标类的子类作为代理类
- 不需要实现接口
- 通过继承实现代理

**依赖：**
```xml
<dependency>
    <groupId>cglib</groupId>
    <artifactId>cglib</artifactId>
    <version>3.3.0</version>
</dependency>
```

**示例：**
```java
// 目标类（不需要实现接口）
public class UserService {
    public void add(User user) {
        System.out.println("添加用户");
    }
}

// 创建 MethodInterceptor
public class UserServiceInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        // 前置通知
        System.out.println("权限检查");
        System.out.println("记录日志 - 方法名：" + method.getName());
        
        // 调用真实方法
        Object result = proxy.invokeSuper(obj, args);
        
        // 后置通知
        System.out.println("提交事务");
        
        return result;
    }
}

// 生成代理对象
Enhancer enhancer = new Enhancer();
enhancer.setSuperclass(UserService.class);
enhancer.setCallback(new UserServiceInterceptor());
UserService proxy = (UserService) enhancer.create();

// 使用代理对象
proxy.add(new User());
```

### 5. 对比总结

| 特性 | 静态代理 | JDK 动态代理 | CGLIB |
|------|--------|-----------|-------|
| 编译时机 | 编译时 | 运行时 | 运行时 |
| 是否需要接口 | 是 | 是 | 否 |
| 性能 | 高 | 中 | 高 |
| 使用难度 | 简单 | 中等 | 中等 |
| Spring AOP 默认 | - | 优先 | 备选 |

### 6. Lombok 简化开发

**常用注解：**

- `@Data` - 生成 getter、setter、toString、equals、hashCode
- `@Getter` / `@Setter` - 生成 getter/setter
- `@NoArgsConstructor` - 生成无参构造函数
- `@AllArgsConstructor` - 生成全参构造函数
- `@RequiredArgsConstructor` - 生成必需参数的构造函数
- `@ToString` - 生成 toString 方法
- `@EqualsAndHashCode` - 生成 equals 和 hashCode
- `@Slf4j` / `@Log4j` - 生成 logger
- `@Builder` - 生成 Builder 模式

**示例：**
```java
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;
    private String name;
    private String email;
}

// 等价于传统代码中包含 getter、setter、toString、equals、hashCode 等
```

## 💻 实践建议

### 基础阶段
1. 理解代理模式的概念
2. 编写静态代理代码
3. 学习 Lombok 基本注解

### 进阶阶段
1. 实现 JDK 动态代理
2. 实现 CGLIB 动态代理
3. 对比三种代理方式

### 高级阶段
1. 理解 Spring AOP 的实现原理
2. 自定义 AOP 切面
3. 性能优化和最佳实践

## 🚀 快速开始

```bash
# 进入本模块
cd 06-Design-Patterns

# 构建项目
mvn clean install

# 运行测试
mvn test
```

## 📚 推荐阅读

- 《Design Patterns: Elements of Reusable Object-Oriented Software》
- 《Head First Design Patterns》
- [Lombok 官方文档](https://projectlombok.org/)
- [CGLIB 文档](https://github.com/cglib/cglib)

## ❓ 常见问题

Q: Spring AOP 默认使用哪种代理？
A: 优先使用 JDK 动态代理，如果目标类没有接口，则使用 CGLIB。

Q: 性能上哪种代理最好？
A: 静态代理性能最高，但代码冗长；CGLIB 动态代理性能也很好。

Q: Lombok 是否有缺点？
A: Lombok 使用注解处理，可能与某些框架不兼容；另外 IDE 支持差异大。

---

**掌握设计模式，提升代码质量！** 🎨