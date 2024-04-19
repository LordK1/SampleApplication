package com.k1.shelves.feature.books.di

import com.k1.shelves.feature.books.data.BooksApiImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object NetworkDi {

    @Provides
    fun provideBooksApiImpl() = BooksApiImpl()
}