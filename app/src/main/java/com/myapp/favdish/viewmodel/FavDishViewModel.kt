package com.myapp.favdish.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.myapp.favdish.model.database.FavDishRepository
import com.myapp.favdish.model.entities.FavDish
import kotlinx.coroutines.launch

/**
 * The ViewModel data is retained through configuration changes (such as when the user rotates the screen).
 *
 * @param repository - The repository that we will use to get the data from the database.
 */
class FavDishViewModel(private val repository: FavDishRepository) : ViewModel() {

    /**
     * Launching a new coroutine to insert the data in a non-blocking way.
     */
    fun insert(dish: FavDish) = viewModelScope.launch {
        repository.insertFavDishData(dish)
    }
}

/**
 * To create the ViewModel we need a factory that can pass the repository as a parameter.
 */
class FavDishViewModelFactory(private val repository: FavDishRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FavDishViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return FavDishViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
