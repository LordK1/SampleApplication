package com.k1.shelves.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HomeScreen(viewModel: BooksViewModel = hiltViewModel()) {
    val books by viewModel.books.observeAsState()

    LaunchedEffect(viewModel) {
        viewModel.fetchBooks()
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
    ) {
        BooksContainer(
            title = viewModel.header.title,
            body = viewModel.header.body,
            books = books.orEmpty()
        )
    }
}