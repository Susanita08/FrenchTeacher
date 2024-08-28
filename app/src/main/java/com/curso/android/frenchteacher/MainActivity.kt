package com.curso.android.frenchteacher

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(),  View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btnBlack : Button = findViewById(R.id.blackBtn)
        val btnGreen : Button = findViewById(R.id.greenBtn)
        val btnPurple : Button = findViewById(R.id.purpleBtn)
        val btnRed : Button = findViewById(R.id.redBtn)
        val btnYellow : Button = findViewById(R.id.yellowBtn)

        btnBlack.setOnClickListener(this)
        btnGreen.setOnClickListener(this)
        btnYellow.setOnClickListener(this)
        btnPurple.setOnClickListener(this)
        btnRed.setOnClickListener(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(v: View) {
        val clickedBtnId : Int = v.id

        when(clickedBtnId){
            R.id.blackBtn -> playSounds(R.raw.black, "black")
            R.id.greenBtn -> playSounds(R.raw.green, "green")
            R.id.purpleBtn -> playSounds(R.raw.purple,  "purple")
            R.id.redBtn -> playSounds(R.raw.red, "red")
            R.id.yellowBtn -> playSounds(R.raw.yellow, "yellow")
        }
    }

    fun playSounds(id: Int, color: String) {
        Toast.makeText(this, "Playing sound  $color", Toast.LENGTH_SHORT).show()
        val mediaPlayer : MediaPlayer = MediaPlayer.create(this, id)
        mediaPlayer.start()
    }
}