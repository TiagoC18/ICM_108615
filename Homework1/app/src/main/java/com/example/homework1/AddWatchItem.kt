package com.example.homework1

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AddWatchItem(onAddItem: (WatchItem) -> Unit) {
    var title by remember { mutableStateOf("") }

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        color = MaterialTheme.colorScheme.background,
        shadowElevation = 4.dp
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            TextField(
                value = title,
                onValueChange = { title = it },
                label = { Text("Enter a title to watch") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    if (title.isNotBlank()) {
                        onAddItem(WatchItem(id = System.currentTimeMillis().toInt(), title = title, watched = false))
                        title = ""
                    }
                },
                        colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary
                ),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .width(120.dp)
                    .height(48.dp)
            ) {
                Text(
                    "Add",
                    fontSize = 16.sp,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
        }
    }
}
