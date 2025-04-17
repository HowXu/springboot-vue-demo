import BookLayout from "@/Layout/BookLayout.vue";
import BookList from "@/Views/BookList.vue";
import SaveBook from "@/Views/SaveBook.vue";
import { createRouter, createWebHistory } from "vue-router";

const router = createRouter({
    history: createWebHistory(),// 设置历史为浏览器保存的历史
    routes: [ //可设置的路由是数组类型 
        {
            path: "", 
            // 表示访问后的默认页面就是在BookLayout上 这个BookLayout最开始是没有文字的 空白页
            // 不过我做了点更改 加个v-if让它可以有东西
            component: BookLayout,
            children: [
                /**
                 * 设置这个页面的下级页 
                 * 这里设置的组件会作为BookLayout设置的RouteView同步
                 */
                {
                    path: "/book",
                    component: BookList
                },
                {
                    path: "/save",
                    component: SaveBook
                }
            ]
        }
    ]
})

export default router; //路由导出