package com.k1.sampleapplication.data

import com.k1.sampleapplication.network.Network
import javax.inject.Inject

class BooksRepository @Inject constructor(private val network: Network) {
    suspend fun getBooks() = network.getBooks()
}