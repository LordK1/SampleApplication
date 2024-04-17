package com.k1.shelves.data

import com.k1.shelves.network.Network
import javax.inject.Inject

class BooksRepository @Inject constructor(private val network: Network) {
    suspend fun getBooks() = network.getBooks()
}