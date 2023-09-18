package com.example.musicapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class SplachView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splach_view)

        Handler().postDelayed({
            startActivity(Intent(this@SplachView,MainActivity::class.java))
            finish()
        },4000)
    }
}
