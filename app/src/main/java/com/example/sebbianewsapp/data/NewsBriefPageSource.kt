package com.example.sebbianewsapp.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.sebbianewsapp.domain.mapper.BriefMapper
import com.example.sebbianewsapp.domain.model.BriefNewsDomain
import retrofit2.HttpException
import javax.inject.Inject

class NewsBriefPageSource @Inject constructor(
    private val iNewsApiService: INewsApiService,
    private val id: Long,
) : PagingSource<Int, BriefNewsDomain>() {

    override fun getRefreshKey(state: PagingState<Int, BriefNewsDomain>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, BriefNewsDomain> {

        return   try {

            val page = params.key?: 0
            val response = iNewsApiService.getCategoriesNews(id, page).body()?.list?.mapNotNull {
                BriefMapper(it).briefMapper
            } ?: emptyList()


            val nextPage = if (response.isEmpty() == true) null else response.size.plus(page).plus(1)
            val prevPage = if (page == 1 ) null else response.size.minus(10)

            LoadResult.Page(
                data = response,
                nextKey = nextPage,
                prevKey = prevPage
            )

        }catch (e: HttpException) {
            return LoadResult.Error(e)
        } catch (e: Exception) {
            return LoadResult.Error(e)
        }

    }


}