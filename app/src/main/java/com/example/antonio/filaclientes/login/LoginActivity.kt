package com.example.antonio.filaclientes.login

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.antonio.filaclientes.DAO.ConfiguracaoFirebase
import com.example.antonio.filaclientes.MainActivity
import com.example.antonio.filaclientes.R
import com.example.antonio.filaclientes.esqueciSenha.EsqueciSenha
import com.example.antonio.filaclientes.registrar.RegistrarActivity
import com.example.antonio.filaclientes.helper.Menssages
import com.example.antonio.filaclientes.helper.Preferencias
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import de.mateware.snacky.Snacky
import kotlinx.android.synthetic.main.activity_login.*

/**
 * Created by antonio on 08/01/18.
 */
class LoginActivity : AppCompatActivity() {

    var autenticacao: FirebaseAuth? = null
    val configuracaoFirebase: ConfiguracaoFirebase = ConfiguracaoFirebase()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        btnLogar.setOnClickListener(btnLogarClick())
        btnRegistrar.setOnClickListener(btnRegistrarClick())
        btnEsqueciSenha.setOnClickListener(btnEsqueciSenhaClick())

    }


    fun btnLogarClick(): View.OnClickListener {

        return View.OnClickListener {

            if((edtUsuario.text.toString() == "" || edtSenha.text.toString() == "")) {
                Menssages.snackBarError( edtSenha, getString(R.string.text_campos_vazios))

            } else {

                validaLogin()
            }

        }

    }


    fun btnRegistrarClick(): View.OnClickListener {

        return View.OnClickListener {

            val i: Intent = Intent(applicationContext, RegistrarActivity::class.java)

            startActivity(i)

        }

    }


    fun btnEsqueciSenhaClick(): View.OnClickListener {

        return View.OnClickListener {

            val i: Intent = Intent(applicationContext, EsqueciSenha::class.java)

            Menssages.toastMensage(this, "Tela Registrar")

            startActivity(i)


        }

    }

    fun validaLogin() {

        autenticacao = configuracaoFirebase.getFireBaseAutentication()
        autenticacao!!.signInWithEmailAndPassword(edtUsuario.text.toString(), edtSenha.text.toString()).addOnCompleteListener(this) { task ->

            if (task.isSuccessful) {
                val i: Intent = Intent(applicationContext, MainActivity::class.java)

                Menssages.toastMensage(this, getString(R.string.text_login_sucesso))

                var preferencias : Preferencias = Preferencias()
                preferencias.Preferencias(applicationContext)
                preferencias.salvar(task.result.user.uid,"null", edtUsuario.text.toString())


                startActivity(i)
            } else {

                Menssages.snackBarError( edtSenha, getString(R.string.text_login_fail))

            }
        }


    }
}