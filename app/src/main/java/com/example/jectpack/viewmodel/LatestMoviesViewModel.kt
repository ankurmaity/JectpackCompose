package com.example.jectpack.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jectpack.model.Movie
import com.example.jectpack.repo.Repository
import kotlinx.coroutines.launch

class LatestMoviesViewModel : ViewModel() {
    private val repository = Repository()

    private val _movieResponse = MutableLiveData<List<Movie>>()
    val movie: LiveData<List<Movie>> = _movieResponse

    fun fetchMovies() {
        viewModelScope.launch {
            try {
                val moviesResponse = repository.getLatestMovies()
                _movieResponse.value = moviesResponse.results
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}