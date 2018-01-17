package com.example.antonio.filaclientes.esqueciSenha

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.example.antonio.filaclientes.MainActivity
import com.example.antonio.filaclientes.R
import com.example.antonio.filaclientes.registrar.RegistrarActivity
import kotlinx.android.synthetic.main.activity_esqueci_senha.*
import kotlinx.android.synthetic.main.activity_login.*

/**
 * Created by antonio on 08/01/18.
 */
class EsqueciSenha : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_esqueci_senha)

        btnRecuperarSenha.setOnClickListener(btnEsqueciSenhaClick())

    }


    fun btnEsqueciSenhaClick() : View.OnClickListener {

        return View.OnClickListener {

            Toast.makeText(this, getText(R.string.text_mensagem_enviada), Toast.LENGTH_LONG).show()

        }

    }

}