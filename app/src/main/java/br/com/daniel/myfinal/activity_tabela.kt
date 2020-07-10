package br.com.daniel.myfinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_tabela.*

class activity_tabela : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tabela)

        //Botão tabela
        btnVoltar.setOnClickListener{
            startActivity(Intent(this@activity_tabela, MainActivity::class.java))
            finishAffinity()
        }
    }
}
