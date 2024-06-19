package com.nandaiqbalh.wishlistapp.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.nandaiqbalh.wishlistapp.R
import com.nandaiqbalh.wishlistapp.WishViewModel

@Composable
fun AddEditDetailView(
	id: Long,
	viewModel: WishViewModel,
	navController: NavController,
) {
	Scaffold(
		topBar = {
			AppBarView(
				title = if (id != 0L) stringResource(id = R.string.update_wish) else stringResource(
					id = R.string.add_wish
				)
			) {
				navController.navigateUp()
			}
		}
	) {
		Column(
			modifier = Modifier
				.padding(it) // Apply the system bars padding first
				.padding(horizontal = 16.dp, vertical = 16.dp) // Additional custom padding
				.wrapContentSize(),
			horizontalAlignment = Alignment.CenterHorizontally,
			verticalArrangement = Arrangement.Center
		) {
			Spacer(modifier = Modifier.height(10.dp))

			WishTextField(
				label = "Title",
				value = viewModel.wishTitleState,
				onValueChanged = { viewModel.onWishTitleChanged(it) }
			)

			Spacer(modifier = Modifier.height(10.dp))

			WishTextField(
				label = "Description",
				value = viewModel.wishDescriptionState,
				onValueChanged = { viewModel.onWishDescriptionChanged(it) }
			)

			Spacer(modifier = Modifier.height(10.dp))

			Button(onClick = {
				if (viewModel.wishTitleState.isNotEmpty() && viewModel.wishDescriptionState.isNotEmpty()) {

					// TODO update wish
				} else {
					// TODO add wish

				}
			}) {
				Text(
					text = if (id != 0L) stringResource(id = R.string.update_wish) else stringResource(
						id = R.string.add_wish
					),
					style = TextStyle(
						fontSize = 18.sp
					)
				)
			}
		}
	}
}

@Composable
fun WishTextField(
	label: String,
	value: String,
	onValueChanged: (String) -> Unit,
) {
	OutlinedTextField(
		value = value,
		onValueChange = onValueChanged,
		label = { Text(text = label, color = Color.Black) },
		modifier = Modifier.fillMaxWidth(),
		keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
		colors = OutlinedTextFieldDefaults.colors(
			focusedTextColor = Color.Black,
			cursorColor = Color.Black,
			focusedBorderColor = Color.Black,
		)
	)
}