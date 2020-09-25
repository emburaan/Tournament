package com.example.tournament.login.dashboard.model

data class TournamentModel(
    val msg: String,
    val success: Boolean,
    val tournaments: List<Tournament>
)