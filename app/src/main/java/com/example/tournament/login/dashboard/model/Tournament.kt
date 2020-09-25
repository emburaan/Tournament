package com.example.tournament.login.dashboard.model

data class Tournament(
    val __v: Int,
    val _id: String,
    val createdDate: String,
    val endDate: String,
    val endTime: String,
    val games: String,
    val image: String,
    val platform: String,
    val prizepool: List<Prizepool>,
    val rules: String,
    val startDate: String,
    val startTime: String,
    val team: String,
    val totalParticipant: Int,
    val totalPrize: Int,
    val updatedDate: Any
)