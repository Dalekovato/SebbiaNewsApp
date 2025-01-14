package com.example.sebbianewsapp.domain.mapper

import com.example.sebbianewsapp.data.dto.ResponseCategoriesDto
import com.example.sebbianewsapp.domain.model.CategoriesResponseDomain

class CategoriesResponseMapper(responseCategoriesDto: ResponseCategoriesDto) {

    val categoriesResponseMapper by lazy {
        CategoriesResponseDomain(
            code = responseCategoriesDto.code ?: 0,
            list = responseCategoriesDto.list?.mapNotNull {
                it?.let {
                    CategoriesMapper(it).categoriesMapper
                }
            } ?: emptyList()
        )
    }

}