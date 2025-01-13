package com.example.sebbianewsapp.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.sebbianewsapp.presentation.Screen.BriefScreen
import com.example.sebbianewsapp.presentation.Screen.CategoryScreen
import com.example.sebbianewsapp.presentation.Screen.DetailsScreen

sealed class Route{
    data class CategoryScreen(val name: String = "Category") : Route()
    data class BriefScreen(val name: String ="Brief") : Route()
    data class DetailScreen(val name: String = "Detail") : Route()
}

@Suppress("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MyNavigation(
    navController: NavHostController
) {

        NavHost(
            navController = navController,
            startDestination = "category"
        ){

            navigation(startDestination = Route.CategoryScreen().name, route = "category") {
                composable(route = Route.CategoryScreen().name) {
                    CategoryScreen(
                        onBriefNews = { id ->
                            navController.navigate("brief/$id")
                        }
                    )
                }

                composable(route = Route.BriefScreen().name + "/{id}") { backStackEntry ->
                    val id = backStackEntry.arguments?.getString("id")?.toLongOrNull() ?: 0L
                    BriefScreen(id, onDetailsScreen = { detailsId ->
                        navController.navigate("news_detail/$detailsId")
                    })
                }

                composable(route = Route.DetailScreen().name+ "/{id}") { backStackEntry ->
                    val id = backStackEntry.arguments?.getString("id")?.toLongOrNull() ?: 0L
                    DetailsScreen(id)
                }
            }
        }
}


