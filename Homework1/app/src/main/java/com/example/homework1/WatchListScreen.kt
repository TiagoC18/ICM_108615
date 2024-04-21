package com.example.homework1


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun WatchListScreen(
    modifier: Modifier = Modifier,
    watchListViewModel: WatchListViewModel = viewModel()
) {
    val watchList = watchListViewModel.watchList

    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "My Watch List",
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            AddWatchItem(
                onAddItem = { watchItem ->
                    watchListViewModel.addWatchItem(watchItem)
                }
            )




            LazyColumn {
                items(watchList) { item ->
                    WatchListItemComposable(
                        watchListItem = item,
                        onToggleWatchedStatus = { watchListViewModel.changeWatched(item, it.watched) },
                        onRemoveItem = { watchListViewModel.remove(item) }
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }
}