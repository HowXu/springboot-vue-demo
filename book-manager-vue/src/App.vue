
<!-- 主界面 -->

<script setup lang="ts">
import { NMessageProvider } from 'naive-ui';


</script>

<template>
    <!-- 因为使用了NMessage类 所以要NMessageProvider先决 RouteView让main.ts的app来进行App.vue这个主页面的管理-->
    <NMessageProvider>
        <RouterView />
    </NMessageProvider>
</template>
