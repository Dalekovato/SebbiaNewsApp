package com.example.sebbianewsapp.data.dto

import com.google.gson.annotations.SerializedName

data class ResponseBriefNewsDto(

    @SerializedName("code") val code : Int?,
    @SerializedName("list")val list: List<BriefNewsDto?>?,

    )
