package com.example.lab2_1
import java.math.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val a: EditText = findViewById(R.id.editTextNumber);
        val b: EditText = findViewById(R.id.editTextNumber2);
        val c: EditText = findViewById(R.id.editTextNumber3);
        val res: TextView = findViewById(R.id.textView6)
        val SolveButt: Button = findViewById(R.id.button)
        SolveButt.setOnClickListener{
            val doubleA = a.text.toString().toDouble()
            val doubleB = b.text.toString().toDouble()
            val doubleC = c.text.toString().toDouble()
            res.text = Solver(doubleA,doubleB,doubleC)
        }
    }
}


fun Solver(a:Double,b:Double,c:Double):String {
    val discr: Double = b.pow(2) - 4 * a * c
    when (discr) {
        !in 0.0..Double.MAX_VALUE -> return "Уравнение не имеет рациональных корней"
        0.0 -> return "x = "+(-b)/(2*a)
        in 0.0..Double.MAX_VALUE -> return "x1 = "+(((-b)+discr.pow(0.5))/(2*a)).toString()+",\n x2 = "+(((-b)-discr.pow(0.5))/(2*a)).toString()
    }
    return ""
}