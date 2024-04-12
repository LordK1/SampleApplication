package com.k1.sampleapplication.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import com.k1.sampleapplication.domain.GetBooksUseCase
import com.k1.sampleapplication.network.Book
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BooksViewModel @Inject constructor(
    private val getBooksUseCase: GetBooksUseCase,
) : ViewModel() {
    val message = Message("Hello, Android!", "Jetpack Compose")

    private val _books = MutableLiveData<List<Book>>()
    val books : LiveData<List<Book>> = _books

    fun fetchBooks() = viewModelScope.launch {
        val bookList = getBooksUseCase.invoke()
        _books.value = bookList.books
    }
}

data class Message(
    val title: String, val body: String
)