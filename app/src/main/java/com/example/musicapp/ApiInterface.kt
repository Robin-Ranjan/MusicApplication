package com.example.musicapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiInterface {
  @Headers("X-RapidAPI-Key: 96d6f239cbmsh302915aa79b9badp1910b6jsn4e7c73135c58",
      "X-RapidAPI-Host: deezerdevs-deezer.p.rapidapi.com")
    @GET("search")
fun getData(@Query("q") query: String):Call<MyDataModel>


}