<!-- 这个页面是展示数据库查询结果的页面 -->
<script setup lang="ts">
//这里 import type 表明不会打包运行时代码 仅作为类型检查使用
import { NDataTable, type DataTableColumns } from "naive-ui";
import { ref } from "vue";
// 先是一个接口 用来承接作为Book类
interface Book {
  id: number;
  name: string;
  author: string;
  time: string;
}

// 然后是动态渲染展现的数据表的组件
/**
 * 
 *  在 Naive UI 中，DataTableColumns 是用于配置 DataTable（数据表格） 的列定义，它决定了表格的列如何渲染、排序、筛选等。
    Naive UI 的 DataTable 组件通过 columns 属性接收列配置，每个列（DataTableColumn）可以定义：
    列标题（title）
    数据字段（key）
    自定义渲染（render）
 * 
 */
const columns: DataTableColumns<Book> = [
  // 这个上下对应应该很明显了 这里也是要对应后端函数命名的
  {
    title: "ID",
    key: "id",
  },
  {
    title: "Title",
    key: "name",
  },
  {
    title: "Author",
    key: "author",
  },
  {
    title: "Registe Time",
    key: "time",
  },
];

// 然后创建一个ref对象
/**
 * ref 是一个函数，用于创建响应式的基本类型数据引用
 * 可以包装任何值类型（基本类型或对象）
 * 通过 .value 访问和修改值
 * 也用于获取 DOM 元素或组件实例的引用
 * 
 *  ref: Vue 3 Composition API 的核心函数，用于创建响应式引用
    <Book[]>: TypeScript 泛型参数，指定这个 ref 存储的是 Book 类型的数组
    ([]): 初始值，这里是一个空数组
 */

const books = ref<Book[]>([]);

// 然后进行fetch
/**
 *  fetch("http://localhost:8080/book")
        向 http://localhost:8080/book 发送 GET 请求
        返回一个 Promise，代表异步操作
    .then((response) => response.json())
        第一个 then 处理服务器的响应
        response.json() 将响应体解析为 JSON 格式
        返回一个新的 Promise，包含解析后的 JavaScript 对象 再接一个then就变成data了
    .then((data: Book[]) => (books.value = data))
        第二个 then 接收解析后的数据 这里Json数据被解析为Book的数组 这是为了符合ts的类型检查
        将数据赋值给 Vue 的响应式变量 books.value
        由于 books 是用 ref 创建的，必须通过 .value 修改其值
    fetch默认get post要改 后面会用到的
 * 
  js系列的话 lambda表达式要有返回值的
 */
fetch("http://localhost:8080/book")
  .then((response) => response.json())
  .then((data: Book[]) => (books.value = data));
</script>

<template>
    <!--
    <NDataTable>：Naive UI 提供的数据表格组件，用于展示结构化数据。
    :columns="columns"：绑定表格的列配置（定义表头、数据映射、排序、筛选等）。
    :data="books"：绑定要展示的数据（通常是一个数组，每行数据对应一个对象）。

    这个:类似于v-model操作
    -->
    <NDataTable :columns="columns" :data="books" />
</template>
