package com.example.musicapp

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Adapter
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.facebook.shimmer.Shimmer
import com.facebook.shimmer.ShimmerFrameLayout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class MainActivity : AppCompatActivity() {
    lateinit var recycler: RecyclerView
    lateinit var myAdapter :MyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler = findViewById(R.id.recycler)

        val retrofitBuilder = Retrofit.Builder()
            .baseUrl("https://deezerdevs-deezer.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)


        val retrofitData = retrofitBuilder.getData("eminem")

        retrofitData.enqueue(object : Callback<MyDataModel?> {
            override fun onResponse(
                call: Call<MyDataModel?>, response: Response<MyDataModel?>
            ) {
                val dataList = response.body()?.data!!

                myAdapter = MyAdapter(this@MainActivity,dataList)
                recycler.adapter= myAdapter
                recycler.layoutManager= LinearLayoutManager(this@MainActivity)



            }

            override fun onFailure(call: Call<MyDataModel?>, t: Throwable) {
                Log.d("Tag: Fail", "onFailure" + t.message)
            }
        })
    }
}