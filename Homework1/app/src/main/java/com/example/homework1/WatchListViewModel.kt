package com.example.homework1


import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class WatchListViewModel : ViewModel() {
    private val _watchList = mutableStateListOf<WatchItem>().apply {
        addAll(getInitialWatchList())
    }
    val watchList: List<WatchItem> = _watchList

    fun remove(item: WatchItem) {
        _watchList.remove(item)
    }

    fun changeWatched(item: WatchItem, watched: Boolean) {
        val index = _watchList.indexOfFirst { it.id == item.id }
        if (index != -1) {
            val newItem = item.copy(watched = watched)
            _watchList[index] = newItem
        }
    }


    fun addWatchItem(item: WatchItem) {
        _watchList.add(item)
    }
}

private fun getInitialWatchList() : List<WatchItem> {
    return listOf(
        WatchItem(1, "Blade Runner 2049", false),
        WatchItem(2, "Inception", false),
        WatchItem(3, "Interstellar", false),
        WatchItem(4, "Parasite", false),
        WatchItem(5, "Arrival", false),
        WatchItem(6, "Mad Max: Fury Road", false),
        WatchItem(7, "La La Land", false),
        WatchItem(8, "Moonlight", false),
        WatchItem(9, "Her", false),
        WatchItem(10, "The Grand Budapest Hotel", false)
    )
}