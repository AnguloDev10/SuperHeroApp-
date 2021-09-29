package com.example.superhero

sealed class Routes (val route: String) {
    object Heroes : Routes("Heroes")
    object Detail : Routes("Detail") {
        const val routeWithArgument = "Detail/{heroId}"
        const val argument = "heroId"
    }
}