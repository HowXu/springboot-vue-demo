package cn.howxu.server.controller;

import cn.howxu.server.entity.Book;
import cn.howxu.server.entity.Tables;
import lombok.RequiredArgsConstructor;
import org.babyfish.jimmer.sql.JSqlClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**@author HowXu
 *
 * 控制器类 用来标定Book类的行为
 *
 * RestController 是 Spring MVC 框架中的一个关键注解，用于简化 RESTful Web 服务的开发。
 * RestController 是一个组合注解，它同时具备以下两个功能：
 * Controller：标识该类是一个 Spring MVC 控制器
 * ResponseBody：自动将方法返回值序列化为 HTTP 响应体（通常是 JSON/XML）
 * 核心特性
 * 1. RESTful 支持
 *     专门为构建 REST API 设计
 *     每个方法默认返回数据而非视图名称
 *     适合构建前后端分离的应用
 * 2. 自动内容协商
 *     根据请求的 Accept 头自动选择响应格式（JSON/XML等）
 *     默认使用 Jackson 库进行 JSON 序列化
 * 3. HTTP 方法映射
 *     与 @GetMapping, @PostMapping 等注解配合使用
 *     支持标准的 HTTP 方法（GET/POST/PUT/DELETE 等）
 *
 * RequiredArgsConstructor
 * 这个注解会自动生成一个包含所有 final 字段和带有 @NonNull 注解的非 final 字段的构造函数。
 */
@RestController
@RequiredArgsConstructor
public class BookController {
    private final JSqlClient sqlClient;

    // book这个路由地址在收到Get请求就会返回一次sql查询
    @GetMapping("/book")
    public List<Book> getBooks(){
        return sqlClient.createQuery(Tables.BOOK_TABLE).select(Tables.BOOK_TABLE).execute();
    }

    // 收到Post请求就会进行一次保存
    @PostMapping("/book")
    public void registeBook(@RequestBody Book book){
        // save已经过时 这个sql语句可以直接保存类到数据库里 非常的omz
        sqlClient.saveCommand(book);
    }
}
