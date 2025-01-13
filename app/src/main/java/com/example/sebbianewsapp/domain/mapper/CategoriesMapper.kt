package com.example.sebbianewsapp.domain.mapper

import com.example.sebbianewsapp.data.dto.CategoriesDto
import com.example.sebbianewsapp.domain.model.CategoriesDomain

class CategoriesMapper(categoriesDto: CategoriesDto) {

    val categoriesMapper by lazy{
        CategoriesDomain(
            id = categoriesDto.id ?:0 ,
            name = categoriesDto.name.orEmpty(),
        )
    }


}