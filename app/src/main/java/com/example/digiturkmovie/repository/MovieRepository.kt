package com.example.digiturkmovie.repository

import com.example.digiturkmovie.api.APIService
import javax.inject.Inject

class MovieRepository
@Inject
constructor(private val apiService: APIService){

    suspend fun getActionMovies() = apiService.getActionMovies()
    suspend fun getAdventureMovies() = apiService.getAdventureMovies()
    suspend fun getAnimationMovies() = apiService.getAnimationMovies()
    suspend fun getComedyMovies() = apiService.getComedyMovies()
    suspend fun getCrimeMovies() = apiService.getCrimeMovies()
    suspend fun getDocumentaryMovies() = apiService.getDocumentaryMovies()
    suspend fun getDramaMovies() = apiService.getDramaMovies()
    suspend fun getFamilyMovies() = apiService.getFamilyMovies()
    suspend fun getFantasyMovies() = apiService.getFantasyMovies()
    suspend fun getHistoryMovies() = apiService.getHistoryMovies()
    suspend fun getHorrorMovies() = apiService.getHorrorMovies()
    suspend fun getMusicMovies() = apiService.getMusicMovies()
    suspend fun getMysteryMovies() = apiService.getMysteryMovies()
    suspend fun getRomanceMovies() = apiService.getRomanceMovies()
    suspend fun getScienceMovies() = apiService.getScienceMovies()
    suspend fun getTVMovieMovies() = apiService.getTVMovieMovies()
    suspend fun getThrillerMovies() = apiService.getThrillerMovies()
    suspend fun getWarMovies() = apiService.getWarMovies()
    suspend fun getWesternMovies() = apiService.getWesternMovies()



}