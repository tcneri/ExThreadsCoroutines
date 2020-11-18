package com.example.aula34kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        val scope = CoroutineScope(Dispatchers.Main)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnThread.setOnClickListener(){
            Thread(Runnable {
                Thread.sleep(10000)
                runOnUiThread {
                    tvRes.text = "Click Thread"
                }
            }).start()
        }

        btnHandler.setOnClickListener(){
            Handler(Looper.getMainLooper()).postDelayed({
                    tvRes.text = "Click Handler"
            },10000)
        }

        btnCoroutine.setOnClickListener(){
            scope.launch{
                delay(9000)
                tvRes.text = "Click Coroutine"
            }
        }

    }
}