package com.example.android.firstprogrammingassignment

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager


import kotlinx.android.synthetic.main.activity_display.*
import layout.DisplayAdapter

class DisplayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)
        recyclerview_main.layoutManager = LinearLayoutManager(this)
        recyclerview_main.adapter = DisplayAdapter()
        var currentUser = intent.extras.getSerializable("Current_User")
    }

    fun fetchJson() {

    }

}
