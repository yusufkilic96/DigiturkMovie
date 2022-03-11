package com.example.digiturkmovie.api

import com.example.digiturkmovie.helper.Constants
import com.example.digiturkmovie.models.MovieResponse
import com.example.digiturkmovie.models.genre
import retrofit2.Response
import retrofit2.http.GET

interface APIService {

    @GET(Constants.END_POINT+"28")
    suspend fun getActionMovies():Response<MovieResponse>

    @GET(Constants.END_POINT+"12")
    suspend fun getAdventureMovies():Response<MovieResponse>

    @GET(Constants.END_POINT+"16")
    suspend fun getAnimationMovies():Response<MovieResponse>

    @GET(Constants.END_POINT+"35")
    suspend fun getComedyMovies():Response<MovieResponse>

    @GET(Constants.END_POINT+"80")
    suspend fun getCrimeMovies():Response<MovieResponse>

    @GET(Constants.END_POINT+"99")
    suspend fun getDocumentaryMovies():Response<MovieResponse>

    @GET(Constants.END_POINT+"18")
    suspend fun getDramaMovies():Response<MovieResponse>

    @GET(Constants.END_POINT+"10751")
    suspend fun getFamilyMovies():Response<MovieResponse>

    @GET(Constants.END_POINT+"14")
    suspend fun getFantasyMovies():Response<MovieResponse>

    @GET(Constants.END_POINT+"27")
    suspend fun getHorrorMovies():Response<MovieResponse>

    @GET(Constants.END_POINT+"10402")
    suspend fun getMusicMovies():Response<MovieResponse>

    @GET(Constants.END_POINT+"36")
    suspend fun getHistoryMovies():Response<MovieResponse>

    @GET(Constants.END_POINT+"9648")
    suspend fun getMysteryMovies():Response<MovieResponse>

    @GET(Constants.END_POINT+"10749")
    suspend fun getRomanceMovies():Response<MovieResponse>

    @GET(Constants.END_POINT+"878")
    suspend fun getScienceMovies():Response<MovieResponse>

    @GET(Constants.END_POINT+"10770")
    suspend fun getTVMovieMovies():Response<MovieResponse>

    @GET(Constants.END_POINT+"53")
    suspend fun getThrillerMovies():Response<MovieResponse>

    @GET(Constants.END_POINT+"10752")
    suspend fun getWarMovies():Response<MovieResponse>

    @GET(Constants.END_POINT+"37")
    suspend fun getWesternMovies():Response<MovieResponse>





    suspend fun getGenres():Response<genre>

}