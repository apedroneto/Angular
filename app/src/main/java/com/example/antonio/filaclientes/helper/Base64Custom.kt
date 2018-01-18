package com.example.antonio.filaclientes.helper

import android.util.Base64


/**
 * Created by antonio on 18/01/18.
 */
class Base64Custom {

    companion object {
        fun codificarBase64(texto : String) : String {
            return Base64.encodeToString(texto.toByteArray(), Base64.DEFAULT).replace("(\\n|\\r)", "")
        }

        fun decodificarBase64(texto: String) : String {
            return String(Base64.decode(texto.toByteArray(), Base64.DEFAULT))
        }
    }

}