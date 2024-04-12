package com.k1.sampleapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.k1.sampleapplication.ui.BooksViewModel
import com.k1.sampleapplication.ui.SampleApplicationTheme

@Composable
fun BooksScreen(viewModel: BooksViewModel = hiltViewModel()) {
    val books by viewModel.books.observeAsState(emptyList())

    LaunchedEffect(viewModel) {
        viewModel.fetchBooks()
    }
    Box(
        modifier =
        Modifier
            .fillMaxSize()
            .fillMaxHeight()
            .padding(8.dp)
    ) {
        // Header
        Row(modifier = Modifier.padding(8.dp)) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "Some Image",
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(text = viewModel.message.title, style = MaterialTheme.typography.titleLarge)
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = viewModel.message.body, style = MaterialTheme.typography.bodyMedium)
            }
        }
        Spacer(modifier = Modifier.width(18.dp))
        // Body
        LazyColumn {
            items(books) { item ->
                Text(text = item.toString())
            }
        }
    }
}

@Preview
@Composable
fun PreviewMessageCard() {
    SampleApplicationTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
//            BooksScreen(BooksViewModel())
        }
    }
}