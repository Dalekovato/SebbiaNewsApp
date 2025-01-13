package com.example.sebbianewsapp.data

import android.util.Log
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

        return try {
            val page = params.key ?: 0
            val response = iNewsApiService.getCategoriesNews(id, page).body()?.list?.mapNotNull {
                BriefMapper(it).briefMapper
            } ?: emptyList()

            // Если список пустой, возвращаем пустую страницу
            if (response.isEmpty()) {
                LoadResult.Page(
                    data = emptyList(),
                    nextKey = null,
                    prevKey = if (page == 0) null else page - 1
                )
            } else {
                val nextPage = if (response.size < params.loadSize) null else page + 1
                LoadResult.Page(
                    data = response,
                    nextKey = nextPage,
                    prevKey = if (page == 0) null else page - 1
                )
            }
        } catch (e: HttpException) {
            LoadResult.Error(e)
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}


