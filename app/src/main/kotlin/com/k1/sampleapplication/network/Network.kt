package com.k1.sampleapplication.network

import com.google.gson.annotations.SerializedName
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import javax.inject.Inject

class Network @Inject constructor() {
    private val retrofit = Retrofit.Builder().baseUrl("https://random-data-api.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(NetworkApi::class.java)

    suspend fun getBooks() = retrofit.getBooks()
}

interface NetworkApi {

    @Headers("X-API-Key: K8p4ApG2NO-riCbDY_oNnw")
    @GET("api/v3/projects/11297a67-c14e-4329-b01d-db1a44b00cd7")
    suspend fun getBooks(): BookList

}

data class BookList(
    val books: List<Book>
)

data class Book(
    @SerializedName("book_title")
    val title: String,
    @SerializedName("book_author")
    val author: String,
    @SerializedName("book_genre")
    val genre: String,
    @SerializedName("book_description")
    val description: String
)