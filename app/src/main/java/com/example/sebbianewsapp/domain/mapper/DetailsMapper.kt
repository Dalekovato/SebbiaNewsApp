package com.example.sebbianewsapp.domain.mapper

import com.example.sebbianewsapp.data.dto.NewsDetailsDto
import com.example.sebbianewsapp.domain.model.DetailsDomain

class DetailsMapper(newsDetailsDto: NewsDetailsDto?) {

    val detailsMapper by lazy {
        DetailsDomain(
            id = newsDetailsDto?.id ?: 0,
            title = newsDetailsDto?.title.orEmpty(),
            shortDescription = newsDetailsDto?.shortDescription.orEmpty(),
            fullDescription = newsDetailsDto?.fullDescription.orEmpty(),
            date = newsDetailsDto?.date.orEmpty(),
        )
    }

}