package ca.blisstudios.shopsmart

import androidx.room.Dao
import androidx.room.Query

@Dao
interface ProductDao {

    @Query("SELECT price from Product WHERE id = 1")
    fun getPrice(price: Product)


}