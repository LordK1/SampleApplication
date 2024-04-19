package com.k1.shelves.feature.books.domain

import com.k1.shelves.feature.books.data.BooksRepository
import javax.inject.Inject

class GetBooksUseCase @Inject constructor(
    private val repository: BooksRepository
) {
    suspend operator fun invoke() = repository.getBooks()
}