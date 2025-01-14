package com.example.sebbianewsapp.domain.mapper

import com.example.sebbianewsapp.data.dto.ResponseDetailsDto
import com.example.sebbianewsapp.domain.model.DetailsResponseDomain

class DetailsResponseMapper(responseDetailsDto: ResponseDetailsDto) {

    val detailsResponseMapper by lazy {

        DetailsResponseDomain(
            code = responseDetailsDto.code ?: 0,
            news = DetailsMapper(responseDetailsDto.news).detailsMapper
        )

    }
}