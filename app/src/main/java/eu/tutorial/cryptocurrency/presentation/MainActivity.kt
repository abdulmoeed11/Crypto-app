package eu.tutorial.cryptocurrency.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import eu.tutorial.cryptocurrency.presentation.coin_detail.components.CoinDetailScreen
import eu.tutorial.cryptocurrency.presentation.coin_list.components.CoinListScreen
import eu.tutorial.cryptocurrency.presentation.ui.theme.CryptocurrencyTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptocurrencyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.CoinListScreen.route,
                    ){
                        composable(
                            route = Screen.CoinListScreen.route
                        ){
                            CoinListScreen(navController = navController)
                        }
                        composable(
                            route = Screen.CoinDetailScreen.route + "/{coinId}"
                        ){
                            CoinDetailScreen()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CryptocurrencyTheme {

    }
}