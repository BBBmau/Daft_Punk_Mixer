package com.mau.daftpunkmixer

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.MobileAds
import com.mau.daftpunkmixer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var beat: MediaPlayer
    private lateinit var binding: ActivityMainBinding
    private lateinit var daftMusic : MediaPlayer
    var pitchIndex = 0;
    private val musicData = musicData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        MobileAds.initialize(this) {}

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.beat.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked){
                beat = MediaPlayer.create(this,R.raw.beat)
                beat.start()
            }
            else if(beat.isPlaying)
                beat.stop()
        }

        registerForContextMenu(binding.root)
    }

    fun openMenu(view: View){
        val intent = Intent(this, MenuActivity::class.java)
        Log.i("openMenu","Button is Pressed!")
        startActivity(intent)

    }

    fun playMusic(view: View){
        val buSelected = view as Button

        val daftSnip = when(buSelected.id){
            // grabs data of the phrase being used (pitch)
            R.id.button1 -> musicData.workit[pitchIndex]
            R.id.button2 -> musicData.makeit[pitchIndex]
            R.id.button3 -> musicData.doit[pitchIndex]
            R.id.button4 -> musicData.makesus[pitchIndex]
            R.id.button5 -> musicData.harder[pitchIndex]
            R.id.button6 -> musicData.better[pitchIndex]
            R.id.button7 -> musicData.faster[pitchIndex]
            R.id.button8 -> musicData.stronger[pitchIndex]
            R.id.button9 -> musicData.morethan[pitchIndex]
            R.id.button10 -> musicData.hour[pitchIndex]
            R.id.button11 -> musicData.our[pitchIndex]
            R.id.button12 -> musicData.never[pitchIndex]
            R.id.button13 -> musicData.ever[pitchIndex]
            R.id.button14 -> musicData.after[pitchIndex]
            R.id.button15 -> musicData.workis[pitchIndex]
            R.id.button16 -> musicData.over[pitchIndex]
            else -> musicData.workit[0]
        }

        daftMusic = MediaPlayer.create(this, daftSnip)
        daftMusic.start()
    }

    fun pickPitch(view: View){
        val pitchSelected = view as Button
        pitchIndex = when(pitchSelected.id){
            R.id.pitch1 -> 0
            R.id.pitch2 -> 1
            R.id.pitch3 -> 2
            R.id.pitch4 -> 3
            R.id.pitch5 -> 4
            R.id.pitch6 -> 5
            R.id.pitch7 -> 6
            else -> 0
        }
    }

}