package com.k1.shelves.feature.books.data

import com.google.gson.annotations.SerializedName

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