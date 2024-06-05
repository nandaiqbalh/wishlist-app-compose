package com.nandaiqbalh.wishlistapp.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.nandaiqbalh.wishlistapp.AppBarView

@Composable
fun HomeView() {
	Scaffold(topBar = { AppBarView(title = "Wishlist", onBackNavClicked = {}) }) {
		LazyColumn(
			modifier = Modifier
				.fillMaxSize()
				.padding(it)
		) {

		}

	}
}