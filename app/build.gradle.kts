plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    kotlin("plugin.serialization") version embeddedKotlinVersion
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.aarh.borutoapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.aarh.borutoapp"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.activity:activity-compose:1.8.1")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    // Compose Navigation
    implementation("androidx.navigation:navigation-compose:2.7.5")

    // Room Components
    implementation("androidx.room:room-runtime:2.5.0")
    ksp("androidx.room:room-compiler:2.5.0")
    implementation("androidx.room:room-ktx:2.5.0")

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:0.8.0")

    // Paging 3.0
    implementation("androidx.paging:paging-compose:3.3.0-alpha02")

    // KotlinX Serialization
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.1")

    // DataStore Preferences
    implementation("androidx.datastore:datastore-preferences:1.0.0")

    // Dagger - Hilt
    implementation("com.google.dagger:hilt-android:2.47")
    ksp("com.google.dagger:hilt-android-compiler:2.47")
    ksp("androidx.hilt:hilt-compiler:1.1.0-alpha01")
    implementation("androidx.hilt:hilt-navigation-compose:1.1.0-alpha01")

    // Coil
    implementation("io.coil-kt:coil-compose:2.4.0")

    // Horizontal Pager and Indicators - Accompanist
    implementation("com.google.accompanist:accompanist-pager:0.33.2-alpha")
    implementation("com.google.accompanist:accompanist-pager-indicators:0.33.2-alpha")

    // Swipe to Refresh - Accompanist
    implementation("com.google.accompanist:accompanist-swiperefresh:0.33.2-alpha")

    // System UI Controller - Accompanist
    implementation("com.google.accompanist:accompanist-systemuicontroller:0.33.2-alpha")

    // Palette API
    implementation("androidx.palette:palette-ktx:1.0.0")

    // Testing
    androidTestImplementation("androidx.test:runner:1.5.2")
    androidTestImplementation("androidx.test:rules:1.5.0")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.5.4")
    debugImplementation("androidx.compose.ui:ui-test-manifest:1.5.4")

    testImplementation("junit:junit:4.13.2")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:1.9.20")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.1")
}
