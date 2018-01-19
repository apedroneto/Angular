package com.example.antonio.filaclientes

import android.opengl.Visibility
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.antonio.filaclientes.DAO.ConfiguracaoFirebase
import com.example.antonio.filaclientes.helper.Menssages
import com.example.antonio.filaclientes.helper.Preferencias
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var databaseReference : DatabaseReference? = null
    val configuracaoFirebase : ConfiguracaoFirebase = ConfiguracaoFirebase()

    var posicaoAtualFila : Int? = null

    val preferencias : Preferencias = Preferencias()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnEntrarFila.setOnClickListener(btnEntrarFilaClick())
        btnSairFila.setOnClickListener(btnSairFilaClick())


        preferencias.Preferencias(applicationContext)

        btnEntrarFila.visibility = View.GONE
        btnSairFila.visibility = View.GONE

        getTotalFila()

        getPosicaoUser()


    }

    fun btnEntrarFilaClick() : View.OnClickListener {

        return View.OnClickListener {

            databaseReference = configuracaoFirebase.getFireBase()?.child("fila")?.child("posicao")

            databaseReference?.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {

                    if(snapshot.value == null){
                        databaseReference?.setValue(0)
                    }

                    databaseReference?.orderByValue()

                    var arrayList : List<DataSnapshot> = snapshot.children.toList()

                    txtPosicao!!.text = snapshot.value.toString()


                }
                override fun onCancelled(databaseError: DatabaseError) {

                }
            })

            Menssages.toastMensage(this, "Usuario Entrou na fila")

            if(posicaoAtualFila != null) {
                databaseReference?.setValue(posicaoAtualFila!! + 1)
            }
            setPosicaoUser()

        }

    }

    fun setPosicaoUser() {

        databaseReference = configuracaoFirebase.getFireBase()?.child("fila")?.child("posicaoUser")?.child(preferencias.getIdentificador())

        databaseReference?.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                if(snapshot.value == null){
                    databaseReference?.setValue(-1)
                }

                txtPosicaoUser!!.text = snapshot.value.toString()


            }
            override fun onCancelled(databaseError: DatabaseError) {

            }
        })


        if(posicaoAtualFila != null) {
            databaseReference?.setValue(posicaoAtualFila!! + 1)
        }
    }


    fun getPosicaoUser() {

        databaseReference = configuracaoFirebase.getFireBase()?.child("fila")?.child("posicaoUser")?.child(preferencias.getIdentificador())

        databaseReference?.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                if(snapshot.value == null){
                    databaseReference?.setValue(-1)
                }

                txtPosicaoUser.text = snapshot.value.toString()

                if(snapshot.value.toString() == "-1"){
                    btnEntrarFila.visibility = View.VISIBLE
                    btnSairFila.visibility = View.GONE
                }else{
                    btnSairFila.visibility = View.VISIBLE
                    btnEntrarFila.visibility = View.GONE

                }


            }
            override fun onCancelled(databaseError: DatabaseError) {

            }
        })


    }


    fun getTotalFila() {

        databaseReference = configuracaoFirebase.getFireBase()?.child("fila")?.child("posicao")

        databaseReference?.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                if(snapshot.value.toString() == null){
                    databaseReference?.setValue(0)
                }

                txtPosicao!!.text = snapshot.value.toString()


            }
            override fun onCancelled(databaseError: DatabaseError) {

            }
        })


    }

    fun btnSairFilaClick() : View.OnClickListener {

        return View.OnClickListener {

            databaseReference = configuracaoFirebase.getFireBase()?.child("fila")

            databaseReference?.child("posicao")?.setValue(posicaoAtualFila!! - 1)

            databaseReference?.child("posicaoUser")?.child(preferencias.getIdentificador())?.setValue(-1)



        }

    }

}
