package com.aprp19.cubecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var edtLength: EditText
    private lateinit var edtWidth: EditText
    private lateinit var edtHeight: EditText
    private lateinit var btnCalculate: Button
    private lateinit var optResult: TextView

    companion object{
        private const val STATE_RESULT = "state_result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtLength = findViewById(R.id.inp_inputLength)
        edtWidth = findViewById(R.id.inp_inputWidth)
        edtHeight = findViewById(R.id.inp_inputHeight)
        btnCalculate = findViewById(R.id.btn_calculate)
        optResult = findViewById(R.id.opt_result)

        btnCalculate.setOnClickListener(this)

        if (savedInstanceState != null){
            val result = savedInstanceState.getString(STATE_RESULT)
            optResult.text = result
        }

    }

    override fun onClick(v: View) {
        if (v.id == R.id.btn_calculate){
            val inputLength = edtLength.text.toString().trim()
            val inputWidth = edtWidth.text.toString().trim()
            val inputHeight = edtHeight.text.toString().trim()

            var isEmpty = false

            if (inputLength.isEmpty()){
                isEmpty = true
                edtLength.error = "Field can't be empty"
            }
            if (inputWidth.isEmpty()){
                isEmpty = true
                edtWidth.error = "Field can't be empty"
            }
            if (inputHeight.isEmpty()){
                isEmpty = true
                edtHeight.error = "Field can't be empty"
            }

            if (!isEmpty){
                val result = inputLength.toDouble() * inputWidth.toDouble() * inputHeight.toDouble()
                optResult.text = result.toString()
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, optResult.text.toString())
    }
}