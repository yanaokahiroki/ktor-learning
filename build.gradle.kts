val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project

plugins {
  kotlin("jvm") version "1.8.10"
  id("io.ktor.plugin") version "2.2.3"
  id("org.jetbrains.kotlin.plugin.serialization") version "1.8.0"
}

group = "com.learning"
version = "0.0.1"
application {
  mainClass.set("io.ktor.server.netty.EngineMain")
  
  val isDevelopment: Boolean = project.ext.has("development")
  applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
  mavenCentral()
}

dependencies {
  // Ktorコア
  implementation("io.ktor:ktor-server-core-jvm:$ktor_version")
  // Nettyエンジン
  implementation("io.ktor:ktor-server-netty-jvm:$ktor_version")
  // ORM
  implementation("io.ktor:ktor-server-content-negotiation:$ktor_version")
  implementation("io.ktor:ktor-serialization-kotlinx-json:$ktor_version")
  // ログ出力
  implementation("ch.qos.logback:logback-classic:$logback_version")
  // YAML形式の設定
  implementation("io.ktor:ktor-server-config-yaml:$ktor_version")
  // テスト
  testImplementation("io.ktor:ktor-server-tests-jvm:$ktor_version")
  testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
}
