package com.k1.sampleapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.k1.sampleapplication.ui.SampleApplicationTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SampleApplicationTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    MessageCard(Message("Hello, Android!", "Jetpack Compose"))
                }
            }
        }
    }
}

data class Message(
    val title: String, val body: String
)

@Composable
fun MessageCard(message: Message) {
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
            Text(text = message.title, style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.width(4.dp))
            Text(text = message.body, style = MaterialTheme.typography.bodyMedium)
        }
    }
}

@Preview
@Composable
fun PreviewMessageCard() {
    SampleApplicationTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            MessageCard(Message("Hello, Android!", "Jetpack Compose"))

        }
    }
}

