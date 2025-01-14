package com.example.sebbianewsapp.data.dto

import com.google.gson.annotations.SerializedName

data class ResponseDetailsDto(
    @SerializedName("code") val code: Int?,
    @SerializedName("news") val news: NewsDetailsDto?,
)
