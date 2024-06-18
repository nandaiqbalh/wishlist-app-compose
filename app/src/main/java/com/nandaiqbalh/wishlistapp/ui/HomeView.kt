package com.nandaiqbalh.wishlistapp.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.nandaiqbalh.wishlistapp.R
import com.nandaiqbalh.wishlistapp.Screen
import com.nandaiqbalh.wishlistapp.WishViewModel
import com.nandaiqbalh.wishlistapp.data.DummyWish
import com.nandaiqbalh.wishlistapp.data.Wish

@Composable
fun HomeView(
	navController: NavController,
	viewModel: WishViewModel,
) {
	Scaffold(topBar = { AppBarView(title = "Wishlist", onBackNavClicked = {}) },
		floatingActionButton = {
			FloatingActionButton(
				onClick = {
					navController.navigate(Screen.AddScreen.route)
				},
				modifier = Modifier.padding(20.dp),
				contentColor = Color.White,
				backgroundColor = colorResource(id = R.color.app_bar_color)
			) {
				Icon(imageVector = Icons.Default.Add, contentDescription = "Floating action button")
			}
		}) {
		LazyColumn(
			modifier = Modifier
				.fillMaxSize()
				.padding(it)
		) {
			items(DummyWish.wishList) { wish ->
				WishItem(wish = wish) {

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