package com.example.newsapp.data.api

import com.example.newsapp.data.db.ArticleDao
import com.example.newsapp.models.Article
import javax.inject.Inject

class  NewsRepository @Inject constructor
    (private val newsService: NewsService,
     private val articleDao: ArticleDao
     ) {

    suspend fun getNews (countryCode: String, pageNumber: Int) =
        newsService.getHeadLines(countryCode = countryCode, page = pageNumber)

    suspend fun getSearchNews(query: String, pageNumber: Int) =
        newsService.getEverything(query = query, page = pageNumber)

    fun getFavoriteArticles() = articleDao.getAllArticles()

    suspend fun addToFavorite(article: Article) = articleDao.insert(article = article)

    suspend fun deleteFavorite(article: Article) = articleDao.delete(article = article)
    }