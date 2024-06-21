@file:Suppress("DEPRECATION")

package com.nandaiqbalh.wishlistapp.ui

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.DismissDirection
import androidx.compose.material.DismissValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.FractionalThreshold
import androidx.compose.material.Scaffold
import androidx.compose.material.SwipeToDismiss
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.rememberDismissState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.nandaiqbalh.wishlistapp.R
import com.nandaiqbalh.wishlistapp.Screen
import com.nandaiqbalh.wishlistapp.WishViewModel
import com.nandaiqbalh.wishlistapp.data.Wish

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomeView(
	navController: NavController,
	viewModel: WishViewModel,
) {
	Scaffold(topBar = { AppBarView(title = "Wishlist", onBackNavClicked = {}) },
		floatingActionButton = {
			FloatingActionButton(
				onClick = {
					navController.navigate(Screen.AddScreen.route + "/0L")
				},
				modifier = Modifier.padding(20.dp),
				contentColor = Color.White,
				backgroundColor = colorResource(id = R.color.app_bar_color)
			) {
				Icon(imageVector = Icons.Default.Add, contentDescription = "Floating action button")
			}
		}) {
		val wishlist = viewModel.getAllWishes.collectAsState(initial = listOf())

		if (wishlist.value.isEmpty()) {
			Box(
				modifier = Modifier
					.fillMaxSize()
					.padding(it),
				contentAlignment = Alignment.Center
			) {
				Text(text = "Wishlist masih kosong", fontWeight = FontWeight.Medium)
			}
		} else {
			LazyColumn(
				modifier = Modifier
					.fillMaxSize()
					.padding(it)
			) {
				items(wishlist.value, key = { wish -> wish.id }) { wish ->

					val dismissState = rememberDismissState(confirmStateChange = {
						if (it == DismissValue.DismissedToEnd || it == DismissValue.DismissedToStart) {
							viewModel.deleteWish(wish)
						}
						true
					})

					SwipeToDismiss(state = dismissState,
						background = {
							val color by animateColorAsState(
								targetValue = if (dismissState.dismissDirection == DismissDirection.EndToStart) Color.Red else Color.Transparent,
								label = ""
							)

							val alignment = Alignment.CenterEnd

							Box(
								modifier = Modifier
									.fillMaxSize()
									.background(color = color)
									.padding(20.dp), contentAlignment = alignment
							) {
								Icon(
									Icons.Default.Delete,
									contentDescription = "Delete Icon",
									tint = Color.White
								)
							}
						},
						directions = setOf(DismissDirection.EndToStart),
						dismissThresholds = { FractionalThreshold(0.75f) },
						dismissContent = {
							WishItem(wish = wish) {
								val id = wish.id

								navController.navigate(Screen.AddScreen.route + "/$id")
							}
						})

				}

			}
		}

	}
}

@Composable
fun WishItem(wish: Wish, onClick: () -> Unit) {
	Card(
		modifier = Modifier
			.fillMaxWidth()
			.padding(top = 8.dp, start = 8.dp, end = 8.dp)
			.clickable { onClick() },
		elevation = CardDefaults.cardElevation(10.dp),
		colors = CardDefaults.cardColors(Color.White)
	) {
		Column(modifier = Modifier.padding(16.dp)) {
			Text(text = wish.title, fontWeight = FontWeight.ExtraBold)
			Text(text = wish.description)
		}
	}
}