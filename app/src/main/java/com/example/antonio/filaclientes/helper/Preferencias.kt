package com.example.antonio.filaclientes.helper

import android.content.Context
import android.content.SharedPreferences

/**
 * Created by antonio on 18/01/18.
 */
class Preferencias {

    var context : Context? = null
    var preferences : SharedPreferences? = null
    val NOME_ARQUIVO = "projetoFila.preferencias"
    val MODE = 0
    var editor : SharedPreferences.Editor? = null

    val CHAVE_IDENTIFICADOR = "identificarUsuarioLogado"
    val CHAVE_NOME = "nomeUsuarioLogado"
    val CHAVE_EMAIL = "emailUsuarioLogado"

    fun Preferencias(context: Context) {
        this.context = context
        this.preferences = context.getSharedPreferences(NOME_ARQUIVO, MODE)
        this.editor = preferences!!.edit()

    }

    fun salvar(identificadorUsuario : String, nomeUsuario : String, email : String) {

        if(editor != null) {
            editor!!.putString(CHAVE_IDENTIFICADOR, identificadorUsuario)
            editor!!.putString(CHAVE_NOME, nomeUsuario)
            editor!!.putString(CHAVE_NOME, email)
            editor!!.commit()
        }


    }




    fun getIdentificador() : String {

        return preferences!!.getString(CHAVE_IDENTIFICADOR, null)

    }



    fun setEmail(email: String) {

        if(editor != null){

            editor!!.putString(CHAVE_EMAIL, email)

        }

    }

    fun getNome() : String {

        return preferences!!.getString(CHAVE_NOME, null)

    }

    fun getEmail() : String {

        return preferences!!.getString(CHAVE_EMAIL, null)

    }


}