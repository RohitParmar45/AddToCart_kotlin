package com.example.addtocart_kotlin

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
     lateinit var recyclerViewAdapter : RecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val itemList = listOf(
            Model("Mango 1", "299", R.drawable.ic_launcher_background),
            Model("Guava 2", "500", R.drawable.ic_launcher_background),
            // Add more items as needed
        )

        val recyclerView: RecyclerView = findViewById(R.id.recyclerview)

        recyclerViewAdapter = RecyclerViewAdapter(this,itemList )
        recyclerView.setLayoutManager(LinearLayoutManager(this))
        recyclerView.setAdapter(recyclerViewAdapter)

    }
}