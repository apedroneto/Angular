package com.example.antonio.filaclientes.DAO

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

/**
 * Created by antonio on 18/01/18.
 */
class ConfiguracaoFirebase {

    var referenciaFirebase : DatabaseReference? = null
    var autenticacao : FirebaseAuth? = null

    fun getFireBase() : DatabaseReference? {

        if(referenciaFirebase == null) {
            referenciaFirebase = FirebaseDatabase.getInstance().getReference()
        }

        return referenciaFirebase
    }

    fun getFireBaseAutentication(): FirebaseAuth? {

        if(autenticacao == null) {
            autenticacao = FirebaseAuth.getInstance()
        }

        return autenticacao

    }

}