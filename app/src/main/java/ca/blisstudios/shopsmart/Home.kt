package ca.blisstudios.shopsmart

sealed class Home(val route: String){
    object MainScreen : Home("main_screen")
    object DetailScreen : Home("detail_screen")
}
