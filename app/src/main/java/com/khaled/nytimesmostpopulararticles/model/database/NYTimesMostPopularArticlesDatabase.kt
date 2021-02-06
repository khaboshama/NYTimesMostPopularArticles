package com.khaled.nytimesmostpopulararticles.model.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.khaled.nytimesmostpopulararticles.constant.Constants
import com.khaled.nytimesmostpopulararticles.model.ArticleItem

@Database(entities = [ArticleItem::class], version = 1)
abstract class NYTimesMostPopularArticlesDatabase : RoomDatabase() {

    abstract fun getArticleDAO(): MostPopularArticleDao

    companion object {
        private val sLock = Any()
        private var instance: NYTimesMostPopularArticlesDatabase? = null

        fun getInstance(context: Context): NYTimesMostPopularArticlesDatabase? {
            synchronized(sLock) {
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        NYTimesMostPopularArticlesDatabase::class.java, Constants.DATABASE_NAME
                    ).build()
                }
                return instance
            }
        }
    }
}