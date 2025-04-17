<script setup lang="ts">
import { type FormInst, NButton, NForm, NFormItem, NInput, useMessage } from 'naive-ui';
import { ref } from 'vue';

// 依然是一个book类 方便进行json格式化之类的
// id是自增的 time可以拿函数获取
// 带问号是一个可选属性 如果存在，它的值必须是 string 类型 如果不存在，它的值会是 undefined
interface BookInput{
    // 这里的名字要和后端函数名对接的
    name?:string;
    author?:string;
}
/**
 * useMessage允许你在 Vue 组件中方便地显示全局通知消息 这个用来提示
 */
const message = useMessage();

/**
 * 创建一个响应式的引用 这里对应一个表单。
    ref<T>(value)：定义一个响应式引用，类型为 T
    <FormInst | null>：这是 TypeScript 的类型标注，表示这个 ref 里面存的是：
    FormInst 类型的对象（一个表单实例），或者null
    初始值设为 null，表示一开始还没有绑定具体的表单组件。
 */
const formInput = ref<FormInst | null>(null)
const bookIn = ref<BookInput>({}) //interface的空为{}

function save(){
    // 获取值(这个值可以为undefined 这里加问号相当于if xxx 之后)
    // validate是表单验证 这个东西可以给一个期约 你可以拿着用then访问表单内容 就是它.value返回的不是可操作内容 validate就可以给你操作了
    formInput.value?.validate().then((ok)=>{
        // 期约到位了 或者说这个东西是正常的
        if(ok){
            // 访问后端Post接口 依然fetch
            fetch("http://localhost:8080/book",
                {
                    method:"POST",
                    headers:{
                        "Content-Type":"application/json",
                    },
                    // 这里把body设置为格式化的BookIn Json的字符串
                    // 注意你的数据库的time字段应该是自动填充now的 不然你应该拷贝一个BookIn然后设置它的时间戳
                    body: JSON.stringify(bookIn.value)
                }
            ).then(
                _ => {
                    // 成功了发个信息
                    message.success("Save book successfully")
                }
            )
        }else{
            message.error("Fill the form in a right way plz")
        }
    })
}

</script>

<template>
    <!--
    ref="formInput" 给这个表单组件注册了一个引用标识，可以在 JavaScript 中通过 this.$refs.formInput 来访问这个表单实例
    :model="bookIn" 是 v-bind:model 的简写，将表单数据模型绑定到 bookIn 这个变量上
    -->
    <NForm ref="formInput" :model="bookIn">
        <!--接下来添加表单的两个选项-->
        <!--
        label="书名/标题"
        显示在表单项前的标签文本
        path="name"
        指定该表单项关联的数据字段名（对应 form 的 model 中的 name 属性） 这个表单被收集上去的时候会被定为name(特别为了validate这个期约的时候用) 
        同时也双向绑定了bookIn的name 让它不一定是在validate的期约里你才能访问的到
        :rule（核心验证规则）
        接收一个数组形式的验证规则
        -->
        <NFormItem label="书名/标题" path="name" :rule="[{required: true, message: '请输入书名'}]">
            <NInput v-model:value="bookIn.name"/>
        </NFormItem>

        <NFormItem label="作者" path="author" :rule="[{required: true, message: '请输入作者名称'}]">
            <NInput v-model:value="bookIn.author"/>
        </NFormItem>
        
        <!--
        @click = v-on:click 是监听事件
        -->
        <NButton type="primary" @click="save">提交</NButton>
    </NForm>
</template>