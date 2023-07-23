package com.example.taxcalculatorwithhilt

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val calculator: TaxCalculator,
    val demoUtil: DemoUtil
): ViewModel() {
    var price by mutableStateOf(0)
    var result by mutableStateOf(0)
    var isTakeOut by mutableStateOf(false)
//    var isTakeOut MutableStateFlow(false)

    fun calcConsumptionTax() {
        result = calculator.calcConsumptionTax(price, isTakeOut)
    }

    fun demoFunc() {
        demoUtil.demoGreeting("shin")
    }
}