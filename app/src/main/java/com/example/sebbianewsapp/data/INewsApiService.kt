package com.example.sebbianewsapp.data

import com.example.sebbianewsapp.data.dto.ResponseBriefNewsDto
import com.example.sebbianewsapp.data.dto.ResponseCategoriesDto
import com.example.sebbianewsapp.data.dto.ResponseDetailsDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface INewsApiService {


    @GET("v1/news/categories")//Категории
    suspend fun getAllCategories(): Response<ResponseCategoriesDto>

    @GET("v1/news/categories/{id}/news")//Список кратких новостей
    suspend fun getCategoriesNews(
        @Path("id") id: Long,
        @Query("page") page: Int = 0
    ): Response<ResponseBriefNewsDto>

    @GET("v1/news/details")//Полная новость
    suspend fun getNews(
        @Query("id") id: Long
    ): Response<ResponseDetailsDto>



}