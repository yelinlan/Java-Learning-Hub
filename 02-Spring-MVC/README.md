# Spring MVC 学习模块

## 📚 概述

本模块介绍 Spring MVC 框架，它是 Spring 家族中用于构建 Web 应用的核心框架。你将学习如何使用 Spring MVC 构建高效、灵活的 Web 应用程序。

## 🎯 学习目标

- [ ] 理解 Servlet 基础
- [ ] 掌握 Spring MVC 的 DispatcherServlet 工作流程
- [ ] 学习控制器的编写和请求映射
- [ ] 理解模型和视图的分离
- [ ] 掌握注解驱动的开发方式
- [ ] 学习参数绑定和数据验证

## 📖 学习路径

### 1. Servlet 基础 (springmvc01_servlet)

**核心概念：**
- HTTP 请求和响应
- Servlet 生命周期
- 请求分发
- 会话管理

**关键知识点：**
- init() - 初始化
- service() / doGet() / doPost() - 请求处理
- destroy() - 销毁

### 2. Spring MVC 核心 (springmvc02_hellomvc)

**核心概念：**
- DispatcherServlet 的作用
- 请求处理流程
- 控制器的编写
- 模型和视图分离

**工作流程：**
```
1. 请求到达 DispatcherServlet
   ↓
2. HandlerMapping 找到对应的 Handler
   ↓
3. HandlerAdapter 执行 Handler
   ↓
4. Controller 处理业务逻辑
   ↓
5. 返回 ModelAndView
   ↓
6. ViewResolver 解析视图
   ↓
7. 渲染视图返回响应
```

### 3. 注解驱动开发 (springmvc03-annotion)

**核心注解：**
- `@Controller` - 标记控制器
- `@RequestMapping` - 请求映射
- `@GetMapping` / `@PostMapping` - HTTP 方法映射
- `@PathVariable` - 路径变量
- `@RequestParam` - 请求参数
- `@RequestBody` - 请求体
- `@ResponseBody` - 响应体
- `@RestController` - 返回 JSON 的控制器

## 💻 实践建议

### 基础阶段
1. 理解 Servlet 的请求-响应模型
2. 编写简单的 Servlet 程序
3. 学习 JSP 基础

### 进阶阶段
1. 理解 Spring MVC 的请求流程
2. 编写简单的控制器
3. 学习 Thymeleaf 或 JSP 视图

### 高级阶段
1. 前后端分离（返回 JSON）
2. 请求参数验证
3. 文件上传下载
4. RESTful API 设计

## 🔑 关键概念

### DispatcherServlet 的作用
- 中央分发器
- 管理整个请求处理流程
- 协调各个组件的工作

### 九大组件
1. MultipartResolver - 文件上传解析
2. LocaleResolver - 国际化
3. ThemeResolver - 主题解析
4. HandlerMapping - 请求映射
5. HandlerAdapter - 处理器适配
6. HandlerExceptionResolver - 异常处理
7. RequestToViewNameTranslator - 视图名翻译
8. ViewResolver - 视图解析
9. FlashMapManager - Flash 属性管理

## 📝 常用配置

### web.xml 配置
```xml
<servlet>
    <servlet-name>dispatcherServlet</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    <init-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>classpath:springmvc.xml</param-value>
    </init-param>
</servlet>
<servlet-mapping>
    <servlet-name>dispatcherServlet</servlet-name>
    <url-pattern>/</url-pattern>
</servlet-mapping>
```

### 简单的控制器
```java
@Controller
@RequestMapping("/user")
public class UserController {
    
    @GetMapping("/{id}")
    public String getUser(@PathVariable Integer id, Model model) {
        // 业务逻辑
        model.addAttribute("user", user);
        return "user/detail";  // 返回视图名
    }
    
    @PostMapping
    @ResponseBody
    public User saveUser(@RequestBody User user) {
        // 业务逻辑
        return user;
    }
}
```

## 🚀 快速开始

```bash
# 进入本模块
cd 02-Spring-MVC

# 构建项目
mvn clean install

# 在 IDE 中运行或部署到 Tomcat
# 访问 http://localhost:8080/project-name
```

## 🌐 从 Spring MVC 到前后端分离

### 传统 Spring MVC
- 后端生成 HTML
- 前后端耦合
- 前端技术受限

### 现代前后端分离
- 后端提供 API（JSON）
- 前端独立开发
- 更灵活的技术选择

## 📚 推荐阅读

- 《Spring MVC 学习指南》
- [Spring MVC 官方文档](https://spring.io/projects/spring-framework)
- 《RESTful Web Services》

## ❓ 常见问题

Q: Spring MVC 和 Spring Boot 的区别？
A: Spring Boot 是 Spring 的快速开发框架，它简化了配置，Spring MVC 是其中的一个模块。

Q: 如何实现国际化？
A: 使用 LocaleResolver 和配置国际化资源文件。

Q: 如何处理异常？
A: 使用 @ExceptionHandler、@ControllerAdvice 或 HandlerExceptionResolver。

---

**继续学习 Spring Boot 来简化开发吧！** 🚀