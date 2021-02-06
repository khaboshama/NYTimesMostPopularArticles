package com.khaled.nytimesmostpopulararticles.model.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.khaled.nytimesmostpopulararticles.model.ArticleItem

/**
 * Data Access Object for the articles table.
 */
@Dao
interface MostPopularArticleDao {
    @Query("SELECT * FROM article")
    fun getMostPopularArticleList(): LiveData<List<ArticleItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg articleItem: ArticleItem)

    @Query("DELETE FROM article")
    suspend fun deleteAll()
}