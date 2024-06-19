package com.nandaiqbalh.wishlistapp.data

import kotlinx.coroutines.flow.Flow

class WishRepository(private val wishDao: WishDao) {

	suspend fun addWish(wish: Wish){
		wishDao.addWish(wish)
	}

	fun getAllWishes(): Flow<List<Wish>> = wishDao.getAllWishes()

	fun getWishById(id: Long): Flow<Wish>  {
		return wishDao.getWishById(id)
	}

	suspend fun updateWish(wish: Wish){
		return wishDao.updateWish(wish)
	}

	suspend fun deleteWish(wish: Wish){
		return wishDao.deleteWish(wish)
	}
}