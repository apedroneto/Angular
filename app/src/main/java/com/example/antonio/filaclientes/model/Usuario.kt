package com.example.antonio.filaclientes.model

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.util.*
import kotlin.collections.HashMap

/**
 * Created by antonio on 18/01/18.
 */
class Usuario constructor(var id : String, var nome : String, var email : String, var senha : String, var cpf : String, var foto : String) {


    private var mDatabaseReference: DatabaseReference? = null
    private var mDatabase: FirebaseDatabase? = null
    private var mAuth: FirebaseAuth? = null




    fun salvar() {
        mDatabase = FirebaseDatabase.getInstance()
        mDatabaseReference = mDatabase!!.reference!!.child("usuario")

        mDatabaseReference!!.child(cpf).setValue(toMap())
    }

    fun toMap() : Map<String, String> {

        var hashMapUsuario = HashMap<String, String>()

        hashMapUsuario.put("id", id)
        hashMapUsuario.put("nome", nome)
        hashMapUsuario.put("email", email)
        hashMapUsuario.put("senha", senha)
        hashMapUsuario.put("cpf", cpf)
        hashMapUsuario.put("foto", foto)

        return hashMapUsuario

    }

}