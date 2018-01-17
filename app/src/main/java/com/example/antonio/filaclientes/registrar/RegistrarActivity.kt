package com.example.antonio.filaclientes.registrar

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.example.antonio.filaclientes.R
import kotlinx.android.synthetic.main.activity_registrar.*

/**
 * Created by antonio on 08/01/18.
 */
class RegistrarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar)

        btnRegistrarUser.setOnClickListener(btnRegistrarUserClick())

    }

    fun btnRegistrarUserClick() : View.OnClickListener {

        return View.OnClickListener {

            Toast.makeText(this, "Usuario Registrado", Toast.LENGTH_LONG).show()

            finish()


        }

    }


}