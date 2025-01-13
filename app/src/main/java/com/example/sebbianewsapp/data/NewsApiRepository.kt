package com.example.sebbianewsapp.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.sebbianewsapp.data.dto.NewsDetailsDto
import com.example.sebbianewsapp.data.dto.ResponseBriefNewsDto
import com.example.sebbianewsapp.data.dto.ResponseCategoriesDto
import com.example.sebbianewsapp.data.dto.ResponseDetailsDto
import com.example.sebbianewsapp.domain.mapper.BriefResponseMapper
import com.example.sebbianewsapp.domain.mapper.CategoriesResponseMapper
import com.example.sebbianewsapp.domain.mapper.DetailsResponseMapper
import com.example.sebbianewsapp.domain.model.BriefNewsDomain
import com.example.sebbianewsapp.domain.model.BriefResponseNewsDomain
import com.example.sebbianewsapp.domain.model.CategoriesResponseDomain
import com.example.sebbianewsapp.domain.model.DetailsResponseDomain
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import javax.inject.Inject

class NewsApiRepository @Inject constructor(
    private val iNewsApiService: INewsApiService,
) {

    suspend fun getAllCategories(): Response<CategoriesResponseDomain> {

        val response = iNewsApiService.getAllCategories()

        return Response.success(
           CategoriesResponseMapper(
               response.body()?:ResponseCategoriesDto(0, emptyList())
           ).categoriesResponseMapper
        )

    }


     fun getCategoriesNews(id: Long) : Flow<PagingData<BriefNewsDomain>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {NewsBriefPageSource(iNewsApiService,id) }).flow

    }


    suspend fun getNews(id: Long) : Response<DetailsResponseDomain>{
        val response = iNewsApiService.getNews(id)
        val defaultNews = NewsDetailsDto(0,"","","","")

        return Response.success(
            DetailsResponseMapper(
                response.body()?: ResponseDetailsDto(0, news = defaultNews)
            ).detailsResponseMapper
        )

    }





}


