package com.example.gossipapp

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    private lateinit var tvMain: TextView
    private lateinit var btnJogar: Button
    private lateinit var btnCadastrar: Button
    private var cadastro: Cadastro

    init {
        this.cadastro = Cadastro()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.tvMain = findViewById(R.id.tvMain)
        this.btnJogar = findViewById(R.id.btnJogar)
        this.btnCadastrar = findViewById(R.id.btnCadastrar)

        var formResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if (it.resultCode == RESULT_OK){
                val gossip = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    it.data?.getSerializableExtra("GOSSIP", Gossip::class.java)
                } else {
                    it.data?.getSerializableExtra("GOSSIP")
                } as Gossip
                this.cadastro.add(gossip)
                Toast.makeText(this, "Gossip Cadastrada com sucesso" , Toast.LENGTH_SHORT).show()
            }
        }

        var playResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if (it.resultCode == RESULT_OK){
                Toast.makeText(this, "Ganhou!", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Perdeu!", Toast.LENGTH_SHORT).show()
            }
        }

        this.btnCadastrar.setOnClickListener {
            val intent = Intent(this, CadastroActivity::class.java)
            formResult.launch(intent)
        }
        this.btnJogar.setOnClickListener{
            val gossip = this.cadastro.get()
            val intent = Intent(this, JogoActivity::class.java).apply {
                putExtra("GOSSIP", gossip)
            }
            playResult.launch(intent) }
    }


    fun play(){
        val intent = Intent(this, JogoActivity::class.java)
        startActivity(intent)
    }


}

