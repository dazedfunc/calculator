package com.example.calc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    lateinit var resultTextView: TextView
    private var operand: Double = 0.0
    private var operation: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextView = findViewById(R.id.resultTextView)
        findViewById<TextView>(R.id.clearButton).setOnClickListener{
            resultTextView.text = ""
            operand = 0.0
            operation = ""
        }
        findViewById<TextView>(R.id.delButton).setOnClickListener{
            val text = resultTextView.text.toString()
            if (text.isNotEmpty()) {
                resultTextView.text = text.drop(1)
            }
        }
        findViewById<TextView>(R.id.dotButton).setOnClickListener{
            val text = resultTextView.text.toString()
            if (text.isNotEmpty()){
                resultTextView.text = text + "."
            }
        }
    }

    fun numberClick(view: View) {

        if (view is TextView) {
            val number: String = view.text.toString()
            var result: String = resultTextView.text.toString()

            if (result == "0"){
                result = ""
            }

            resultTextView.text = result + number
        }
    }
    fun operationClick(view: View){
        if (view is TextView){
            if (TextUtils.isEmpty(resultTextView.text)){
                operand = resultTextView.text.toString().toDouble()
            }
            resultTextView.text = ""
            operation = view.text.toString()
        }
    }

    fun equalsClick(view: View) {
        val secOperand: String = resultTextView.toString()
        var secNumber = 0.0

        if (!TextUtils.isEmpty(secOperand)){
            secNumber = secOperand.toDouble()
        }

        when (operation){
            "+" -> resultTextView.text = (operand + secNumber).toString()
            "-" -> resultTextView.text = (operand - secNumber).toString()
            "*" -> resultTextView.text = (operand * secNumber).toString()
            "/" -> resultTextView.text = (operand / secNumber).toString()

        }
    }

}