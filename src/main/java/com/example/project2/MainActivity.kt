package com.example.project2

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.vectordrawable.graphics.drawable.ArgbEvaluator
import com.example.project2.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: ViewModel
    private lateinit var timeString: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        viewModel = ViewModelProvider(this).get(ViewModel::class.java)
         timeString = ""
        var thread1: Thread = Thread()

        changeBackgroundColor()
        startAnimations()

        binding.startButton.setOnClickListener {
            val btn_PressedTime = System.currentTimeMillis()
            viewModel.setPressedTimeInMillis(btn_PressedTime)
            viewModel.setIsMusicPlayedFromBeggining(true)
            thread1 = object : Thread() {
                override fun run() {
                    try {
                        while (!this.isInterrupted) {
                            sleep(1000)
                            runOnUiThread {
                                // update TextView
                                val currentTimeMillis = System.currentTimeMillis()
                                viewModel.setCurrTimeMS(currentTimeMillis)

                                val timeFormat = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
                                val currentDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-yy"))
                                timeString = currentDate +" " +timeFormat.format(Date(currentTimeMillis))
                                viewModel.setCurrTime(timeString)

                            }
                        }
                    } catch (e: InterruptedException) {
                    }
                }
            }
            thread1.start()
        }

        binding.stopBtn.setOnClickListener {
            thread1.interrupt()
            stopMusic()
        }

        val fragment = BottomFrag()
        supportFragmentManager.beginTransaction().replace(R.id.botFrag, fragment).commit()

        viewModel.currentTime.observe(this) { time ->
            fragment.updateTime(time)
        }

        viewModel.currentTimeInMillis.observe(this, { time ->
            fragment.updateCurrentTimeElapsed(time)
        })

    }






}
