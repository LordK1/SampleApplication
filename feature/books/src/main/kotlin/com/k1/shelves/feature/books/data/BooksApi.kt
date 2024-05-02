package com.k1.shelves.feature.books.data

import com.k1.shelves.feature.books.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import javax.inject.Inject

class BooksApiImpl @Inject constructor() {
    private val retrofit = Retrofit.Builder().baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(BooksApi::class.java)

    suspend fun getBooks() = retrofit.getBooks()
}

interface BooksApi {

    @Headers("X-API-Key: ${BuildConfig.API_KEY}")
    @GET("api/v3/projects/11297a67-c14e-4329-b01d-db1a44b00cd7")
    suspend fun getBooks(): BookList

}

data class BookList(
    val books: List<Book>
)

