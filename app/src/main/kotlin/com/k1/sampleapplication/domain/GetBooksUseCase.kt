package com.k1.sampleapplication.domain

import com.k1.sampleapplication.data.BooksRepository
import javax.inject.Inject

class GetBooksUseCase @Inject constructor(private val repository: BooksRepository) {
    suspend operator fun invoke() = repository.getBooks()
}