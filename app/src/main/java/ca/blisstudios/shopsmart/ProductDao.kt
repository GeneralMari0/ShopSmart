package ca.blisstudios.shopsmart

import androidx.room.Dao
import androidx.room.Query

@Dao
interface ProductDao {

    @Query("SELECT Price FROM Data")
    fun getPrice(price: Product)


}