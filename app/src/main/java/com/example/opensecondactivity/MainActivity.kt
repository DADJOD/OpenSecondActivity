package com.example.opensecondactivity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var data: String
    private lateinit var input: EditText

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        input = findViewById(R.id.input)
    }

    fun myButtonClick(view: View) {
//        val myIntent = Intent(this@MainActivity, SecondActivity::class.java)
//
//        data = input.text.trim().toString()
//        myIntent.putExtra(SecondActivity.INFO_EXTRA, data)
//
//        startActivity(myIntent)

        val intent = Intent(this@MainActivity, MyService::class.java)
        data = input.text.toString().trim()
        intent.putExtra(MyService.SERVICE_DATA_EXTRA, data)
        startService(intent)
    }
}