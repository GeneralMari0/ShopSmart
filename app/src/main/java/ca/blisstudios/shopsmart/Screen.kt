package ca.blisstudios.shopsmart

sealed class Screen(val route: String){
    object HomeScreen : Screen("home_screen")
    object ProductScreen : Screen("product_screen")
}
