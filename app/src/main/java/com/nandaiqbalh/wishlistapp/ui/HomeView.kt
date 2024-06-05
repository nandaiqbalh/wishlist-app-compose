package com.nandaiqbalh.wishlistapp.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.nandaiqbalh.wishlistapp.AppBarView
import com.nandaiqbalh.wishlistapp.R

@Composable
fun HomeView() {
	Scaffold(
		topBar = { AppBarView(title = "Wishlist", onBackNavClicked = {}) },
		floatingActionButton = {
			FloatingActionButton(
				onClick = { /*TODO*/ },
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

		}

	}
}