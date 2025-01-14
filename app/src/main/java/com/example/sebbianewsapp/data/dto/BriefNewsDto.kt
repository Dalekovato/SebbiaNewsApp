package com.example.sebbianewsapp.data.dto

import com.google.gson.annotations.SerializedName

data class BriefNewsDto(
    @SerializedName("id") val id: Int?,
    @SerializedName("title") val title: String?,
    @SerializedName("date") val date: String?,
    @SerializedName("shortDescription") val shortDescription: String?,
)
