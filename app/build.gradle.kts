import com.example.util.simpletimetracker.Base
import com.example.util.simpletimetracker.Deps

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
}

android {
    compileSdkVersion(Base.currentSDK)

    defaultConfig {
        applicationId = "com.razeeman.util.simpletimetracker"
        minSdkVersion(Base.minSDK)
        targetSdkVersion(Base.currentSDK)
        versionCode = Base.versionCode
        versionName = Base.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("debug") {
            applicationIdSuffix = ".debug"
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android.txt"),
                "proguard-debug-rules.pro"
            )
            testProguardFile("proguard-test-rules.pro")
        }
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    implementation(project(":core"))
    implementation(project(":data_local"))
    implementation(project(":feature_main"))
    implementation(project(":feature_running_records"))
    implementation(project(":feature_change_record_type"))
    implementation(project(":feature_records"))
    implementation(project(":feature_records_all"))
    implementation(project(":feature_change_record"))
    implementation(project(":feature_change_running_record"))
    implementation(project(":feature_statistics"))
    implementation(project(":feature_statistics_detail"))
    implementation(project(":feature_settings"))
    implementation(project(":feature_dialogs"))
    implementation(project(":feature_widget"))
    implementation(project(":feature_notification"))
    implementation(project(":feature_categories"))
    implementation(project(":feature_change_category"))

    implementation(Deps.Androidx.room)
    implementation(Deps.Ktx.navigationFragment)
    implementation(Deps.Ktx.navigationUi)

    kapt(Deps.Kapt.dagger)
    kaptAndroidTest(Deps.Kapt.dagger)

    androidTestImplementation(Deps.UiTest.junit)
    androidTestImplementation(Deps.UiTest.espresso)
    androidTestImplementation(Deps.UiTest.espressoContrib)
}
