package com.example.android.firstprogrammingassignment

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.GsonBuilder


import kotlinx.android.synthetic.main.activity_display.*
import layout.DisplayAdapter
import okhttp3.*
import java.io.IOException

class DisplayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)
        recyclerview_main.setBackgroundColor(Color.parseColor("#DDF9EC"))
        recyclerview_main.layoutManager = LinearLayoutManager(this)
        //recyclerview_main.adapter = DisplayAdapter()
        var currentUser = intent.extras.getSerializable("Current_User")
        fetchJson()

    }

    fun fetchJson() {
        val url = "https://api.letsbuildthatapp.com/youtube/home_feed"
        val req = Request.Builder().url(url).build()
        val client = OkHttpClient()
        client.newCall(req).enqueue(object: Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e("onFailure:","Failed to execute request")
            }

            override fun onResponse(call: Call, response: Response) {
                //val body = response?.body()?.toString()
                val body = response?.body()?.string()
                Log.e("onResponse:","Successful request btw:" + body.toString())
                println("Body btw:"+body)
                val gson = GsonBuilder().create()
                val feed = gson.fromJson(body, Feed::class.java)


                runOnUiThread {
                    recyclerview_main.adapter = DisplayAdapter(feed)
                }
            }
        })


    }

}

class Feed(val videos: List<Video>)

class Video(val id: Int, val name: String, val link : String, val imageUrl : String, val numberOfViews : Int,
            val channel: Channel)

class Channel(val name: String, val profileImageUrl : String)