package com.example.sebbianewsapp.data.dto

import com.google.gson.annotations.SerializedName

data class ResponseCategoriesDto(
    @SerializedName("code") val code: Int?,
    @SerializedName("list") val list: List<CategoriesDto?>?,
)
