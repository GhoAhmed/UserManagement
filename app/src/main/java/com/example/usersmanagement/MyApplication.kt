package com.example.usersmanagement

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

// The @HiltAndroidApp annotation triggers Hilt's code generation,
// including a base class for the Application that serves as the application-level dependency container.
@HiltAndroidApp
class MyApplication : Application() {
    // Currently, there are no additional configurations.
}