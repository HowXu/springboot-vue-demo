package cn.howxu.server.entity;

import org.babyfish.jimmer.sql.*;

import java.time.LocalDateTime;

/**@author HowXu
 *
 * 在 babyfish 的 Jimmer SQL 框架中，@entity 注解是用来标记一个类作为持久化实体（Entity）的核心注解。这个注解通常有以下含义和功能：
 * 基本作用
 *     标识持久化类：标记一个 Java/Kotlin 类为数据库中的表映射实体
 *     ORM 映射：框架会根据这个注解将类与数据库表关联起来
 * 常见属性
 * entity 注解通常包含以下可选属性：
 *     name: 指定数据库表名（如果不同于类名）
 *     table: 同 name，指定对应的数据库表名
 *     mappedSuperclass: 标识是否为映射超类（不单独对应表）
 *     schema: 指定数据库 schema
 *     catalog: 指定数据库 catalog
 *
 *     这里不用指定数据库 因为由Spring来控制
 */
@Entity
@Table(name = "books")
public interface Book {
    // 我的数据库里这个表的ID 是默认自增的 所以要在这里声明一下它的自动生成策略
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id();
    // 这三个值对应数据表中索引的三个名称 请务必带上字段注解 默认注解包给你刚炸烂
    @Column(name = "book_name")
    String name();
    @Column(name = "book_author")
    String author();
    @Column(name = "registe_time")
    LocalDateTime time();

}
