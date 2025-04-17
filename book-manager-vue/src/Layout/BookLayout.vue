<!--
主页面布局 拿给你塞那两个Views的
-->
<script setup lang="ts">

</script>

<template>
    <!-- 这个布局要求就是 左边有个栏 右边页面展示 页面展示应该是动态的-->
    <!-- 这个是外壳 要求has sider-->
    <n-layout has-sider>
    <!-- 这里是设置sider-->
    <n-layout-sider content-style="padding: 8px;">
        <!-- 一个列表 有两个选项 其中绑定了路由 点了这个选项就会把下面RouterView 这个元素切换成对应View-->
        <ul>
            <li>
                <RouterLink to="/book">书籍列表</RouterLink>
            </li>
            <li>
                <RouterLink to="/save">存储书籍</RouterLink>
            </li>
        </ul>
    </n-layout-sider>
    <!-- 右侧的主布局 直接塞了RouterView 表示会根据当前链接的值来展示路由后的页面 -->
    <n-layout>
        <n-layout-content content-style="padding: 12px;">
            <!--
            <RouterView v-slot="{ Component }">
            作用：
            Vue Router 的 <RouterView> 组件通过作用域插槽暴露当前路由匹配到的组件。
            { Component }：
            (插槽就像是组件中的"占位符"，父组件可以向这个占位符中插入任何内容)
            这是从RouterView props 中解构出的属性，表示当前路由对应的 Vue 组件。(自己看实现)
            如果路由匹配成功 → Component 是对应的组件对象
            如果路由未匹配（如访问根路径 / 且无默认路由）→ Component 为 undefined
            2. <component :is="Component" v-if="Component" />
            动态组件：
            Vue 的 <component> 是一个内置组件，通过 :is 动态渲染组件。
            当 Component 存在时（路由匹配成功），is会渲染对应的路由组件 
            相当于 <BookList v-if="currentRoute === '/book'" />
            3. <div v-else>请从左侧菜单选择功能</div>
            兜底内容：
            当 Component 为 undefined（路由未匹配）时，显示提示信息。

            显然v-if对输入为undefined时会出false
            -->
            
            <RouterView v-slot="{ Component }">
                <component v-if="Component" :is="Component"  />
                <n-empty v-else description="请从左侧菜单选择功能" style="display: flex; justify-content: center; margin-top: 100px"/>
            </RouterView>
        </n-layout-content>
    </n-layout>

    </n-layout>
</template>