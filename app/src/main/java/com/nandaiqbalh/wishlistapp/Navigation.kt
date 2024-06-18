package com.nandaiqbalh.wishlistapp

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.nandaiqbalh.wishlistapp.ui.AddEditDetailView
import com.nandaiqbalh.wishlistapp.ui.HomeView

@Composable
fun Navigation(
	viewModel: WishViewModel = viewModel(),
	navController: NavHostController = rememberNavController(),
) {

	NavHost(
		navController = navController,
		startDestination = Screen.HomeScreen.route
	){
		composable(Screen.HomeScreen.route){
			HomeView(navController, viewModel)
		}

		composable(Screen.AddScreen.route){
			AddEditDetailView(id = 0L, viewModel = viewModel, navController = navController)
		}

	}
}