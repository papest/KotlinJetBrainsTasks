
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
    implementation("rome:rome:0.9")
    testImplementation(kotlin("test"))
}


tasks.test {
    useJUnitPlatform()
}

