package com.example.antonio.filaclientes.helper

import android.content.Context
import android.widget.Toast

/**
 * Created by antonio on 18/01/18.
 */
class Menssages {

    companion object {
        fun toastMensage(contexto : Context ,texto : String) {
            Toast.makeText(contexto, texto, Toast.LENGTH_LONG).show()
        }
    }


}