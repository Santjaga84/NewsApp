package com.example.newsapp.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.newsapp.models.Article

//Интерфейс получает,вставляет или удаляет статью
@Dao
interface ArticleDao {
    @Query("SELECT * FROM articles")
    fun getAllArticles(): List<Article>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(article: Article)

    @Delete
    suspend fun delete(article: Article)
}