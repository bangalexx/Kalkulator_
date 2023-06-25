package com.alek.kalkulator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var resultTextView: TextView
    private var operand1: Double = 0.0
    private var operator: String? = null
    private var isNewOperation: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextView = findViewById(R.id.resultTextView)
    }

    fun onNumberClick(view: View) {
        if (isNewOperation) {
            resultTextView.text = ""
            isNewOperation = false
        }

        val button: Button = view as Button
        val number: String = button.text.toString()
        val currentText: String = resultTextView.text.toString()

        resultTextView.text = currentText + number
    }

    fun onOperatorClick(view: View) {
        isNewOperation = true

        val button: Button = view as Button
        operator = button.text.toString()
        operand1 = resultTextView.text.toString().toDouble()
    }

    fun onEqualsClick(view: View) {
        val operand2: Double = resultTextView.text.toString().toDouble()
        var result: Double = 0.0

        when (operator) {
            "+" -> result = operand1 + operand2
            "-" -> result = operand1 - operand2
            "*" -> result = operand1 * operand2
            "/" -> result = operand1 / operand2
        }

        resultTextView.text = result.toString()
    }

    fun onClearClick(view: View) {
        resultTextView.text = ""
        operand1 = 0.0
        operator = null
        isNewOperation = true
    }
}
