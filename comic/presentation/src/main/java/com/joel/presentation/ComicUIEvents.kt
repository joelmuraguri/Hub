package com.joel.presentation


sealed class ComicUIEvents {
    data class Navigate(val route : String) : ComicUIEvents()
    data object PopBackStack : ComicUIEvents()
    data class SnackBar(val message : String, val action : String?= null) : ComicUIEvents()
}