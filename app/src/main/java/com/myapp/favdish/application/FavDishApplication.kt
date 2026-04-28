package com.myapp.favdish.application

import android.app.Application
import com.myapp.favdish.model.database.FavDishRepository
import com.myapp.favdish.model.database.FavDishRoomDatabase

/**
 * A class that extends {@link Application} where we can initialize the database and repository
 * so they can be used across the app.
 */
class FavDishApplication : Application() {

    /**
     * Using lazy so the database and the repository are only created when they're needed
     * rather than when the application starts.
     */
    val database by lazy { FavDishRoomDatabase.getDatabase(this) }

    val repository by lazy { FavDishRepository(database.favDishDao()) }
}
