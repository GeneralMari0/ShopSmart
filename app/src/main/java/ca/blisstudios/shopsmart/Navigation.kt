package ca.blisstudios.shopsmart

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.HomeScreen.route){
        composable(route = Screen.HomeScreen.route){

        }

        composable(route = Screen.ProductScreen.route){

        }
    }
}

@Composable
fun HomeScreen(navController: NavController) {

    Column{
        Text(text = "Please click this button")

        Button(onClick = {
            navController.navigate(Screen.ProductScreen.route)
        })

        {
            Text(text = "Click me plox")
        }
    }
}

@Composable
fun ProductScreen(navController: NavController) {

    Column{
        Text(text = "Welcome to the product screen.")

        Button(onClick = {
            navController.navigate(Screen.HomeScreen.route)
        })

        {
            Text(text = "Return")
        }
    }
}