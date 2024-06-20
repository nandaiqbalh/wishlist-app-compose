package com.nandaiqbalh.wishlistapp

import android.content.Context
import androidx.room.Room
import com.nandaiqbalh.wishlistapp.data.WishDatabase
import com.nandaiqbalh.wishlistapp.data.WishRepository

object Graph {

	lateinit var database: WishDatabase

	val wishRepository by lazy {
		WishRepository(database.wishDao())
	}

	fun provide(context: Context){
		database = Room.databaseBuilder(context, WishDatabase::class.java, "wishlist.dp").build()
	}
}