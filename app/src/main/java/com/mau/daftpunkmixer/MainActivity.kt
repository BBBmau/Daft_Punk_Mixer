package com.mau.daftpunkmixer

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.mau.daftpunkmixer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val viewModel: MusicViewModel by viewModels()
    private lateinit var beat: MediaPlayer
    private lateinit var binding: ActivityMainBinding
    private lateinit var daftMusic : MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
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
    }


    fun playMusic(view: View){
        val buSelected = view as Button

        val daftSnip = when(buSelected.id){
            // grabs data of the phrase being used (pitch)
            R.id.button1 -> R.raw.workit1
            R.id.button2 -> R.raw.makeit1
            R.id.button3 -> R.raw.doit1
            R.id.button4 -> R.raw.makesus1
            R.id.button5 -> R.raw.harder1
            R.id.button6 -> R.raw.better1
            R.id.button7 -> R.raw.faster1
            R.id.button8 -> R.raw.stronger1
            R.id.button9 -> R.raw.morethan1
            R.id.button10 -> R.raw.hour1
            R.id.button11 -> R.raw.our1
            R.id.button12 -> R.raw.never1
            R.id.button13 -> R.raw.ever1
            R.id.button14 -> R.raw.after1
            R.id.button15 -> R.raw.workis1
            R.id.button16 -> R.raw.over1
            else -> R.raw.workit1
        }

        daftMusic = MediaPlayer.create(this,daftSnip)
        daftMusic.start()
    }

    fun pickPitch(view: View){
        val pitchSelected = view as Button
        var index = viewModel.pitchIndex
        index = when(pitchSelected.id){
            R.id.pitch1 -> 0
            R.id.pitch2 -> 1
            R.id.pitch3 -> 2
            R.id.pitch4 -> 3
            R.id.pitch5 -> 4
            R.id.pitch6 -> 5
            R.id.pitch7 -> 6
            else -> R.raw.harder1
        }
    }

}