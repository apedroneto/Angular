package com.example.antonio.filaclientes.registrar

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.example.antonio.filaclientes.DAO.ConfiguracaoFirebase
import com.example.antonio.filaclientes.MainActivity
import com.example.antonio.filaclientes.R
import com.example.antonio.filaclientes.helper.Base64Custom
import com.example.antonio.filaclientes.helper.Menssages
import com.example.antonio.filaclientes.helper.Preferencias
import com.example.antonio.filaclientes.login.LoginActivity
import com.example.antonio.filaclientes.model.Usuario
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_registrar.*

/**
 * Created by antonio on 08/01/18.
 */
class RegistrarActivity : AppCompatActivity() {

    private var mAuth: FirebaseAuth? = null
    var autenticacao : FirebaseAuth? = null
    val configuracaoFirebase : ConfiguracaoFirebase = ConfiguracaoFirebase()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar)

        btnRegistrarUser.setOnClickListener(btnRegistrarUserClick())

        mAuth = FirebaseAuth.getInstance()

    }

    fun btnRegistrarUserClick() : View.OnClickListener {

        return View.OnClickListener {

            cadastrarUsuario()
        }

    }

    fun cadastrarUsuario() {


        if(edtSenhaRegistro.text.toString() != edtSenhaNovamente.text.toString()){
            Menssages.snackBarError( edtSenhaNovamente, "Senhas nao compativeis")
            return
        }

        if(edtEmail.text.toString() == "" || edtSenhaNovamente.text.toString() == ""){
            Menssages.snackBarError( edtSenhaNovamente, getString(R.string.text_campos_vazios))
            return
        }


        autenticacao = configuracaoFirebase.getFireBaseAutentication()
        autenticacao!!.createUserWithEmailAndPassword(edtEmail.text.toString(), edtSenhaNovamente.text.toString()).addOnCompleteListener(this) { task ->

            if (task.isSuccessful ) {

                Menssages.toastMensage(this, getString(R.string.text_usuario_cadastrado))


                var usuario : Usuario = Usuario(task.result.user.uid,
                        edtNomeUsuario.text.toString(),
                        edtEmail.text.toString(),
                        edtSenhaNovamente.text.toString(),
                        edtCpf.text.toString(),
                        "")

                usuario.salvar()

                var preferencias : Preferencias = Preferencias()
                preferencias.Preferencias(applicationContext)
                preferencias.salvar(task.result.user.uid, usuario.nome, usuario.email)

                val i: Intent = Intent(applicationContext, LoginActivity::class.java)

                Menssages.toastMensage(this, "Usuario criado com sucesso")

                startActivity(i)


                finish()

            } else {

                Menssages.snackBarError(edtCpf, "Error")

            }
        }


    }


}