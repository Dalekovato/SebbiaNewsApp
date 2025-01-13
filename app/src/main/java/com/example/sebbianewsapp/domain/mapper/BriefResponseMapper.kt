package com.example.sebbianewsapp.domain.mapper

import com.example.sebbianewsapp.data.dto.ResponseBriefNewsDto
import com.example.sebbianewsapp.domain.model.BriefResponseNewsDomain

class BriefResponseMapper(responseBriefNewsDto : ResponseBriefNewsDto) {

    val briefResponseMapper by lazy {

        BriefResponseNewsDomain(
            code = responseBriefNewsDto.code ?: 0 ,
            list = responseBriefNewsDto.list?.mapNotNull {
                it?.let {
                    BriefMapper(it).briefMapper
                }
            } ?: emptyList()
        )

    }

}