<h1 align="center">🍲 FavoriteDish: A High-Performance Recipe Ecosystem Built with Modern Android Engineering 🚀</h1>

<p align="center">
  <a href="https://kotlinlang.org/"><img src="https://img.shields.io/badge/Kotlin-2.1.0-blueviolet?style=for-the-badge&logo=kotlin" alt="Kotlin"></a>
  <a href="https://developer.android.com/"><img src="https://img.shields.io/badge/Android-Modern%20Android%20Development-3DDC84?style=for-the-badge&logo=android" alt="Android"></a>
  <a href="https://developer.android.com/topic/architecture"><img src="https://img.shields.io/badge/Architecture-MVVM%20%2B%20Repo-FF8C00?style=for-the-badge" alt="MVVM"></a>
  <a href="https://developer.android.com/training/data-storage/room"><img src="https://img.shields.io/badge/Database-Room-4285F4?style=for-the-badge&logo=sqlite" alt="Room"></a>
  <a href="https://square.github.io/retrofit/"><img src="https://img.shields.io/badge/API-Retrofit-red?style=for-the-badge" alt="Retrofit"></a>
  <a href="https://github.com/ReactiveX/RxJava"><img src="https://img.shields.io/badge/Reactive-RxJava3-C2185B?style=for-the-badge&logo=reactivex" alt="RxJava"></a>
</p>

---

## 📑 Table of Contents
- [🎯 Executive Summary](#-executive-summary)
- [🏗️ High-Level Architecture](#️-high-level-architecture)
- [🚀 Feature Deep-Dive](#-feature-deep-dive)
- [🛠️ Detailed Technical Stack](#️-detailed-technical-stack)
- [📊 MAD Score (Modern Android Development)](#-mad-score-modern-android-development)
- [📡 Network & Data Flow](#-network--data-flow)
- [🎨 UI/UX Design System](#-uiux-design-system)
- [🔔 Background Services](#-background-services)
- [📸 Visual Showcase](#-visual-showcase)
- [⚙️ Engineering Setup](#️-engineering-setup)
- [📈 Learning Trajectory](#-learning-trajectory)

---

## 🎯 Executive Summary
**FavDish** is not just an app; it is a comprehensive technical demonstration of **Modern Android Development (MAD)**. Built as a high-tier personal education project, it solves the "What should I cook today?" problem by blending local recipe management with global API-driven discovery. 

The project was engineered to showcase mastery over the entire Android lifecycle, from complex UI animations and dynamic color processing to robust background task scheduling and reactive data streams.

---

## 📸 Visual Showcase

<p align="center">
  <img src="https://github.com/user-attachments/assets/33f015fa-fac9-4cfd-bfb4-de2a6466b90b" width="24%">
  <img src="https://github.com/user-attachments/assets/d9e154e4-8d1d-4d69-ba16-097e44f7310a" width="24%">
  <img src="https://github.com/user-attachments/assets/4cb20d78-b9d3-4b7c-8c97-7f15845d1226" width="24%">
</p>
<p align="center">
  <img src="https://github.com/user-attachments/assets/9ed14528-e595-41e9-bc84-1a5aa2a962b4" width="24%">
  <img src="https://github.com/user-attachments/assets/f43b8655-e0a4-478f-8ced-9794df76b07c" width="24%">
  <img src="https://github.com/user-attachments/assets/767153b5-aade-4507-800e-4df0e179c666" width="24%">
</p>
<p align="center">
  <img src="https://github.com/user-attachments/assets/121e210d-aad7-4765-9dcc-c05e4d4c9091" width="24%">
  <img src="https://github.com/user-attachments/assets/a225e5cb-9514-444a-8797-7a2ab47bb461" width="24%">
  <img src="https://github.com/user-attachments/assets/8af215e7-6f73-46cd-b44d-9e549b8e2b53" width="24%">
</p>
<p align="center">
  <img src="https://github.com/user-attachments/assets/f880bb28-16ef-4719-8b69-2306b1519630" width="24%">
  <img src="https://github.com/user-attachments/assets/556aa70f-9ef6-49fa-8e2f-59e76361176c" width="24%">
  <img src="https://github.com/user-attachments/assets/883b14d5-683e-4920-999f-2dd3252ee977" width="24%">
</p>
<p align="center">
  <img src="https://github.com/user-attachments/assets/97a06f48-f712-49c2-a2f7-17362801a8b4" width="24%">
  <img src="https://github.com/user-attachments/assets/f2feda11-74ac-4c8a-bb8f-1adc573b3ff9" width="24%">
  <img src="https://github.com/user-attachments/assets/d7bfc5a3-51a4-4395-944a-f21ff4b4b1aa" width="24%">
</p>
<p align="center">
  <img src="https://github.com/user-attachments/assets/43f668a2-8deb-41ad-98f9-a1b6d295dfea" width="24%">
  <img src="https://github.com/user-attachments/assets/18e4e3ba-d0b7-4f32-9375-1fe48bd901c8" width="24%">
  <img src="https://github.com/user-attachments/assets/f9e81a56-0fd0-4e94-837f-5c658e8c1b53" width="24%">
</p>
<p align="center">
  <img src="https://github.com/user-attachments/assets/c38f06ba-461c-4ef0-be8d-4941b1295476" width="24%">
  <img src="https://github.com/user-attachments/assets/d9b163c1-a2e3-4d0c-ae4e-0e28fe27c833" width="24%">
  <img src="https://github.com/user-attachments/assets/a2b61ef0-dd70-4e38-9870-4f8055cc7fa7" width="24%">
</p>

---

## 🏗️ High-Level Architecture

### 🏛️ Model-View-ViewModel (MVVM) + Repository Pattern
FavDish implements a strict separation of concerns. The **Repository** acts as the mediator between the **Local Room Database** and the **Remote Retrofit Service**, ensuring a "Single Source of Truth."

```mermaid
graph TD
    subgraph UI_Layer [View Layer - Fragment/Activity]
        V[Fragments/Activities] -->|Observes LiveData| VM[ViewModels]
        VM -->|Triggers UI Events| V
    end
    
    subgraph Logic_Layer [Domain Logic - Repository]
        VM -->|Calls| R[FavDishRepository]
        R -->|Returns Streams| VM
    end
    
    subgraph Data_Layer [Data Source]
        R -->|Local Ops| DB[(Room SQLite)]
        R -->|Remote Ops| API{Retrofit / RxJava3}
        API -->|Fetch JSON| SD[Spoonacular API]
    end

    style UI_Layer fill:#e1f5fe,stroke:#01579b
    style Logic_Layer fill:#fff3e0,stroke:#ff6f00
    style Data_Layer fill:#f1f8e9,stroke:#1b5e20
```

### 🛣️ Navigation Component Flow
The application utilizes a single-activity architecture with **Jetpack Navigation**.

```mermaid
sequenceDiagram
    participant S as Splash (Animation)
    participant H as All Dishes (Home)
    participant A as Add/Update Activity
    participant D as Dish Details (Dynamic)
    participant R as Random Dish (API)
    
    S->>H: Auto-Transition
    H->>A: Intent (Add New)
    A->>H: Room Update (Refresh)
    H->>D: SafeArgs (Parcelable)
    H->>R: Tab Switch
    R->>D: SafeArgs (API to Local)
```

---

## 🚀 Feature Deep-Dive

### 💾 1. Local Recipe Management (The Personal Cookbook)
- **Persistence:** High-performance local storage using **Room DB**.
- **CRUD Operations:** Full Create, Read, Update, and Delete capabilities with reactive UI updates.
- **Image Persistence:** Efficiently saves captured or selected images to internal storage, storing paths in SQLite to minimize DB size.

### 🎲 2. Global Recipe Discovery (The Explorer)
- **API Integration:** Connects to the **Spoonacular Global API**.
- **RxJava3 Single:** Handles network requests as Single observables, ensuring a non-blocking UI thread.
- **Swipe-to-Discover:** Implements `SwipeRefreshLayout` for a modern, tactile interaction to pull new recipes.

### 🎨 3. Dynamic Visual Engine
- **Palette API:** The "Dish Details" screen extracts the dominant color from the recipe's image and applies it to the background dynamically.
- **Glide Transformations:** Professional-grade image loading with caching, center-cropping, and error handling.
- **SDP/SSP:** Uses Scalable DP and Scalable SP libraries to ensure the UI looks consistent across thousands of different Android device resolutions.

### 🔔 4. Engagement & Background Tasks
- **WorkManager:** Schedules `PeriodicWorkRequest` to engage users with notifications even when the app is killed.
- **Intelligent Constraints:** Tasks only run when the battery is not low, optimizing device longevity.

---

## 🛠️ Detailed Technical Stack

### **Core Language & Foundation**
- **Kotlin 2.1.0:** Utilizing Coroutines, Flow, Parcelize, and extension functions.
- **Android KTX:** Leveraging Kotlin extensions for concise, idiomatic code.

### **Jetpack Components**
- **Navigation:** SafeArgs implementation for type-safe data passing.
- **Room:** SQLite abstraction with Flow support for real-time DB observing.
- **ViewModel:** Managing UI-related data in a lifecycle-conscious way.
- **WorkManager:** For guaranteed background execution.

### **Networking & Threading**
- **Retrofit 2.9.0:** Type-safe HTTP client.
- **RxJava3:** Reactive programming for complex asynchronous streams.
- **Gson:** JSON serialization/deserialization.

### **UI & Permissions**
- **Material 3:** Modern design components and themes.
- **ViewBinding & DataBinding:** Eliminating `findViewById` and connecting data directly to layouts.
- **Dexter:** Simplified runtime permission handling (Camera/Gallery).
- **Palette:** Dynamic UI coloring based on image analysis.

---

## 📊 MAD Score (Modern Android Development)

| Criteria | Implementation Status | Tech Used |
| :--- | :---: | :--- |
| **Language** | 🟢 **100% Kotlin** | Coroutines, Flow, Sealed Classes |
| **Architecture** | 🟢 **Excellent** | MVVM + Repository + Clean Code |
| **UI** | 🟢 **Modern** | Material 3, ViewBinding, Palette |
| **Navigation** | 🟢 **Jetpack** | Navigation Component + SafeArgs |
| **Networking** | 🟢 **Reactive** | Retrofit + RxJava3 |
| **Database** | 🟢 **Reactive** | Room + TypeConverters |
| **Background** | 🟢 **Robust** | WorkManager (Periodic) |

---

## 📡 Network & Data Flow

### **The "Random Dish" Lifecycle**
1. **Trigger:** User opens the "Random Dish" tab or swipes to refresh.
2. **ViewModel:** Calls the `RandomDishApiService`.
3. **Retrofit:** Executes the `GET` request with API Key and tags.
4. **RxJava3:** Emits a `Single<RandomDish.Recipes>` stream.
5. **ViewModel:** Subscribes on a background thread, observes on the Main thread.
6. **UI:** Updates via `LiveData` observation, displaying the recipe and downloading the image via **Glide**.

---

## 🎨 UI/UX Design System

### **Responsive Layouts**
By integrating **SDP (Scalable DP)** and **SSP (Scalable SP)**, FavDish achieves a "Build Once, Run Anywhere" UI. Whether on a small pixel phone or a large tablet, the proportions remain perfect.

### **Dynamic Theming**
```kotlin
// Example of the Palette API in action within DishDetailsFragment
Palette.from(bitmap).generate { palette ->
    val intColor = palette?.vibrantSwatch?.rgb ?: 0
    mBinding.rlDishDetailMain.setBackgroundColor(intColor)
}
```

---

## ⚙️ Engineering Setup

### **Prerequisites**
- Android Studio **Ladybug** or higher.
- Gradle **8.13** or higher.
- Minimum SDK: **21** (Lollipop).
- Target SDK: **35** (Android 15).

### **Installation Steps**
1. **Clone the project:**
   ```bash
   git clone https://github.com/yourusername/FavDish.git
   ```
2. **Obtain API Key:**
   - Sign up at [Spoonacular Food API](https://spoonacular.com/food-api).
   - Navigate to `com.myapp.favdish.utils.Constants`.
   - Replace `API_KEY_VALUE` with your unique key.
3. **Sync & Run:**
   - Let Gradle download dependencies.
   - Run the `:app` module on your device.

---

## 📈 Learning Trajectory
Developing **FavDish** was a deep-dive into the complexities of the Android ecosystem. Key technical milestones achieved:
- **Asynchronous Mastery:** Transitioning from basic callbacks to Coroutines and RxJava.
- **State Management:** Learning how to handle configuration changes (rotation) without data loss using ViewModels.
- **Data Integrity:** Designing complex SQLite schemas and handling migrations with Room.
- **Modern UI:** Implementing Material 3 principles and dynamic color extraction.

---
<p align="center"><b>Built with Precision & Passion 🚀</b></p>
