# 📚 Java Learning Hub

一个整合化的 Java 学习资源库，汇集了从基础框架到高级应用的完整学习路径。

## 📖 学习路线图

### 🎯 Level 1: Spring 框架基础
学习 Spring 框架的核心概念和原理

- **[01-Spring-Framework](./01-Spring-Framework/)** 
  - Spring IOC 容器原理
  - 依赖注入（DI）
  - Bean 生命周期
  - 自动装配
  - 注解配置
  - AOP 和事务处理
  - MyBatis 集成

### 🎯 Level 2: Spring MVC Web 开发
构建 web 应用的 MVC 框架

- **[02-Spring-MVC](./02-Spring-MVC/)**
  - Servlet 基础
  - Spring MVC 核心
  - 注解驱动开发
  - 请求处理

### 🎯 Level 3: Spring Boot 快速开发
现代 Spring 开发框架

- **[03-Spring-Boot-Basics](./03-Spring-Boot-Basics/)**
  - 自动配置
  - 配置文件优先级
  - 属性绑定

- **[04-Spring-Boot-Web](./04-Spring-Boot-Web/)**
  - Web 应用开发
  - MyBatis 数据持久化
  - Druid 连接池

### 🎯 Level 4: 数据持久化
ORM 框架和数据库操作

- **[05-MyBatis-Practice](./05-MyBatis-Practice/)**
  - MyBatis 基础
  - CRUD 操作
  - 一级/二级缓存
  - 分页查询

### 🎯 Level 5: 设计模式与高级特性
代码设计和架构模式

- **[06-Design-Patterns](./06-Design-Patterns/)**
  - 静态代理
  - 动态代理（JDK & Cglib）
  - Lombok 简化开发

### 🎯 Level 6: 数据结构与算法
计算机基础知识

- **[07-Data-Structures](./07-Data-Structures/)**
  - 常用数据结构实现
  - 算法分析

---

## 🚀 快速开始

### 克隆项目
```bash
git clone https://github.com/yelinlan/Java-Learning-Hub.git
cd Java-Learning-Hub
```

### 选择学习模块

每个模块都是独立的 Maven 项目，可以单独运行：

```bash
# 进入特定模块
cd 01-Spring-Framework

# 构建
mvn clean install

# 运行测试
mvn test
```

---

## 📚 各模块详细说明

### 01-Spring-Framework
**关键内容：**
- 手写 Spring 框架理解 IOC 容器
- Bean 的创建、初始化、销毁
- 依赖注入的三种方式
- AOP 切面编程
- 事务管理

**推荐学习顺序：**
1. spring01_ioc - 理解控制反转
2. spring02_ioc_impl - IOC 实现原理
3. spring03_bean_create - Bean 创建过程
4. spring04_di - 依赖注入
5. spring05_autowire - 自动装配
6. spring06_annotion_ioc - 注解驱动
7. spring07_appconfig - Java 配置
8. spring08_proxy - 代理模式（AOP 基础）
9. spring09_aop - 切面编程
10. spring10-mybatis - Spring 整合 MyBatis
11. spring11-transacion - 事务管理

### 02-Spring-MVC
**关键内容：**
- Servlet 基础概念
- Spring MVC 核心工作流程
- 注解驱动开发
- 请求处理和响应

**推荐学习顺序：**
1. springmvc01_servlet - Servlet 基础
2. springmvc02_hellomvc - 第一个 Spring MVC 应用
3. springmvc03-annotion - 注解驱动

### 03-Spring-Boot-Basics
**关键内容：**
- Spring Boot 自动配置原理
- 配置文件读取和优先级
- 属性绑定和验证

### 04-Spring-Boot-Web
**关键内容：**
- Web 应用开发
- 数据库集成（MyBatis）
- 连接池配置（Druid）
- 日志管理

### 05-MyBatis-Practice
**关键内容：**
- MyBatis 核心配置
- SQL 映射
- CRUD 操作
- 缓存机制
- 分页查询

### 06-Design-Patterns
**关键内容：**
- 代理模式
  - 静态代理
  - 动态代理（JDK Proxy）
  - CGLIB 代理
- 反射在代理中的应用
- Lombok 注解简化开发

### 07-Data-Structures
**关键内容：**
- 线性数据结构（数组、链表、栈、队列）
- 树型数据结构（二叉树、AVL树等）
- 哈希表
- 图论基础

---

## 💡 学习建议

### 学习方式
1. **理论学习** - 先理解每个概念的原理
2. **代码实践** - 通过编写代码加深理解
3. **项目应用** - 结合实际项目进行实践
4. **总结思考** - 写总结和心得体会

### 时间规划
- **初级阶段**（1-2 月）：完成 Level 1-2
- **中级阶段**（1 月）：完成 Level 3-4
- **高级阶段**（1 月）：完成 Level 5-6

### 常见问题
- Q: 我能跳过某些模块吗？
  - A: 不建议。最好按照顺序学习，因为后续模块可能依赖前面的知识。

- Q: 每个模块需要多长时间？
  - A: 取决于你的基础，一般 1-2 周一个模块。

- Q: 如何巩固所学知识？
  - A: 完成每个模块后，尝试修改代码进行实验，最好能复现整个过程。

---

## 🔗 原始仓库

本仓库是从以下仓库整合而来：
- [learnspring](https://github.com/yelinlan/learnspring)
- [learnspringmvc](https://github.com/yelinlan/learnspringmvc)
- [springbootbase](https://github.com/yelinlan/springbootbase)
- [springbootweb](https://github.com/yelinlan/springbootweb)
- [mybatispractice](https://github.com/yelinlan/mybatispractice)
- [proxy_practice](https://github.com/yelinlan/proxy_practice)
- [dataStructure](https://github.com/yelinlan/dataStructure)

---

## 📝 更新日志

### v1.0.0 (2025-06-13)
- ✅ 创建 Java Learning Hub
- ✅ 整合 7 个学习仓库
- ✅ 完善学习路线图和文档
- ✅ 添加详细的学习指南

---

## 🤝 贡献

欢迎提交 Issue 和 Pull Request 来改进这个学习资源库！

---

## 📄 许可证

MIT License

---

**祝你学习愉快！** 🎉