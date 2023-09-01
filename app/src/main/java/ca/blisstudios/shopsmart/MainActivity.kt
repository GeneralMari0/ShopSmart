package ca.blisstudios.shopsmart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Navigate()
        }
    }
}

@Composable
fun Navigate()
{
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "main_page") {
        composable("main_page")
        {
            MainPage(navController)
        }
        composable("product_page")
        {
            ProductPage(navController)
        }

    }
}

@Composable
fun ProductPage(navController: NavHostController, modifier: Modifier = Modifier) {

    Column(
        modifier = Modifier.background(Color.White)
    )
    {
        Text(
            text = "Shopping App",
            color = Color.Black,
            fontSize = 41.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .background(Color(27, 178, 244, 96))
                .padding(10.dp)
                .fillMaxWidth()
        )

        Image(
            painter = painterResource(id = R.drawable.lucerne_chocolate_4l),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .padding(vertical = 50.dp)
                .align(Alignment.CenterHorizontally)
        )

        Text(
            text = "Dairyland 1% Chocolate Milk 4L",
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(vertical = 30.dp)
            )

        Button(
            onClick = {
                navController.navigate("main_page")
            }
        )
        {
            Text(text = "Add to List")
        }



        LazyColumn(modifier = Modifier
            .background(Color.LightGray)
            .border(border = BorderStroke(width = 1.dp, Color.Black))

        ) {

            item {
                Row(modifier = Modifier
                    .background(Color(172, 245, 218, 96))
                    .fillMaxWidth()
                    .border(border = BorderStroke(width = 1.dp, Color.Black))
                ) {
                    Text(text = "Walmart", modifier = Modifier.padding(20.dp))
                    Text(text = "$6.59", modifier = Modifier.padding(20.dp))
                }
            }

            item {
                Row(modifier = Modifier
                    .background(Color(175, 232, 245, 96))
                    .fillMaxWidth()
                ) {
                    Text(text = "Safeway", modifier = Modifier.padding(20.dp))
                    Text(text = "$7.29", modifier = Modifier.padding(20.dp))
                }
            }

            item {
                Row(modifier = Modifier
                    .background(Color(172, 245, 218, 96))
                    .fillMaxWidth()
                    .border(border = BorderStroke(width = 1.dp, Color.Black))
                ) {
                    Text(text = "Real Canadian Superstore", modifier = Modifier.padding(20.dp))
                    Text(text = "$7.49", modifier = Modifier.padding(20.dp))
                }
            }

            item {
                Row(modifier = Modifier
                    .background(Color(175, 232, 245, 96))
                    .fillMaxWidth()
                ) {
                    Text(text = "Save-On-Foods", modifier = Modifier.padding(20.dp))
                    Text(text = "$8.79", modifier = Modifier.padding(20.dp))
                }
            }

        }
    }
}

@Composable
fun MainPage(navController: NavHostController) {

    LazyColumn(
        modifier = Modifier
            .background(Color.White)
    )
    {


        item{
            Text(
                text = "Shopping App",
                color = Color.Black,
                fontSize = 41.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .background(Color(27, 178, 244, 96))
                    .padding(10.dp)
                    .fillMaxWidth()
            )
        }
        item{
            Text(
                text = " Popular Items ",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                textAlign = TextAlign.Left,
                modifier = Modifier
                    .padding(top = 80.dp)
            )
        }


        item{
            LazyRow(modifier = Modifier
                .background(Color.White)
                .padding(20.dp),
                horizontalArrangement = Arrangement.Center

            ){

                item{
                    Column{
                        Image(
                            painter = painterResource(id = R.drawable.lucerne_chocolate_4l),
                            contentDescription = null,
                            contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .padding(vertical = 20.dp)
                        )

                        Text(
                            text = "  Chocolate Milk 4L  ",
                            color = Color.Black,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )

                        val dbPrice : String = "Select Price from Main where ID = 1"

                        Text(
                            text = "$8.29",
                            color = Color.Red,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            modifier = Modifier
                                .padding(horizontal = 60.dp)
                        )

                        Button(
                            modifier = Modifier
                                .padding(horizontal = 50.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(24, 115, 252, 99)),
                            onClick =
                            {
                                navController.navigate("product_page")
                            }
                        )
                        {
                            Text(text = "View")
                        }
                    }
                }
                item{
                    Column{
                        Image(
                            painter = painterResource(id = R.drawable.drpepper_12pack),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(vertical = 20.dp)
                        )

                        Text(
                            text = "  Dr. Pepper 12Pk  ",
                            color = Color.Black,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )

                        Text(
                            text = "$7.99",
                            color = Color.Red,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            modifier = Modifier
                                .padding(horizontal = 60.dp)
                        )

                        Button(
                            modifier = Modifier
                                .padding(horizontal = 50.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(24, 115, 252, 99)),
                            onClick =
                            {

                            }
                        )
                        {
                            Text(text = "View")
                        }
                    }

                }

                item{
                    Column{
                        Image(
                            painter = painterResource(id = R.drawable.pepsi),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(vertical = 20.dp)
                        )

                        Text(
                            text = "  Pepsi 12pk  ",
                            color = Color.Black,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                        Text(
                            text = "$7.99",
                            color = Color.Red,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            modifier = Modifier
                                .padding(horizontal = 60.dp)
                        )

                        Button(
                            modifier = Modifier
                                .padding(horizontal = 50.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(24, 115, 252, 99)),
                            onClick =
                            {

                            }
                        )
                        {
                            Text(text = "View")
                        }
                    }
                }

                item{

                    Column{
                        Image(
                            painter = painterResource(id = R.drawable.lunchable),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(vertical = 20.dp)
                        )
                        Text(
                            text = "  Lunchables, Pizza  ",
                            color = Color.Black,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                        Text(
                            text = "$4.49",
                            color = Color.Red,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            modifier = Modifier
                                .padding(horizontal = 60.dp)
                        )

                        Button(
                            modifier = Modifier
                                .padding(horizontal = 50.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(24, 115, 252, 99)),
                            onClick =
                            {

                            }
                        )
                        {
                            Text(text = "View")
                        }
                    }


                }
            }
        }

        item{Text(
            text = " Dairy ",
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            textAlign = TextAlign.Left,
            modifier = Modifier
                .padding(top = 80.dp)
        )}

        item{
            LazyRow(modifier = Modifier
                .background(Color.White)
                .padding(20.dp)

            ){

                item{
                    Column{
                        Image(
                            painter = painterResource(id = R.drawable.lucerne_2__4l),
                            contentDescription = null,
                            contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .padding(vertical = 20.dp)
                        )
                        Text(
                            text = "  2% Milk 4L  ",
                            color = Color.Black,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                        Text(
                            text = "$5.79",
                            color = Color.Red,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            modifier = Modifier
                                .padding(horizontal = 60.dp)
                        )

                        Button(
                            modifier = Modifier
                                .padding(horizontal = 50.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(24, 115, 252, 99)),
                            onClick =
                            {

                            }
                        )
                        {
                            Text(text = "View")
                        }
                    }
                }
                item{
                    Column{
                        Image(
                            painter = painterResource(id = R.drawable.lucerne_2_2l),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(vertical = 20.dp)
                        )
                        Text(
                            text = "  2% Milk 2L  ",
                            color = Color.Black,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                        Text(
                            text = "$4.69",
                            color = Color.Red,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            modifier = Modifier
                                .padding(horizontal = 60.dp)
                        )

                        Button(
                            modifier = Modifier
                                .padding(horizontal = 50.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(24, 115, 252, 99)),
                            onClick =
                            {

                            }
                        )
                        {
                            Text(text = "View")
                        }
                    }

                }

                item{
                    Column{
                        Image(
                            painter = painterResource(id = R.drawable.fairland),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(vertical = 20.dp)
                        )
                        Text(
                            text = " Fairlife 2% Organic Milk  ",
                            color = Color.Black,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                        Text(
                            text = "$5.98",
                            color = Color.Red,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            modifier = Modifier
                                .padding(horizontal = 60.dp)
                        )

                        Button(
                            modifier = Modifier
                                .padding(horizontal = 50.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(24, 115, 252, 99)),
                            onClick =
                            {

                            }
                        )
                        {
                            Text(text = "View")
                        }
                    }
                }

                item{

                    Column{
                        Image(
                            painter = painterResource(id = R.drawable.lucerne_0_4l),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(vertical = 20.dp)
                        )
                        Text(
                            text = "  0% Milk 4L  ",
                            color = Color.Black,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                        Text(
                            text = "$5.79",
                            color = Color.Red,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            modifier = Modifier
                                .padding(horizontal = 60.dp)
                        )

                        Button(
                            modifier = Modifier
                                .padding(horizontal = 50.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(24, 115, 252, 99)),
                            onClick =
                            {

                            }
                        )
                        {
                            Text(text = "View")
                        }
                    }


                }
            }
        }

        item{
            Text(
                text = " Pop ",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                textAlign = TextAlign.Left,
                modifier = Modifier
                    .padding(top = 80.dp)
            )
        }

        item{
            LazyRow(modifier = Modifier
                .background(Color.White)
                .padding(20.dp)

            ){

                item{
                    Column{
                        Image(
                            painter = painterResource(id = R.drawable.coke_12pack),
                            contentDescription = null,
                            contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .padding(vertical = 20.dp)
                        )
                        Text(
                            text = "  Coca-Cola 12Pk  ",
                            color = Color.Black,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                        Text(
                            text = "$7.99",
                            color = Color.Red,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            modifier = Modifier
                                .padding(horizontal = 60.dp)
                        )

                        Button(
                            modifier = Modifier
                                .padding(horizontal = 50.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(24, 115, 252, 99)),
                            onClick =
                            {

                            }
                        )
                        {
                            Text(text = "View")
                        }
                    }
                }
                item{
                    Column{
                        Image(
                            painter = painterResource(id = R.drawable.drpepper_12pack),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(vertical = 20.dp)
                        )
                        Text(
                            text = "  Dr. Pepper 12Pk  ",
                            color = Color.Black,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                        Text(
                            text = "$7.99",
                            color = Color.Red,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            modifier = Modifier
                                .padding(horizontal = 60.dp)
                        )

                        Button(
                            modifier = Modifier
                                .padding(horizontal = 50.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(24, 115, 252, 99)),
                            onClick =
                            {

                            }
                        )
                        {
                            Text(text = "View")
                        }
                    }

                }

                item{
                    Column{
                        Image(
                            painter = painterResource(id = R.drawable.crush_cream),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(vertical = 20.dp)
                        )
                        Text(
                            text = "  Crush Cream Soda 2L  ",
                            color = Color.Black,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                        Text(
                            text = "$3.49",
                            color = Color.Red,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            modifier = Modifier
                                .padding(horizontal = 60.dp)
                        )

                        Button(
                            modifier = Modifier
                                .padding(horizontal = 50.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(24, 115, 252, 99)),
                            onClick =
                            {

                            }
                        )
                        {
                            Text(text = "View")
                        }
                    }
                }

                item{

                    Column{
                        Image(
                            painter = painterResource(id = R.drawable.sprite),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(vertical = 20.dp)
                        )
                        Text(
                            text = "  Sprite Mini 6pk  ",
                            color = Color.Black,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                        Text(
                            text = "$5.49",
                            color = Color.Red,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            modifier = Modifier
                                .padding(horizontal = 60.dp)
                        )

                        Button(
                            modifier = Modifier
                                .padding(horizontal = 50.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(24, 115, 252, 99)),
                            onClick =
                            {

                            }
                        )
                        {
                            Text(text = "View")
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

}