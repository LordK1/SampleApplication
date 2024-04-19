package com.k1.shelves.feature.books.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.k1.shelves.feature.books.data.Book
import com.k1.shelves.feature.books.data.Header
import com.k1.shelves.feature.books.domain.GetBooksUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BooksViewModel @Inject constructor(
    private val getBooksUseCase: GetBooksUseCase,
) : ViewModel() {
    val header = Header("Today in Android", "Jetpack Compose")

    private val _books = MutableLiveData<List<Book>>()
    val books: LiveData<List<Book>> = _books

    fun fetchBooks() = viewModelScope.launch {
        val bookList = getBooksUseCase()
        _books.value = bookList.books
    }
}

