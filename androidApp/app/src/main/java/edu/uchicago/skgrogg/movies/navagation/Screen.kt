package edu.uchicago.skgrogg.movies.navagation

import edu.uchicago.skgrogg.movies.R


sealed class Screen(var route: String, var icon: Int, var title: String) {
    object Search : Screen("search", R.drawable.ic_search, "Search")
    object Detail : Screen("detail", 0, "Detail")
    object Favorites : Screen("favorites", R.drawable.ic_favorite, "Favorites")
    object Contact : Screen("contact", R.drawable.ic_contact, "Contact")

}