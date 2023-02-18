package com.example.opensecondactivity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    private lateinit var info: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        info = findViewById(R.id.infoSA)

        if (intent != null && intent.hasExtra(INFO_EXTRA)) {
            val data = intent.getStringExtra(INFO_EXTRA)
            info.text = data
        }
    }

    fun myButtonClickSA(view: View) {
//        val i = Intent(this@SecondActivity, MainActivity::class.java)
//        startActivity(i)

        startActivity(Intent(this@SecondActivity, MainActivity::class.java))

//        startService(Intent(this@SecondActivity, MyService::class.java))
    }

    companion object {
        const val INFO_EXTRA = "info"
    }
}