package com.example.android.firstprogrammingassignment

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;

import kotlinx.android.synthetic.main.activity_display.*

class DisplayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)
        recyclerview_main.setBackgroundColor(Color.BLUE)
        //setSupportActionBar(toolbar)

        //fab.setOnClickListener { view ->
        //    Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
        //        .setAction("Action", null).show()
        //}

        var currentUser = intent.extras.getSerializable("Current_User")
        //Log.e("display:",currentUser.toString())
        //username_textview.setText("Logged in!!!")




    }

}
