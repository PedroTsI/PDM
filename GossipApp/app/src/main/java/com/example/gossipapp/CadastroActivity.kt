package com.example.gossipapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton

class CadastroActivity : AppCompatActivity() {
    private lateinit var btnCancel: Button
    private lateinit var etFofoca: EditText
    private lateinit var rbTrue: RadioButton
    private lateinit var rbFalse: RadioButton
    private lateinit var btnSave: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        this.btnCancel = findViewById(R.id.btnCancel)
        this.etFofoca = findViewById(R.id.etFofoca)
        this.rbFalse = findViewById(R.id.rbFalse)
        this.rbTrue = findViewById(R.id.rbTrue)
        this.btnSave = findViewById(R.id.btnSave)
        this.btnSave.setOnClickListener{save()}
        this.btnCancel.setOnClickListener{back()}
    }

    fun save(){
        val descricao = this.etFofoca.text.toString()
        val status = this.rbTrue.isChecked
        val gossip = Gossip(descricao, status)
        val intent = Intent().apply{
            putExtra("GOSSIP", gossip)
        }
        setResult(RESULT_OK, intent)
        finish()
    }

    fun back(){
        finish()
    }
}