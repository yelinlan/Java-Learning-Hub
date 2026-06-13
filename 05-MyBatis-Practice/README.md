# MyBatis 实践学习模块

## 📚 概述

MyBatis 是一个流行的 ORM（对象关系映射）框架，它通过 SQL 映射简化了数据库操作。本模块通过实践，帮助你深入掌握 MyBatis 的各项技能。

## 🎯 学习目标

- [ ] 理解 MyBatis 的核心概念
- [ ] 掌握 SQL 映射配置
- [ ] 学习 CRUD 操作
- [ ] 理解缓存机制（一级、二级）
- [ ] 掌握分页查询
- [ ] 学习动态 SQL

## 📖 学习内容

### 1. MyBatis 基础概念

**什么是 MyBatis？**
- 半自动的 ORM 框架
- SQL 由开发者编写，具有灵活性
- 通过 XML 或注解配置 SQL 映射
- 自动将 ResultSet 映射为 Java 对象

**MyBatis vs Hibernate vs JPA**

| 特性 | MyBatis | Hibernate | JPA |
|------|---------|-----------|-----|
| SQL 编写 | 手写 | 自动生成 | 自动生成 |
| 灵活性 | 高 | 中 | 中 |
| 学习曲线 | 平缓 | 陡峭 | 陡峭 |
| 适用场景 | 复杂查询 | 简单业务 | 复杂业务 |
| 性能 | 高 | 中 | 中 |

### 2. MyBatis 配置

**mybatis-config.xml 示例：**
```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
 "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <!-- 环境配置 -->
    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <property name="driver" value="com.mysql.cj.jdbc.Driver"/>
                <property name="url" value="jdbc:mysql://localhost:3306/mydb"/>
                <property name="username" value="root"/>
                <property name="password" value="password"/>
            </dataSource>
        </environment>
    </environments>
    
    <!-- 映射文件 -->
    <mappers>
        <mapper resource="com/example/mapper/UserMapper.xml"/>
    </mappers>
</configuration>
```

### 3. SQL 映射

**Mapper XML 示例：**
```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
 "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.example.mapper.UserMapper">
    
    <!-- 结果集映射 -->
    <resultMap id="userResultMap" type="User">
        <id property="id" column="id"/>
        <result property="name" column="name"/>
        <result property="email" column="email"/>
    </resultMap>
    
    <!-- 查询单个对象 -->
    <select id="selectById" parameterType="long" resultMap="userResultMap">
        SELECT id, name, email FROM user WHERE id = #{id}
    </select>
    
    <!-- 查询列表 -->
    <select id="selectAll" resultMap="userResultMap">
        SELECT id, name, email FROM user
    </select>
    
    <!-- 插入 -->
    <insert id="insert" parameterType="User" useGeneratedKeys="true" keyProperty="id">
        INSERT INTO user(name, email) VALUES(#{name}, #{email})
    </insert>
    
    <!-- 更新 -->
    <update id="update" parameterType="User">
        UPDATE user SET name = #{name}, email = #{email} WHERE id = #{id}
    </update>
    
    <!-- 删除 -->
    <delete id="deleteById" parameterType="long">
        DELETE FROM user WHERE id = #{id}
    </delete>
</mapper>
```

### 4. 动态 SQL

**if 标签**
```xml
<select id="selectByCondition">
    SELECT * FROM user WHERE 1=1
    <if test="name != null">
        AND name LIKE #{name}
    </if>
    <if test="email != null">
        AND email = #{email}
    </if>
</select>
```

**choose 标签**
```xml
<select id="selectByType">
    SELECT * FROM user
    <choose>
        <when test="type == 'id'">
            WHERE id = #{value}
        </when>
        <when test="type == 'name'">
            WHERE name = #{value}
        </when>
        <otherwise>
            WHERE email = #{value}
        </otherwise>
    </choose>
</select>
```

**foreach 标签**
```xml
<select id="selectByIds">
    SELECT * FROM user WHERE id IN
    <foreach collection="ids" item="id" open="(" close=")" separator=",">
        #{id}
    </foreach>
</select>
```

### 5. 缓存机制

**一级缓存（Session 级别）**
- 默认启用
- 同一个 SqlSession 中有效
- 离开 SqlSession 失效

**二级缓存（Mapper 级别）**
```xml
<!-- 在 Mapper XML 中启用二级缓存 -->
<cache/>

<!-- 或配置缓存策略 -->
<cache type="org.mybatis.caches.redis.RedisCache"/>
```

### 6. 分页查询

**方式一：使用 LIMIT**
```xml
<select id="selectPage">
    SELECT * FROM user LIMIT #{offset}, #{pageSize}
</select>
```

**方式二：使用 PageHelper（推荐）**
```java
// 在查询前设置分页参数
PageHelper.startPage(pageNum, pageSize);
List<User> users = userMapper.selectAll();
PageInfo<User> pageInfo = new PageInfo<>(users);
```

## 💻 实践建议

### 基础阶段
1. 理解 MyBatis 的配置文件
2. 编写简单的 CRUD SQL 映射
3. 学习参数绑定和结果映射

### 进阶阶段
1. 学习动态 SQL
2. 使用一级、二级缓存
3. 实现分页查询

### 高级阶段
1. 与 Spring 集成
2. 性能优化
3. 处理复杂的关联关系

## 📝 常见问题

Q: #{} 和 ${} 的区别？
A: #{} 使用预处理语句（安全），${} 直接拼接（有 SQL 注入风险）。

Q: 何时使用一级、二级缓存？
A: 一级缓存自动使用；二级缓存用于不经常改变的数据。

Q: 如何处理复杂的 SQL 查询？
A: 使用动态 SQL 或直接编写 SQL 语句。

## 🚀 快速开始

```bash
# 进入本模块
cd 05-MyBatis-Practice

# 构建项目
mvn clean install

# 运行测试
mvn test
```

## 📚 推荐阅读

- [MyBatis 官方文档](https://mybatis.org/mybatis-3/)
- [MyBatis 中文文档](https://mybatis.cn/)
- 《MyBatis 从入门到精通》

---

**掌握 MyBatis，驾驭复杂数据库查询！** 🎯