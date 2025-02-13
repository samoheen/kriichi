import com.vanniktech.maven.publish.SonatypeHost

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.vanniktech.mavenPublish)
}

group = "org.badpost.kriichi"
version = "0.1.0"

kotlin {
    jvm()
    iosArm64()

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

mavenPublishing {
    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)
    signAllPublications()

    coordinates(group.toString(), "kriichi", version.toString())

    pom {
        name = "kriichi"
        description = "Mahjong Riichi domain logic implementation for KMP."
        inceptionYear = "2025"
        url = "https://github.com/samoheen/"
        licenses {
            license {
                name = "The MIT License (MIT)"
                url = "https://github.com/samoheen/kriichi/blob/master/LICENSE.txt"
                distribution = "https://github.com/samoheen/kriichi/blob/master/LICENSE.txt"
            }
        }
        developers {
            developer {
                id = "samoheen"
                name = "Sam O'Heen"
                url = "https://github.com/samoheen/"
            }
        }
        scm {
            url = "https://github.com/samoheen/kriichi/"
            connection = "scm:git:git://github.com/samoheen/kriichi.git"
            developerConnection = "scm:git:ssh://git@github.com/samoheen/kriichi.git"
        }
    }
}
