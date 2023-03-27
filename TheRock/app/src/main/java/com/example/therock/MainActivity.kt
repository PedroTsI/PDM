package com.example.therock

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.therock.game.Therock

class MainActivity : AppCompatActivity() {

    private lateinit var tvMenor: TextView
    private lateinit var tvMaior: TextView
    private lateinit var tvStatus: TextView
    private lateinit var etChute: EditText
    private lateinit var btnChutar: Button
    private lateinit var therock: Therock
    private lateinit var btnReset: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.tvMenor = findViewById(R.id.tvMenor)
        this.tvMaior = findViewById(R.id.tvMaior)
        this.tvStatus = findViewById(R.id.tvStatus)
        this.etChute = findViewById(R.id.etChute)
        this.btnChutar = findViewById(R.id.btnChutar)
        this.btnReset = findViewById(R.id.btnReset)

        this.therock = Therock(1,100)

        this.f5()

        this.btnReset.setOnClickListener {
            this.therock = Therock(1, 100)
            f5()
            Toast.makeText(this, "Novo Jogo!", Toast.LENGTH_SHORT).show()
        }

        this.btnChutar.setOnClickListener(ClickBotao())

        this.tvMenor.text = this.therock.menor.toString()
        this.tvMaior.text = this.therock.maior.toString()
        this.tvStatus.text = this.therock.status.toString()
    }
    fun chutar(){
        var valor = this.etChute.text.toString().toInt()
        var resposta = this.therock.jogar(valor)
        if (resposta > 0){
            Toast.makeText(this, "Seu chute é maior!", Toast.LENGTH_SHORT).show()
        }else if (resposta < 0){
            Toast.makeText(this, "Seu chute é menor!", Toast.LENGTH_SHORT).show()
        }else{
        }
        f5()
    }

    fun f5(){
        this.tvMenor.text = this.therock.menor.toString()
        this.tvMaior.text = this.therock.maior.toString()
        this.tvStatus.text = this.therock.status.toString()
        this.etChute.text.clear()
    }

    inner class ClickBotao: View.OnClickListener {
        override fun onClick(v: View?) {
            var valor = this@MainActivity.etChute.text.toString().toInt()
            var resposta = this@MainActivity.therock.jogar(valor)
            if (resposta > 0){
                Toast.makeText(this@MainActivity, "Seu chute é maior!", Toast.LENGTH_SHORT).show()
            }else if (resposta < 0){
                Toast.makeText(this@MainActivity, "Seu chute é menor!", Toast.LENGTH_SHORT).show()
            }else{
            }
            f5()
        }

    }
}