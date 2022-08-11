package edu.uchicago.skgrogg.movies.screens.favorites.paging

data class PaginateFavorites(
    val page: Int = 1,
    val primary_release_year: String = "",
)
