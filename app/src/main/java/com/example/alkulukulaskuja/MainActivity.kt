package com.example.alkulukulaskuja

import android.icu.lang.UCharacter.GraphemeClusterBreak.V
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import com.example.alkulukulaskuja.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*
import kotlin.concurrent.thread
import kotlin.system.measureTimeMillis


const val IS_PRIME = 1
const val PRIME_NUMBERS = 2
const val PRIME = 3

class MainActivity : AppCompatActivity() {

    var mainThreadHandler : Handler? = null
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.v("ThreadHandler", "onCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        mainThreadHandler = object : Handler(Looper.getMainLooper()){
            override fun handleMessage(msg: Message){
                if(IS_PRIME == msg.what) {
                    //super.handleMessage(msg)
                    Log.v("ThreadHandler", "${msg.obj}")
                    binding.helloText.setText(msg.obj as String)
                }
                else if(PRIME_NUMBERS == msg.what) {
                    Log.v("ThreadHandler", "${msg.obj}")
                    binding.helloText.setText(msg.obj as String)
                }
                else if(PRIME == msg.what) {
                    Log.v("ThreadHandler", "${msg.obj}")
                    binding.helloText.setText(msg.obj as String)
                }
            }
        }
        var mySimpleRunnable = ThreadHandler(mainThreadHandler)
        var myThread = Thread(mySimpleRunnable)
        myThread.start()

        //BUTTONS

        binding.checkButton.setOnClickListener {
            Log.v("ThreadHandler", "check prime number pressed")
            var msg = Message()
            msg.what = IS_PRIME
            msg.arg1 = binding.numberInput.text!!.toString().toInt()
            mySimpleRunnable.workerThreadHandler!!.sendMessage(msg)

        }

        binding.primeNumbersButton.setOnClickListener {
            Log.v("ThreadHandler", "list prime numbers pressed")
            var msg = Message()
            msg.what = PRIME_NUMBERS
            msg.arg1 = binding.numberInput.text!!.toString().toInt()
            mySimpleRunnable.workerThreadHandler!!.sendMessage(msg)

        }

        binding.divisionPrimeNumbersButton.setOnClickListener {
            Log.v("ThreadHandler", "divide to prime numbers pressed")
            var msg = Message()
            msg.what = PRIME
            msg.arg1 = binding.numberInput.text!!.toString().toInt()
            mySimpleRunnable.workerThreadHandler!!.sendMessage(msg)

        }
    }
}

class SimpleThread : Thread(){
    override fun run(){
        Log.v("ThreadHandler", "class SimpleThread current ${Thread.currentThread()}")
    }
}



open class Character{

}