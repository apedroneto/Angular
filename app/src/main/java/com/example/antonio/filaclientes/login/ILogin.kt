package com.example.antonio.filaclientes.login

/**
 * Created by antonio on 08/01/18.
 */
interface ILogin {

    fun logar(usuario:String, senha:String) : Boolean

    fun deslogar() : Boolean

    fun esqueciSenha(email : String) : Boolean

    fun registrar(usuario:String, senha: String, email:String, cpf: String) : Boolean


}