plugins {
    java
    id("org.springframework.boot") version "3.4.4"
    id("io.spring.dependency-management") version "1.1.7"
    // 下面这个插件可以自动生成SQL对象的Tables 非常方便
    id("cn.enaium.jimmer.gradle") version "0.0.29"
}

group = "cn.howxu"
version = "0.0.1"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    compileOnly("org.projectlombok:lombok")
    runtimeOnly("com.mysql:mysql-connector-j")
    annotationProcessor("org.projectlombok:lombok")

    // sql查询结果直接转换为类
    implementation("org.babyfish.jimmer:jimmer-sql:0.9.73")
}
