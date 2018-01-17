package com.example.antonio.filaclientes.login

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.example.antonio.filaclientes.MainActivity
import com.example.antonio.filaclientes.R
import com.example.antonio.filaclientes.esqueciSenha.EsqueciSenha
import com.example.antonio.filaclientes.registrar.RegistrarActivity
import kotlinx.android.synthetic.main.activity_login.*

/**
 * Created by antonio on 08/01/18.
 */
class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        btnLogar.setOnClickListener(btnLogarClick())
        btnRegistrar.setOnClickListener(btnRegistrarClick())
        btnEsqueciSenha.setOnClickListener(btnEsqueciSenhaClick())

    }


    fun btnLogarClick():View.OnClickListener {

        return View.OnClickListener {


            val i : Intent = Intent(applicationContext, MainActivity::class.java)

            Toast.makeText(this, "Tela Inical", Toast.LENGTH_LONG).show();

            startActivity(i)

        }

   }


    fun btnRegistrarClick():View.OnClickListener {

        return View.OnClickListener {

            val i : Intent = Intent(applicationContext, RegistrarActivity::class.java)

            Toast.makeText(this, "Tela Registrar", Toast.LENGTH_LONG).show();

            startActivity(i)



        }

    }


    fun btnEsqueciSenhaClick():View.OnClickListener {

        return View.OnClickListener {

            val i : Intent = Intent(applicationContext, EsqueciSenha::class.java)

            Toast.makeText(this, "Tela Registrar", Toast.LENGTH_LONG).show();

            startActivity(i)


        }

    }


}