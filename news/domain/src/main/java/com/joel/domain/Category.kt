package com.joel.domain

enum class NewsCategory(val displayName: String) {
    BUSINESS("business"),
    CRIME("crime"),
    DOMESTIC("domestic"),
    EDUCATION("education"),
    ENTERTAINMENT("entertainment"),
    ENVIRONMENT("environment"),
    FOOD("food"),
    HEALTH("health"),
    LIFESTYLE("lifestyle"),
    OTHER("other"),
    POLITICS("politics"),
    SCIENCE("science"),
    SPORTS("sports"),
    TECHNOLOGY("technology"),
    TOP("top"),
    TOURISM("tourism"),
    WORLD("world");

    companion object {
        fun fromDisplayName(displayName: String): NewsCategory? {
            return values().find { it.displayName == displayName }
        }
    }
}
