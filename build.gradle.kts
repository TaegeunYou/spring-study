import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.7.7"
	id("io.spring.dependency-management") version "1.0.15.RELEASE"
	id ("com.ewerk.gradle.plugins.querydsl") version "1.0.10"

	val kotlinVersion = "1.7.10"
	kotlin("jvm") version kotlinVersion
	kotlin("plugin.spring") version kotlinVersion
	kotlin("plugin.jpa") version kotlinVersion
	kotlin("kapt") version kotlinVersion
}

group = "study"
version = "0.0.1"
java.sourceCompatibility = JavaVersion.VERSION_11

val queryDSLVersion = "5.0.0"

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-jdbc")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	annotationProcessor("jakarta.persistence:jakarta.persistence-api")
	annotationProcessor("jakarta.annotation:jakarta.annotation-api")

	//Test
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.assertj:assertj-core:3.23.1")

	//H2
	implementation("com.h2database:h2")

	//QueryDSL
	implementation("com.querydsl:querydsl-jpa:$queryDSLVersion")
	kapt("com.querydsl:querydsl-apt:$queryDSLVersion:jpa")
	kaptTest("com.querydsl:querydsl-apt:$queryDSLVersion:jpa")

	//Log
	implementation("com.github.gavlyukovskiy:p6spy-spring-boot-starter:1.5.8")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

allOpen {
	annotation("javax.persistence.Entity")
}

noArg {
	annotations("javax.persistence.Entity")
}
