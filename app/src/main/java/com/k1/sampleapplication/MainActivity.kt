package com.k1.sampleapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MessageCard(Message("Hello, Android!", "Jetpack Compose"))
        }

    }

}

data class Message(
    val title: String, val body: String
)

@Composable
fun MessageCard(message: Message) {
    Image(painter = painterResource(id = R.drawable.ic_launcher_foreground) , contentDescription = null)
    Column {
        Text(text = message.title, style = MaterialTheme.typography.titleLarge)
        Text(text = message.body, style = MaterialTheme.typography.bodyMedium)
    }
}

@Preview
@Composable
fun PreviewMessageCard() {
    MessageCard(Message("Hello, Android!", "Jetpack Compose"))
}

