package com.example.homework1

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Icon

@Composable
fun WatchListItemComposable(
    watchListItem: WatchItem,
    onToggleWatchedStatus: (WatchItem) -> Unit,
    onRemoveItem: (WatchItem) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (watchListItem.watched) Color(0xFFE1F5FE) else Color(0xFFFFFFFF)
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(all = 16.dp)
        ) {
            Checkbox(
                checked = watchListItem.watched,
                onCheckedChange = { onToggleWatchedStatus(watchListItem.copy(watched = it)) },
                colors = CheckboxDefaults.colors(
                    checkedColor = MaterialTheme.colorScheme.primary,
                    uncheckedColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f),
                    checkmarkColor = MaterialTheme.colorScheme.onPrimary
                )
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = watchListItem.title,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.weight(1f)
            )
            IconButton(onClick = { onRemoveItem(watchListItem) }) {
                Icon(Icons.Filled.Delete, contentDescription = "Delete")
            }
        }
    }
}