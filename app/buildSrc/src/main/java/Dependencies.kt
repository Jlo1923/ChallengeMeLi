object Versions {
    const val kotlinVersion = "1.4.31"
    const val kotlinCoroutineVersion = "1.4.3"
    const val coreKtxVersion = "1.3.2"
    const val appCompatVersion = "1.2.0"
    const val materialVersion = "1.3.0"
    const val constraintLayoutVersion = "2.0.4"
    const val roomVersion = "2.2.6"
    const val navigationVersion = "2.3.3"
    const val lifecycleVersion = "2.3.0"
    const val lifecycleTestingVersion = "2.1.0"
    const val retrofitVersion = "2.9.0"
    const val hiltVersion = "2.33-beta"
    const val daggerVersion = "2.33"
    const val glideVersion = "4.12.0"
    const val ktLintVersion = "0.40.0"
    const val firebaseBomVersion = "26.6.0"
    const val multiDexVersion = "2.0.1"

    const val jUnitVersion = "4.13.2"
    const val androidxTestExtJUnitVersion = "1.1.2"
    const val androidxTestEspressoCoreVersion = "3.3.0"
    const val mockito = "3.8.0"
    const val mockitoKotlin = "2.2.0"
}

object Dependencies {
    const val ktLint = "com.pinterest:ktlint:${Versions.ktLintVersion}"
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlinVersion}"
    const val kotlinCoroutines =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinCoroutineVersion}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtxVersion}"
    const val material = "com.google.android.material:material:${Versions.materialVersion}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompatVersion}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayoutVersion}"
    const val roomRuntime = "androidx.room:room-runtime:${Versions.roomVersion}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.roomVersion}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.roomVersion}"
    const val navigationFragmentKtx =
        "androidx.navigation:navigation-fragment-ktx:${Versions.navigationVersion}"
    const val navigationUiKtx =
        "androidx.navigation:navigation-ui-ktx:${Versions.navigationVersion}"
    const val lifecycleLiveData =
        "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycleVersion}"
    const val lifecycleViewModel =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleVersion}"
    const val lifecycleCommonJ8 =
        "androidx.lifecycle:lifecycle-common-java8:${Versions.lifecycleVersion}"
    const val dagger = "com.google.dagger:dagger:${Versions.daggerVersion}"
    const val hilt = "com.google.dagger:hilt-android:${Versions.hiltVersion}"
    const val hiltCompiler = "com.google.dagger:hilt-compiler:${Versions.hiltVersion}"
    const val glide = "com.github.bumptech.glide:glide:${Versions.glideVersion}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glideVersion}"

    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
    const val retrofitConverterGson =
        "com.squareup.retrofit2:converter-gson:${Versions.retrofitVersion}"
    const val firebaseBom = "com.google.firebase:firebase-bom:${Versions.firebaseBomVersion}"
    const val firebaseAnalitics = "com.google.firebase:firebase-analytics"
    const val multidex = "androidx.multidex:multidex:${Versions.multiDexVersion}"

}

object TestDependencies {
    const val junit = "junit:junit:${Versions.jUnitVersion}"
    const val androidExtJUnit = "androidx.test.ext:junit:${Versions.androidxTestExtJUnitVersion}"
    const val espresso =
        "androidx.test.espresso:espresso-core:${Versions.androidxTestEspressoCoreVersion}"
    const val roomTest = "androidx.room:room-testing:${Versions.roomVersion}"
    const val lifecycleTest = "androidx.arch.core:core-testing:${Versions.lifecycleTestingVersion}"
    const val mockito = "org.mockito:mockito-core:${Versions.mockito}"
    const val mockitoKotlin = "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.mockitoKotlin}"
    const val coroutinesTest =
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.kotlinCoroutineVersion}"
}

