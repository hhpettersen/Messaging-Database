plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    id("maven-publish")
}

publishing {
    publications {
        create<MavenPublication>("myLibraryPublication") {
            // Adjust this to include the components you want to publish
            from(components["kotlin"])

            groupId = "com.example.messaging_database" // Adjust to your group ID
            artifactId = "mylibrary" // Name of your library
            version = "1.0.3" // Version of your library
        }
    }
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    androidTarget {
        publishLibraryVariants("release", "debug")
    }
    
//    listOf(
//        iosX64(),
//        iosArm64(),
//        iosSimulatorArm64()
//    ).forEach {
//        it.binaries.framework {
//            baseName = "shared"
//            isStatic = true
//        }
//    }

    sourceSets {
        commonMain.dependencies {
            //put your multiplatform dependencies here
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

android {
    namespace = "com.example.messaging_database"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
}
