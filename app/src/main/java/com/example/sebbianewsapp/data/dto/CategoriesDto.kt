package com.example.sebbianewsapp.data.dto

import com.google.gson.annotations.SerializedName

data class CategoriesDto(
    @SerializedName("id") val id: Int?,
    @SerializedName("name") val name: String?,
)
