package com.example.exthreadscoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        btnThread.setOnClickListener{
            Thread (Runnable{
                Thread.sleep(2000)
                runOnUiThread{
                    tvRes.text = "Click Thread"
                }

            }).start()
        }
        btnHandler.setOnClickListener{
            Handler(Looper.getMainLooper()).postDelayed({
                tvRes.text = "Click Handler"
            },9000)
        }
    }
}