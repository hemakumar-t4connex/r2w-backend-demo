plugins {
	java
	id("org.springframework.boot") version "3.3.0"
	id("io.spring.dependency-management") version "1.1.5"
	id("maven-publish")
}

group = "com.t4connex.r2w"
version = "0.0.1"

tasks.named("jar") {
	enabled = true
}

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

repositories {
	flatDir { dirs("../libs") }
	mavenCentral()
	mavenLocal()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

publishing {
	(publications) {
		register("mavenJava", MavenPublication::class) {
			from(components["java"])
		}
	}
}