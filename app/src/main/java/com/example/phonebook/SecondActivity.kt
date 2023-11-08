package com.example.phonebook

import android.app.Activity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)

        val name = findViewById<TextView>(R.id.name)

        val intent = intent
        val nameAcc = intent.getStringExtra("name")

        name.text = nameAcc



        }

}