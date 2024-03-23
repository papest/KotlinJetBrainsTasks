val ktorVersion: String = "2.2.2"


plugins {
    kotlin("jvm") version "1.6.20"
    id("org.jetbrains.kotlin.plugin.serialization") version "1.6.10" apply true
    id("org.jetbrains.kotlin.plugin.atomicfu") version "1.6.20" apply true

}

group = "me.peia"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven {
        url = uri("https://plugins.gradle.org/m2/")
    }
}
apply(plugin = "org.jetbrains.kotlin.plugin.serialization" )
apply(plugin= "kotlinx-atomicfu")
dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.3")
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.6.0")
    implementation("org.jetbrains.kotlinx:kotlinx-cli:0.3.5")
    implementation("org.jetbrains.kotlinx:kotlinx-html:0.8.1")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-core-jvm:1.3.2")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2")
    implementation("org.jetbrains.kotlinx:atomicfu:0.16.2")
    // https://mvnrepository.com/artifact/rome/rome
    //implementation("rome:rome:0.9")
    // https://mvnrepository.com/artifact/com.rometools/rome
    implementation("com.rometools:rome:2.1.0")
    // https://mvnrepository.com/artifact/org.jetbrains.exposed/exposed-core
    implementation("org.jetbrains.exposed:exposed-core:0.38.2")
    implementation("org.jetbrains.exposed:exposed-dao:0.38.2")
    implementation("org.jetbrains.exposed:exposed-jdbc:0.38.2")
    // https://mvnrepository.com/artifact/io.ktor/ktor-client-core
    implementation("io.ktor:ktor-client-core:$ktorVersion")
    // https://mvnrepository.com/artifact/io.ktor/ktor-client-cio
    implementation("io.ktor:ktor-client-cio:$ktorVersion")
    // https://mvnrepository.com/artifact/io.ktor/ktor-client-websockets-jvm
    implementation("io.ktor:ktor-client-websockets-jvm:$ktorVersion")
    // https://mvnrepository.com/artifact/com.h2database/h2
    // https://mvnrepository.com/artifact/io.ktor/ktor-serialization-kotlinx-json
    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
    implementation("com.h2database:h2:2.2.220")

    testImplementation(kotlin("test"))
}


tasks.test {
    useJUnitPlatform()
}

