# Users Management App
## Overview
The Users Management app is an Android application designed to demonstrate basic user information retrieval and display. This app fetches data from a remote API and presents it in a clean, intuitive interface, allowing users to view a list of users and access detailed information about each one.

## Features

- Fetches user data from the JSONPlaceholder API.
- Displays a list of users, including name, username, and email, etc..
- Allows users to view detailed information about each user, such as address, phone number, and company details, etc..
- Follows MVVM architecture to separate concerns and improve the app's structure.
- Error handling for network issues or failed API calls.
- Clean, responsive UI with smooth navigation between screens.

## Tech Stack

- Kotlin: Programming language used to build the app.
- Retrofit: A type-safe HTTP client for Android to make network requests and fetch user data from a REST API.
- Dagger Hilt: Dependency Injection framework for managing app components and service classes.
- LiveData: Observable data holder used to ensure that UI components react to data changes.
- ViewModel: A lifecycle-aware class used to manage UI-related data in a lifecycle-conscious way.
- RecyclerView: Efficiently displays large sets of user data.
- MVVM: Separation of concerns between the View (UI), Model (data), and ViewModel (logic).

## Architecture
This project follows the MVVM architecture, which provides a clear separation between the UI components and the business logic.

- View: Activities responsible for displaying data.
- ViewModel: Acts as a bridge between the model and the view. It holds the app's data and handles the logic for fetching data from the API.

## How to Run the Project

1- Clone the repository:
 -git clone https://github.com/GhoAhmed/UserManagement.git
2- Open the project in Android Studio.
3- Sync the Gradle files to download all dependencies.
4- Build and run the app on an emulator or physical device.

