package ca.blisstudios.shopsmart

import androidx.room.Dao
import androidx.room.Query

@Dao
interface ProductDao {

    @Query("")
    fun getPrice(price: Product)


}