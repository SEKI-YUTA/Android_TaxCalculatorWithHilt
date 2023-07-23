package com.example.taxcalculatorwithhilt

import android.content.Context
import android.widget.Toast

class DemoUtil(val context: Context, val prefixMessage: String) {
    fun demoGreeting(name: String) {
        Toast.makeText(context, "${prefixMessage} $name", Toast.LENGTH_SHORT).show()
    }
}