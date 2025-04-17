import { createApp } from "vue";
import App from "./App.vue";
import router from "./Router";

// 这里创建app代表这个Vue前端实例 创建的组件是App
const app = createApp(App)
// 挂载在id为app的DOM元素上 这个元素表现为一个div 现在这个div就嵌入了App.vue的那个h1标签
app.use(router)
app.mount("#app")