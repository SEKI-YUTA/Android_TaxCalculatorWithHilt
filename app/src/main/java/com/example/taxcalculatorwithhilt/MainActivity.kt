@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.taxcalculatorwithhilt

import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.taxcalculatorwithhilt.ui.theme.TaxCalculatorWithHiltTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel = hiltViewModel<MainViewModel>()
            TaxCalculatorWithHiltTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                    ) {
                        TextField(
                            value = if(viewModel.price == 0) "" else viewModel.price.toString(),
                            onValueChange = {
                                viewModel.price = it.toIntOrNull() ?: 0
                            },
                            label = { Text("Price") }
                        )
                        Row(
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(text = "${if (viewModel.isTakeOut) "Take Out" else "Eat In"}")
                            Spacer(modifier = Modifier.width(8.dp))
                            Switch(checked = viewModel.isTakeOut, onCheckedChange = {
                                viewModel.isTakeOut = it
                            })
                        }
                        Button(onClick = {
                            viewModel.calcConsumptionTax()
                            val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                            imm.hideSoftInputFromWindow(currentFocus?.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
                        }) {
                            Text("Clac Tax")
                        }
                        Text(
                            "Result: ${viewModel.result}", style = TextStyle(
                                fontSize = 30.sp
                            )
                        )

//                        Button(onClick = {
//                            viewModel.demoFunc()
//                        }) {
//                            Text("Demo Func")
//                        }

                    }
                }
            }
        }
    }
}
