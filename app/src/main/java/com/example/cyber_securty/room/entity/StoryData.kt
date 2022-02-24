package com.example.cyber_securty.room.entity

import androidx.room.Entity

@Entity
data class StoryData(
    val id: Int,
    val audioText: String,
    val audioUrl: String
)