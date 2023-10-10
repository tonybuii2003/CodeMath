package com.example.codemath

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
const val ADD = 1
const val SUB = 2
const val MUL = 3
const val DIV = 4
class MainActivity : AppCompatActivity() {
    fun isDoubleAnInteger(number: Double): Boolean {
        val intNumber = number.toInt()
        return number == intNumber.toDouble()
    }
    private lateinit var textView: TextView
    private var currentText = ""
    private var currentInt1 = 0
    private var currentInt2 = 0
    private var result = 0.0
    private var currentOp = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.textView)
        val buttonIds = arrayOf(
            R.id.button, R.id.button2, R.id.button3,
            R.id.button6, R.id.button4, R.id.button5,
            R.id.button12, R.id.button11, R.id.button10,
            R.id.button13
        )
        val buttonMul = findViewById<Button>(R.id.button15)
        val buttonClean = findViewById<Button>(R.id.button25)
        val buttonEqual = findViewById<Button>(R.id.button17)
        for (buttonId in buttonIds) {
            val button = findViewById<Button>(buttonId)
            button.setOnClickListener {
                currentText += button.text.toString()
                textView.text = currentText
            }
        }
        buttonMul.setOnClickListener{

            var tmp = currentText
            textView.text = ""
            currentOp = 3
            if (!currentText.isEmpty()) {
                if (currentInt1 == 0){
                    currentInt1  = currentText.toInt()
                    currentText = ""


                } else {
                    currentInt2 = currentText.toInt()
                    currentInt1 *= currentInt2
                    currentInt2 = 0
                    currentText = ""

                }
            }
        }
        buttonClean.setOnClickListener{
            currentText = ""
            currentInt1 = 0
            currentInt2 = 0
            result = 0.0
            currentOp = 0
            textView.text = currentText
        }
        buttonEqual.setOnClickListener {
            when (currentOp){
                ADD -> result = currentInt1.toDouble() + currentInt2.toDouble()
                SUB -> {
                    if (currentInt1 < currentInt2) {
                        textView.text = "No negative number yet :))"
                    }
                    result = currentInt1.toDouble() - currentInt2.toDouble()
                }
                MUL -> {
                    if (!currentText.isEmpty() && currentInt1 != 0){

                        currentInt2 = currentText.toInt()
                        currentText = ""
                    }
                    result = currentInt1.toDouble() * currentInt2.toDouble()
                }
                DIV -> {
                    if (currentInt2 == 0) {
                        textView.text = "Can't divided by 0"
                    } else {
                        result = currentInt1.toDouble() / currentInt2.toDouble()
                    }

                }
            }
            println(currentInt1)
            println(currentInt2)
            println(currentOp)
            println(result)
            if (isDoubleAnInteger(result)) {
                textView.text = result.toInt().toString()
            } else {
                textView.text = result.toString()
            }
        }

    }
}