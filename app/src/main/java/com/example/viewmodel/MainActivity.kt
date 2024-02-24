package com.example.viewmodel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.viewmodel.ui.theme.ViewmodelTheme

class MainActivity : ComponentActivity() {
    //private val viewmodel by viewModels<ContactsViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ViewmodelTheme {
                val viewModel = viewModel<ContactsViewModel>(
                    factory = object : ViewModelProvider.Factory{
                        override fun <T : ViewModel> create(modelClass: Class<T>): T {
                            return ContactsViewModel(
                                text = "Change Background Color"
                            ) as T
                        }
                    }
                )
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = if (viewModel.backgroundColor) Color.Green else Color.Yellow
                ) {
                    Button(onClick = {
                        viewModel.changeBackgroundColor()
                    }) {
                        Text(text = viewModel.text)
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ViewmodelTheme {
        Greeting("Android")
    }
}