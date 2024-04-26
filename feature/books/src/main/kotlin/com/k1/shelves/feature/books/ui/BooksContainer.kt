package com.k1.shelves.feature.books.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.k1.shelves.feature.books.data.Book

@Composable
fun BooksContainer(title: String, body: String, books: List<Book>) {
    Column {
        // Header
        Row(modifier = Modifier
            .padding(8.dp)
            .padding(4.dp, 8.dp)) {
            Image(
                painter = painterResource(id = com.google.android.material.R.drawable.ic_clock_black_24dp),
                contentDescription = "Some Image",
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(
                    text = title, style = MaterialTheme.typography.titleLarge
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = body, style = MaterialTheme.typography.bodyMedium
                )
            }
        }
        Spacer(modifier = Modifier.width(18.dp))
        // Body
        LazyColumn {
            items(books) { item ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Text(
                        text = item.title,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp, 4.dp),
                        fontSize = 18.sp,
                        fontStyle = MaterialTheme.typography.titleMedium.fontStyle
                    )
                    Text(
                        text = item.author,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp, 4.dp),
                        fontSize = 14.sp,
                        fontStyle = MaterialTheme.typography.bodyMedium.fontStyle
                    )
                    Text(
                        text = item.genre,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp, 4.dp),
                        fontSize = 12.sp,
                        fontStyle = MaterialTheme.typography.bodyMedium.fontStyle
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewBooksPage() {
    // TODO : move it to core common ui
//    ShelvesTheme {
//        BooksContainer("Hello, Android!", "Jetpack Compose", emptyList())
//    }
}