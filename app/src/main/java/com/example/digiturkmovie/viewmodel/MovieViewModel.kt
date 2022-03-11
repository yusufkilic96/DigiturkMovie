package com.example.digiturkmovie.viewmodel


import android.graphics.Movie
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.digiturkmovie.models.MovieItem
import com.example.digiturkmovie.models.MovieResponse
import com.example.digiturkmovie.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


@HiltViewModel
class MovieViewModel
@Inject
constructor
(private val repository: MovieRepository):ViewModel(){

    private val _response = MutableLiveData<List<MovieItem>>()
    val responseMovie: LiveData<List<MovieItem>>
        get() = _response

    private val _responseAdventure = MutableLiveData<List<MovieItem>>()
    val responseAdventureMovie: LiveData<List<MovieItem>>
        get() = _responseAdventure

    private val _responseAnimation = MutableLiveData<List<MovieItem>>()
    val responseAnimationMovie: LiveData<List<MovieItem>>
        get() = _responseAnimation

    private val _responseComedy = MutableLiveData<List<MovieItem>>()
    val responseComedyMovie: LiveData<List<MovieItem>>
        get() = _responseComedy

    private val _responseCrime = MutableLiveData<List<MovieItem>>()
    val responseCrimeMovie: LiveData<List<MovieItem>>
        get() = _responseCrime

    private val _responseDocumentary = MutableLiveData<List<MovieItem>>()
    val responseDocumentaryMovie: LiveData<List<MovieItem>>
        get() = _responseDocumentary

    private val _responseDrama = MutableLiveData<List<MovieItem>>()
    val responseDramaMovie: LiveData<List<MovieItem>>
        get() = _responseDrama

    private val _responseFamily = MutableLiveData<List<MovieItem>>()
    val responseFamilyMovie: LiveData<List<MovieItem>>
        get() = _responseFamily

    private val _responseFantasy = MutableLiveData<List<MovieItem>>()
    val responseFantasyMovie: LiveData<List<MovieItem>>
        get() = _responseFantasy

    private val _responseHorror = MutableLiveData<List<MovieItem>>()
    val responseHorrorMovie: LiveData<List<MovieItem>>
        get() = _responseHorror

    private val _responseMusic = MutableLiveData<List<MovieItem>>()
    val responseMusicMovie: LiveData<List<MovieItem>>
        get() = _responseMusic

    private val _responseHistory = MutableLiveData<List<MovieItem>>()
    val responseHistoryMovie: LiveData<List<MovieItem>>
        get() = _responseHistory

    private val _responseMystery = MutableLiveData<List<MovieItem>>()
    val responseMysteryMovie: LiveData<List<MovieItem>>
        get() = _responseMystery

    private val _responseRomance = MutableLiveData<List<MovieItem>>()
    val responseRomanceMovie: LiveData<List<MovieItem>>
        get() = _responseRomance

    private val _responseScience = MutableLiveData<List<MovieItem>>()
    val responseScienceMovie: LiveData<List<MovieItem>>
        get() = _responseScience

    private val _responseTVMovie = MutableLiveData<List<MovieItem>>()
    val responseTVMovieMovie: LiveData<List<MovieItem>>
        get() = _responseTVMovie

    private val _responseThriller = MutableLiveData<List<MovieItem>>()
    val responseThrillerMovie: LiveData<List<MovieItem>>
        get() = _responseThriller

    private val _responseWar = MutableLiveData<List<MovieItem>>()
    val responseWarMovie: LiveData<List<MovieItem>>
        get() = _responseWar

    private val _responseWestern = MutableLiveData<List<MovieItem>>()
    val responseWesternMovie: LiveData<List<MovieItem>>
        get() = _responseWestern



    init {
        getActionMovies()
        getAdventureMovies()
        getAnimationMovies()
        getComedyMovies()
        getCrimeMovies()
        getDocumentaryMovies()
        getDramaMovies()
        getFamilyMovies()
        getFantasyMovies()
        getHistoryMovies()
        getHorrorMovies()
        getMusicMovies()
        getMysteryMovies()
        getRomanceMovies()
        getScienceMovies()
        getTVMovieMovies()
        getThrillerMovies()
        getWarMovies()
        getWesternMovies()
    }

    private fun getActionMovies() = viewModelScope.launch {
        repository.getActionMovies().let {response ->

            if(response.isSuccessful) {
                val responseBody = response.body()
                //_response.postValue(response.body())

                if (responseBody != null) {
                    _response.postValue(responseBody.results)
                } else {
                    Log.d("tag", "getAllMovies Error: ${response.code()}" )
                }
            } else{
                Log.d("tag", "getAllMovies Error: ${response.code()}" )
            }
        }
    }
    private fun getAdventureMovies() = viewModelScope.launch {
        repository.getAdventureMovies().let {response ->

            if(response.isSuccessful) {
                val responseBody = response.body()
                //_response.postValue(response.body())

                if (responseBody != null) {
                    _responseAdventure.postValue(responseBody.results)
                } else {
                    Log.d("tag", "getAllMovies Error: ${response.code()}" )
                }
            } else{
                Log.d("tag", "getAllMovies Error: ${response.code()}" )
            }
        }
    }
    private fun getAnimationMovies() = viewModelScope.launch {
        repository.getAnimationMovies().let {response ->

            if(response.isSuccessful) {
                val responseBody = response.body()
                //_response.postValue(response.body())

                if (responseBody != null) {
                    _responseAnimation.postValue(responseBody.results)
                } else {
                    Log.d("tag", "getAllMovies Error: ${response.code()}" )
                }
            } else{
                Log.d("tag", "getAllMovies Error: ${response.code()}" )
            }
        }
    }
    private fun getComedyMovies() = viewModelScope.launch {
        repository.getComedyMovies().let {response ->

            if(response.isSuccessful) {
                val responseBody = response.body()
                //_response.postValue(response.body())

                if (responseBody != null) {
                    _responseComedy.postValue(responseBody.results)
                } else {
                    Log.d("tag", "getAllMovies Error: ${response.code()}" )
                }
            } else{
                Log.d("tag", "getAllMovies Error: ${response.code()}" )
            }
        }
    }
    private fun getCrimeMovies() = viewModelScope.launch {
        repository.getCrimeMovies().let {response ->

            if(response.isSuccessful) {
                val responseBody = response.body()
                //_response.postValue(response.body())

                if (responseBody != null) {
                    _responseCrime.postValue(responseBody.results)
                } else {
                    Log.d("tag", "getAllMovies Error: ${response.code()}" )
                }
            } else{
                Log.d("tag", "getAllMovies Error: ${response.code()}" )
            }
        }
    }
    private fun getDocumentaryMovies() = viewModelScope.launch {
        repository.getDocumentaryMovies().let {response ->

            if(response.isSuccessful) {
                val responseBody = response.body()
                //_response.postValue(response.body())

                if (responseBody != null) {
                    _responseDocumentary.postValue(responseBody.results)
                } else {
                    Log.d("tag", "getAllMovies Error: ${response.code()}" )
                }
            } else{
                Log.d("tag", "getAllMovies Error: ${response.code()}" )
            }
        }
    }
    private fun getDramaMovies() = viewModelScope.launch {
        repository.getDramaMovies().let {response ->

            if(response.isSuccessful) {
                val responseBody = response.body()
                //_response.postValue(response.body())

                if (responseBody != null) {
                    _responseDrama.postValue(responseBody.results)
                } else {
                    Log.d("tag", "getAllMovies Error: ${response.code()}" )
                }
            } else{
                Log.d("tag", "getAllMovies Error: ${response.code()}" )
            }
        }
    }
    private fun getFamilyMovies() = viewModelScope.launch {
        repository.getFamilyMovies().let {response ->

            if(response.isSuccessful) {
                val responseBody = response.body()
                //_response.postValue(response.body())

                if (responseBody != null) {
                    _responseFamily.postValue(responseBody.results)
                } else {
                    Log.d("tag", "getAllMovies Error: ${response.code()}" )
                }
            } else{
                Log.d("tag", "getAllMovies Error: ${response.code()}" )
            }
        }
    }
    private fun getFantasyMovies() = viewModelScope.launch {
        repository.getFantasyMovies().let {response ->

            if(response.isSuccessful) {
                val responseBody = response.body()
                //_response.postValue(response.body())

                if (responseBody != null) {
                    _responseFantasy.postValue(responseBody.results)
                } else {
                    Log.d("tag", "getAllMovies Error: ${response.code()}" )
                }
            } else{
                Log.d("tag", "getAllMovies Error: ${response.code()}" )
            }
        }
    }
    private fun getHistoryMovies() = viewModelScope.launch {
        repository.getHistoryMovies().let {response ->

            if(response.isSuccessful) {
                val responseBody = response.body()
                //_response.postValue(response.body())

                if (responseBody != null) {
                    _responseHistory.postValue(responseBody.results)
                } else {
                    Log.d("tag", "getAllMovies Error: ${response.code()}" )
                }
            } else{
                Log.d("tag", "getAllMovies Error: ${response.code()}" )
            }
        }
    }
    private fun getHorrorMovies() = viewModelScope.launch {
        repository.getHorrorMovies().let {response ->

            if(response.isSuccessful) {
                val responseBody = response.body()
                //_response.postValue(response.body())

                if (responseBody != null) {
                    _responseHorror.postValue(responseBody.results)
                } else {
                    Log.d("tag", "getAllMovies Error: ${response.code()}" )
                }
            } else{
                Log.d("tag", "getAllMovies Error: ${response.code()}" )
            }
        }
    }
    private fun getMusicMovies() = viewModelScope.launch {
        repository.getMusicMovies().let {response ->

            if(response.isSuccessful) {
                val responseBody = response.body()
                //_response.postValue(response.body())

                if (responseBody != null) {
                    _responseMusic.postValue(responseBody.results)
                } else {
                    Log.d("tag", "getAllMovies Error: ${response.code()}" )
                }
            } else{
                Log.d("tag", "getAllMovies Error: ${response.code()}" )
            }
        }
    }
    private fun getMysteryMovies() = viewModelScope.launch {
        repository.getMysteryMovies().let {response ->

            if(response.isSuccessful) {
                val responseBody = response.body()
                //_response.postValue(response.body())

                if (responseBody != null) {
                    _responseMystery.postValue(responseBody.results)
                } else {
                    Log.d("tag", "getAllMovies Error: ${response.code()}" )
                }
            } else{
                Log.d("tag", "getAllMovies Error: ${response.code()}" )
            }
        }
    }
    private fun getRomanceMovies() = viewModelScope.launch {
        repository.getRomanceMovies().let {response ->

            if(response.isSuccessful) {
                val responseBody = response.body()
                //_response.postValue(response.body())

                if (responseBody != null) {
                    _responseRomance.postValue(responseBody.results)
                } else {
                    Log.d("tag", "getAllMovies Error: ${response.code()}" )
                }
            } else{
                Log.d("tag", "getAllMovies Error: ${response.code()}" )
            }
        }
    }
    private fun getScienceMovies() = viewModelScope.launch {
        repository.getScienceMovies().let {response ->

            if(response.isSuccessful) {
                val responseBody = response.body()
                //_response.postValue(response.body())

                if (responseBody != null) {
                    _responseScience.postValue(responseBody.results)
                } else {
                    Log.d("tag", "getAllMovies Error: ${response.code()}" )
                }
            } else{
                Log.d("tag", "getAllMovies Error: ${response.code()}" )
            }
        }
    }
    private fun getTVMovieMovies() = viewModelScope.launch {
        repository.getTVMovieMovies().let {response ->

            if(response.isSuccessful) {
                val responseBody = response.body()
                //_response.postValue(response.body())

                if (responseBody != null) {
                    _responseTVMovie.postValue(responseBody.results)
                } else {
                    Log.d("tag", "getAllMovies Error: ${response.code()}" )
                }
            } else{
                Log.d("tag", "getAllMovies Error: ${response.code()}" )
            }
        }
    }
    private fun getThrillerMovies() = viewModelScope.launch {
        repository.getThrillerMovies().let {response ->

            if(response.isSuccessful) {
                val responseBody = response.body()
                //_response.postValue(response.body())

                if (responseBody != null) {
                    _responseThriller.postValue(responseBody.results)
                } else {
                    Log.d("tag", "getAllMovies Error: ${response.code()}" )
                }
            } else{
                Log.d("tag", "getAllMovies Error: ${response.code()}" )
            }
        }
    }
    private fun getWarMovies() = viewModelScope.launch {
        repository.getWarMovies().let {response ->

            if(response.isSuccessful) {
                val responseBody = response.body()
                //_response.postValue(response.body())

                if (responseBody != null) {
                    _responseWar.postValue(responseBody.results)
                } else {
                    Log.d("tag", "getAllMovies Error: ${response.code()}" )
                }
            } else{
                Log.d("tag", "getAllMovies Error: ${response.code()}" )
            }
        }
    }
    private fun getWesternMovies() = viewModelScope.launch {
        repository.getWesternMovies().let {response ->

            if(response.isSuccessful) {
                val responseBody = response.body()
                //_response.postValue(response.body())

                if (responseBody != null) {
                    _responseWestern.postValue(responseBody.results)
                } else {
                    Log.d("tag", "getAllMovies Error: ${response.code()}" )
                }
            } else{
                Log.d("tag", "getAllMovies Error: ${response.code()}" )
            }
        }
    }

}