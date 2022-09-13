plugins {
    kotlin("multiplatform") version "1.6.21"
}

group = "bettermarks"
version = "1.0"

repositories {
    mavenCentral()
}

kotlin {
    js(IR) {
        binaries.executable()
        useCommonJs()
        browser {
            webpackTask {
                output.library = "equation-validator"
            }
        }
    }
    val hostOs = System.getProperty("os.name")
    val isMingwX64 = hostOs.startsWith("Windows")
    when {
        hostOs == "Mac OS X" -> macosX64("native") {
            binaries {
                executable()
            }
        }
        hostOs == "Linux" -> linuxX64("native") {
            binaries {
                executable()
            }
        }
        isMingwX64 -> mingwX64("native") {
            binaries {
                executable()
            }
        }
        else -> throw GradleException("Host OS is not supported in Kotlin/Native.")
    }

    sourceSets {
        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val jsMain by getting
        val jsTest by getting
        val nativeMain by getting
        val nativeTest by getting
    }
}
