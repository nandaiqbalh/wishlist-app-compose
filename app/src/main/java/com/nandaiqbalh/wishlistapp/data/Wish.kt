package com.nandaiqbalh.wishlistapp.data

data class Wish(
	val id: Long = 0L,
	val title: String = "",
	val description: String = "",
)

object DummyWish {
	val wishList = listOf(
		Wish(title = "Wake up early everyday", description = "Want it so bad!!!"),
		Wish(title = "Wake up early everyday", description = "Want it so bad!!!"),
		Wish(title = "Wake up early everyday", description = "Want it so bad!!!"),
		Wish(title = "Wake up early everyday", description = "Want it so bad!!!"),
		Wish(title = "Wake up early everyday", description = "Want it so bad!!!"),
		Wish(title = "Wake up early everyday", description = "Want it so bad!!!"),
		)
}
