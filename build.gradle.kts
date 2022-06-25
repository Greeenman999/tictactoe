plugins {
    id("com.github.johnrengelman.shadow") version "7.1.2"
    id("java")
    id("xyz.jpenilla.run-paper") version "1.0.6"
}

group = "de.greenman999"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://repo.codemc.org/repository/maven-public/")
    maven("https://papermc.io/repo/repository/maven-public/")
    maven("https://oss.sonatype.org/content/groups/public/")
    maven("https://jitpack.io")
}

dependencies {
    implementation("dev.jorel:commandapi-shade:8.4.0")
    compileOnly("io.papermc.paper:paper-api:1.19-R0.1-SNAPSHOT")
    implementation("net.kyori:adventure-text-minimessage:4.10.1")
}

tasks {
    runServer {
        minecraftVersion("1.19")
    }
    shadowJar {
        relocate("dev.jorel.commandapi", "de.greenman999.tictactoe.deps.commandapi")
    }
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(18))
}