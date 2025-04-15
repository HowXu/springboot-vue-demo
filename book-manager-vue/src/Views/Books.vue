<!-- 这个页面是展示数据库查询结果的页面 -->
<script setup lang="ts">
//这里 import type 表明不会打包运行时代码 仅作为类型检查使用
import type { DataTableColumns } from "naive-ui"
// 先是一个接口 用来承接Book类
interface Book{
    id: number
    name: string
    author: string
    registe_time: string
}

// 然后是动态渲染展现的数据表的组件
const columns: DataTableColumns<Book> = [
    
]
</script>

<template>

</template>