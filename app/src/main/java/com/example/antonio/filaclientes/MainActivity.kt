package com.example.antonio.filaclientes

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.antonio.filaclientes.DAO.ConfiguracaoFirebase
import com.example.antonio.filaclientes.helper.Menssages
import com.example.antonio.filaclientes.helper.Preferencias
import com.google.firebase.database.DatabaseReference
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var databaseReference : DatabaseReference? = null
    var configuracaoFirebase : ConfiguracaoFirebase = ConfiguracaoFirebase()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnEntrarFila.setOnClickListener(btnEntrarFilaClick())
        btnSairFila.setOnClickListener(btnSairFilaClick())

        var preferencias : Preferencias = Preferencias()
        preferencias.Preferencias(applicationContext)
        txtPosicao.setText(preferencias.getNome())
    }

    fun btnEntrarFilaClick() : View.OnClickListener {

        return View.OnClickListener {

            databaseReference = configuracaoFirebase.getFireBase()?.child("fila")?.child("homem")
            databaseReference?.child("pedro")?.setValue("1")

            Menssages.toastMensage(this, "Usuario Entrou na fila")

        }

    }


    fun btnSairFilaClick() : View.OnClickListener {

        return View.OnClickListener {

            Toast.makeText(this, "Sai da fila", Toast.LENGTH_LONG).show()

        }

    }

}
