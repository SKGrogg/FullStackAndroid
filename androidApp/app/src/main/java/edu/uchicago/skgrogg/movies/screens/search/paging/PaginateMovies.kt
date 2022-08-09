package edu.uchicago.skgrogg.favs.models

data class PaginateMovies(
    val page: Int = 1,
    val primary_release_year: String = "",
)
