package com.hasanshukurov.breakingnewsapp.di

import android.content.Context
import androidx.room.Room
import com.hasanshukurov.breakingnewsapp.api.NewsApi
import com.hasanshukurov.breakingnewsapp.db.ArticleDao
import com.hasanshukurov.breakingnewsapp.db.ArticleDatabase
import com.hasanshukurov.breakingnewsapp.repo.NewsRepository
import com.hasanshukurov.breakingnewsapp.util.Constants.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun injectApi():NewsApi {

        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)

        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        return retrofit.create(NewsApi::class.java)

    }

/*
    @Provides
    @Singleton
    fun injectRepo(api: NewsApi,db: ArticleDao) = NewsRepository(api,db)

    @Provides
    @Singleton
    fun injectDataBase(@ApplicationContext context: Context) = Room
        .databaseBuilder(context,ArticleDatabase::class.java,"articleDB")
        .build()


    @Provides
    @Singleton
    fun injectDao(db: ArticleDatabase) =
        db.articleDao()


 */




}