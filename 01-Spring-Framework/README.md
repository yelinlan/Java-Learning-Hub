# Spring Framework 学习模块

## 📚 概述

这个模块通过系统的学习和实践，帮助你深入理解 Spring 框架的核心原理。从 IOC 容器到 AOP 切面编程，再到事务管理，你将掌握 Spring 的精髓。

## 🎯 学习目标

- [ ] 理解 IOC（Inversion of Control）容器的概念
- [ ] 掌握 Bean 的生命周期
- [ ] 学习三种依赖注入方式
- [ ] 实现自动装配
- [ ] 理解 AOP 切面编程
- [ ] 掌握事务管理
- [ ] 学习 Spring 与 MyBatis 的集成

## 📖 学习路径

### 1. Spring IOC 基础 (spring01_ioc -> spring07_appconfig)

**核心概念：**
- 控制反转（IOC）原理
- 依赖注入（DI）三种方式：构造器注入、Setter 注入、接口注入
- Bean 的作用域：singleton、prototype 等
- 属性文件和 Java 配置

**学习代码位置：**
```
spring01_ioc/              # 理解 IOC
spring02_ioc_impl/         # IOC 实现原理
spring03_bean_create/      # Bean 创建
spring04_di/               # 依赖注入
spring05_autowire/         # 自动装配
spring06_annotion_ioc/     # 注解驱动 IOC
spring07_appconfig/        # Java 配置方式
```

### 2. AOP 与代理 (spring08_proxy -> spring09_aop)

**核心概念：**
- 代理模式：静态代理、动态代理
- AOP 术语：Joinpoint、Pointcut、Advice、Aspect
- 织入方式：编译期、类加载期、运行期

**学习代码位置：**
```
spring08_proxy/            # 代理模式基础
spring09_aop/              # Spring AOP
```

### 3. 整合与事务 (spring10-mybatis -> spring11-transacion)

**核心概念：**
- Spring 与 MyBatis 集成
- 事务的特性（ACID）
- 事务的隔离级别
- Spring 事务管理

**学习代码位置：**
```
spring10-mybatis/          # Spring 整合 MyBatis
spring11-transacion/       # 事务管理
```

## 💻 实践建议

### 第一阶段：理论学习
1. 阅读每个模块的代码注释
2. 理解类的设计和关系
3. 尝试画出架构图

### 第二阶段：代码实践
1. 修改配置文件进行实验
2. 编写自己的 Bean 类
3. 尝试不同的注入方式

### 第三阶段：深度学习
1. 阅读 Spring 源码
2. 理解框架的设计模式
3. 性能优化和最佳实践

## 🔑 关键点总结

### IOC 容器的作用
- 创建对象（工厂模式）
- 管理对象的生命周期
- 处理对象之间的依赖关系

### Bean 的生命周期
1. 实例化（Instantiate）
2. 属性赋值（Populate Properties）
3. BeanName 和 BeanFactory 的感知（Aware）
4. 前置处理（Pre-initialization）
5. 初始化（Initialize）
6. 后置处理（Post-initialization）
7. 注册到容器
8. 使用
9. 销毁（Destroy）

### 依赖注入方式

| 方式 | 优点 | 缺点 |
|------|------|------|
| 构造器注入 | 依赖清晰 | 参数多时不便 |
| Setter 注入 | 灵活，可选 | 不够直观 |
| 接口注入 | 独立接口 | 侵入性强 |
| 注解注入 | 简洁，推荐 | 需要配置 |

## 🚀 快速开始

```bash
# 进入本模块
cd 01-Spring-Framework

# 构建项目
mvn clean install

# 运行测试
mvn test

# 或在 IDE 中直接运行各模块下的 main 方法
```

## 📚 推荐阅读

- 《Spring in Action》
- 《Spring 源码深度解析》
- [Spring 官方文档](https://spring.io/projects/spring-framework)

## ❓ 常见问题

Q: Spring 为什么要有 IOC？
A: IOC 将对象的创建和管理权交给框架，降低代码耦合度，提高代码的可维护性和可测试性。

Q: 什么情况下用 AOP？
A: 日志记录、性能监控、事务管理、权限控制等横切关注点。

Q: 如何选择依赖注入方式？
A: 优先使用注解注入（@Autowired、@Resource），其次是构造器注入，避免 Setter 注入。

---

**开始学习吧！** 💪