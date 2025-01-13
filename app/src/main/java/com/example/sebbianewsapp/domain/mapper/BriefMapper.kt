package com.example.sebbianewsapp.domain.mapper

import com.example.sebbianewsapp.data.dto.BriefNewsDto

class BriefMapper(briefNewsDto : BriefNewsDto?) {

    val briefMapper by lazy{
        com.example.sebbianewsapp.domain.model.BriefNewsDomain(
            id = briefNewsDto?.id ?: 0,
            title = briefNewsDto?.title.orEmpty(),
            shortDescription = briefNewsDto?.shortDescription.orEmpty(),
            date = briefNewsDto?.date.orEmpty()
        )
    }

}