package com.example.antonio.filaclientes

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnEntrarFila.setOnClickListener(btnEntrarFilaClick())
        btnSairFila.setOnClickListener(btnSairFilaClick())
    }

    fun btnEntrarFilaClick() : View.OnClickListener {

        return View.OnClickListener {

            Toast.makeText(this, "Entrei na fila", Toast.LENGTH_LONG).show()

        }

    }


    fun btnSairFilaClick() : View.OnClickListener {

        return View.OnClickListener {

            Toast.makeText(this, "Sai da fila", Toast.LENGTH_LONG).show()

        }

    }

}
