package com.joel.domain.model

enum class Rating(
    val desc : String,
    val rating : String
) {
    PG(
        desc = "children",
        rating = "pg"
    ),
    G(
        desc = "all ages",
        rating = "g"
    ),
    PG13(
        desc = "Teens 13 or older",
        rating = "pg13"
    ),
    R17(
        desc = "17+ (violence & profanity)",
        rating = "r17"
    ),
    R(
        desc = "Mild Nudity",
        rating = "r"
    ),
    RX(
        desc = "Hentai",
        rating = "rx"
    )
}