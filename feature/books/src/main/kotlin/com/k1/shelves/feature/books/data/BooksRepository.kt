package com.k1.shelves.feature.books.data

import javax.inject.Inject

class BooksRepository @Inject constructor(private val booksApiImpl: BooksApiImpl) {
    suspend fun getBooks() = booksApiImpl.getBooks()
}