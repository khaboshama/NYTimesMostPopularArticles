package com.khaled.nytimesmostpopulararticles.model.network.end_points

import com.khaled.nytimesmostpopulararticles.model.response.ArticleListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MostPopularArticleApi {

    @GET("mostviewed/all-sections/{period}.json")
    suspend fun getMostPopularArticles(
        @Path("period") period: Int,
        @Query("api-key") apiKey: String
    ): ArticleListResponse
}