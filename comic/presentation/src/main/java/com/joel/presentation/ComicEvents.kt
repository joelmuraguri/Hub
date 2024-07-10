package com.joel.presentation

import com.joel.domain.model.Character
import com.joel.domain.model.Comic
import com.joel.domain.model.ComicInfo

sealed class ComicEvents {
    data class OnCharacterClick(val character : Character) : ComicEvents()
    data class OnVolumeClick(val volume : ComicInfo.Volume) : ComicEvents()
    data class OnComicClick(val comic : Comic) : ComicEvents()
}