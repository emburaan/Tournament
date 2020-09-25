package com.example.tournament.network

import com.example.tournament.login.dashboard.model.Tournament
import com.example.tournament.login.dashboard.model.TournamentModel
import io.reactivex.Observable
import retrofit2.http.GET




interface TournamentApi {
    @GET("tournament")
    fun getPosts(): Observable<TournamentModel>?
}