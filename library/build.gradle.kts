import com.vanniktech.maven.publish.SonatypeHost
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.vanniktech.mavenPublish)
}

group = "org.badpost.kriichi"
version = "0.1.0-SNAPSHOT"

kotlin {
    jvm()
    androidTarget {
        publishLibraryVariants("release")
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_1_8)
        }
    }
    iosX64()
    iosArm64()
    iosSimulatorArm64()
    linuxX64()

    sourceSets {
        val commonMain by getting {
            dependencies {
                //put your multiplatform dependencies here
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(libs.kotlin.test)
            }
        }
    }
}

android {
    namespace = "org.badpost.kriichi"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }
}

mavenPublishing {
    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)
    signAllPublications()

    coordinates(group.toString(), "kriichi", version.toString())

    pom {
        name.set("kriichi")
        description.set("Mahjong Riichi domain logic implementation for KMP.")
        inceptionYear.set("2025")
        licenses {
            license {
                name.set("The MIT License (MIT)")
                url.set("https://github.com/samoheen/kriichi/blob/master/LICENSE.txt")
                distribution.set("https://github.com/samoheen/kriichi/blob/master/LICENSE.txt")
            }
        }
        developers {
            developer {
                id.set("samoheen")
                name.set("Sam O'Heen")
                url.set("https://github.com/samoheen/")
            }
        }
        scm {
            url.set("https://github.com/samoheen/kriichi/")
            connection.set("scm:git:git://github.com/samoheen/kriichi.git")
            developerConnection.set("scm:git:ssh://git@github.com/samoheen/kriichi.git")
        }
    }
}