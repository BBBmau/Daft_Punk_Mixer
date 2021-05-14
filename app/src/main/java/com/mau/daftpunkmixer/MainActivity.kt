package com.mau.daftpunkmixer

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.mau.daftpunkmixer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var daftMusic : MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
    }

    fun playMusic(view: View){
        val binding = ActivityMainBinding.inflate(layoutInflater)
        val buSelected = view as Button

        val daftSnip = when(buSelected.id){
            R.id.button1 -> R.raw.workit
            R.id.button2 -> R.raw.makeit
            R.id.button3 -> R.raw.doit
            R.id.button4 -> R.raw.makesus
            R.id.button5 -> R.raw.harder
            R.id.button6 -> R.raw.better
            R.id.button7 -> R.raw.faster
            R.id.button8 -> R.raw.stronger
            R.id.button9 -> R.raw.morethan
            R.id.button10 -> R.raw.power
            R.id.button11 -> R.raw.our
            R.id.button12 -> R.raw.never
            R.id.button13 -> R.raw.ever
            R.id.button14 -> R.raw.after
            R.id.button15 -> R.raw.workis
            R.id.button16 -> R.raw.over
            else -> R.raw.workit
        }

        daftMusic = MediaPlayer.create(this,daftSnip)
        daftMusic.start()
    }


}