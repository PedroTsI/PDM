package com.example.gossipapp

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.RadioButton
import android.widget.TextView

class JogoActivity : AppCompatActivity() {
    private lateinit var pbTimer: ProgressBar
    private lateinit var tvTrueOrFalse: TextView
    private lateinit var tvGossip: TextView
    private lateinit var rbTrueResponse: RadioButton
    private lateinit var rbFalseResponse: RadioButton
    private lateinit var btnGuess: Button
    private lateinit var gossip: Gossip

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jogo)

        this.gossip = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra("GOSSIP", Gossip::class.java)
        } else {
            intent.getSerializableExtra("GOSSIP")
        } as Gossip

        this.pbTimer = findViewById(R.id.pbTimer)
        this.tvTrueOrFalse = findViewById(R.id.tvTrueOrFalse)
        this.tvGossip = findViewById(R.id.tvGossip)
        this.rbTrueResponse = findViewById(R.id.rbTrueResponse)
        this.rbFalseResponse = findViewById(R.id.rbFalseResponse)
        this.btnGuess = findViewById(R.id.btnGuess)

        this.tvGossip.text = gossip.descricao
        this.btnGuess.setOnClickListener{answer()}

        startTime()
    }

    fun answer(){
        if ((this.gossip.status) && (this.rbTrueResponse.isChecked)){
            setResult(RESULT_OK)
        }else if ((!this.gossip.status) && (this.rbFalseResponse.isChecked)){
            setResult(RESULT_OK)
        }
        finish()
    }

    fun startTime(){
        Thread{
            while (this.pbTimer.progress < 100){
                this.pbTimer.progress += 1
                Thread.sleep(100)
            }
            finish()
        }.start()
    }


}