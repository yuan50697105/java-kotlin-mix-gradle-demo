import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("java")
//    id("groovy")
//    id("scala")
    id("org.springframework.boot") version "2.7.4"
    id("io.spring.dependency-management") version "1.0.14.RELEASE"
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.spring") version "1.6.21"
    kotlin("plugin.jpa") version "1.6.21"
    kotlin("kapt") version "1.6.21"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
//	mavenCentral()
    maven("https://maven.aliyun.com/repository/public/")
    mavenCentral()

}

extra["springBootAdminVersion"] = "2.7.4"
extra["springCloudVersion"] = "2021.0.4"

dependencies {
//    implementation("org.scala-lang:scala-library:2.13.8")
//    implementation("org.scala-lang:scala-compiler:2.13.8")
//    implementation("org.scala-lang:scala-reflect:2.13.8")
//    implementation(gradleApi())
//    implementation(localGroovy())
//    implementation("org.codehaus.groovy:groovy-all:3.0.12")
    implementation("com.fhs-opensource:easy-trans-spring-boot-starter:2.0.3")
    implementation("com.fhs-opensource:easy-trans-tk-extend:2.0.3")
    implementation("com.fhs-opensource:easy-trans-mybatis-plus-extend:2.0.3")
    implementation("com.fhs-opensource:easy-trans-jpa-extend:2.0.3")
    implementation("org.projectlombok:lombok-mapstruct-binding:0.2.0")
    implementation("io.dapr:dapr-sdk-springboot:1.6.0")
    implementation("org.mapstruct:mapstruct:1.5.2.Final")
//    annotationProcessor("org.mapstruct:mapstruct-processor:1.5.2.Final")
//    compileOnly("org.mapstruct:mapstruct-processor:1.5.2.Final")
    kapt("org.mapstruct:mapstruct-processor:1.5.2.Final")
    implementation("com.baomidou:mybatis-plus-boot-starter:3.5.2")
    implementation("tk.mybatis:mapper-spring-boot-starter:4.2.1"){
        exclude(group = "javax.persistence", module = "persistence-api")
    }
    implementation("com.github.pagehelper:pagehelper-spring-boot-starter:1.4.5")
    implementation("com.github.atool:fluent-mybatis-boot-starter:1.9.8")
//    annotationProcessor("com.github.atool:fluent-mybatis-processor:1.9.8")
//    compileOnly("com.github.atool:fluent-mybatis-processor:1.9.8")
    kapt("com.github.atool:fluent-mybatis-processor:1.9.8")

    implementation("cn.hutool:hutool-all:5.8.7")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-amqp")
    implementation("org.springframework.boot:spring-boot-starter-batch")
    implementation("org.springframework.boot:spring-boot-starter-cache")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-data-redis")
    implementation("org.springframework.boot:spring-boot-starter-jooq")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-websocket")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("de.codecentric:spring-boot-admin-starter-client")
    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
    implementation("org.apache.camel.springboot:camel-spring-boot-starter:3.18.1")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
    implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:2.2.2")
    implementation("org.springframework.cloud:spring-cloud-sleuth-zipkin")
    implementation("org.springframework.cloud:spring-cloud-starter-loadbalancer")
    implementation("org.springframework.cloud:spring-cloud-starter-openfeign")
    implementation("org.springframework.cloud:spring-cloud-starter-zookeeper-config")
    implementation("org.springframework.cloud:spring-cloud-starter-zookeeper-discovery")
    implementation("org.springframework.cloud:spring-cloud-stream")
    implementation("org.springframework.cloud:spring-cloud-stream-binder-rabbit")
    compileOnly("org.projectlombok:lombok")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    runtimeOnly("io.micrometer:micrometer-registry-influx")
    runtimeOnly("mysql:mysql-connector-java")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    annotationProcessor("org.projectlombok:lombok")
//    kapt("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("io.projectreactor:reactor-test")
    testImplementation("org.springframework.amqp:spring-rabbit-test")
    testImplementation("org.springframework.batch:spring-batch-test")
}

dependencyManagement {
    imports {
        mavenBom("de.codecentric:spring-boot-admin-dependencies:${property("springBootAdminVersion")}")
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    enabled = false
    useJUnitPlatform()
}

kapt {
    keepJavacAnnotationProcessors = true
}