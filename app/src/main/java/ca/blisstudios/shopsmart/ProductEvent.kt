package ca.blisstudios.shopsmart

sealed interface ProductEvent{
    object clickPrice: ProductEvent
    data class readPrice(val price: Float): ProductEvent
}