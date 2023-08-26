package ca.blisstudios.shopsmart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
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
import ca.blisstudios.shopsmart.ui.theme.ShopsmartTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShopsmartTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting( modifier: Modifier = Modifier) {

    Column(
        modifier = Modifier.background(Color.White)
    )
    {
        

        Text(
            text = "Shopping App",
            color = Color.Black,
            fontSize = 40.sp,
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
            onClick =
            {

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
                    .border(border = BorderStroke(width = 1.dp, Color.Black))
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

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ShopsmartTheme {
        Greeting()
    }
}