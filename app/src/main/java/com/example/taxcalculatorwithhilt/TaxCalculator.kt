package com.example.taxcalculatorwithhilt

class TaxCalculator {
    fun calcConsumptionTax(price: Int, isTakeOut: Boolean): Int {
        if(isTakeOut) {
            // 1.08倍して、小数点以下を切り捨てる
            val result = price * 1.08
            return Math.floor(result).toInt()
        } else {
            // 1.1売って、小数点以下を切り捨てる
            val result = price * 1.1
            return Math.floor(result).toInt()
        }
    }
}