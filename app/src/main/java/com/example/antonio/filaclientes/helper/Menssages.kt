package com.example.antonio.filaclientes.helper

import android.app.Activity
import android.content.Context
import android.widget.Toast
import android.support.design.widget.Snackbar
import android.support.v4.R
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.antonio.filaclientes.login.LoginActivity
import de.mateware.snacky.Snacky
import android.view.Gravity




/**
 * Created by antonio on 18/01/18.
 */
class Menssages {

    companion object {
        fun toastMensage(contexto : Context ,texto : String) {
            Toast.makeText(contexto, texto, Toast.LENGTH_LONG).show()
        }

        fun showSnackbar(message: String, view: View) {
            val snackbar = Snackbar.make(view, message, Snackbar.LENGTH_LONG)
            snackbar.show()
        }

        fun snackBarSucess(activity: AppCompatActivity, texto: String) {

            Snacky.builder()
                    .setActivty(activity)
                    .setText(texto)
                    .setDuration(Snacky.LENGTH_SHORT)
                    .success()
                    .show();

        }

        fun snackBarInfo(view: View, texto: String) {
            Snacky.builder()
                    .setView(view)
                    .setText(texto)
                    .centerText()
                    .setDuration(Snacky.LENGTH_LONG)
                    .info()
                    .show();
        }

        fun snackBarWarning(activity: AppCompatActivity, texto: String) {
            val warningSnackBar = Snacky.builder()
                    .setActivty(activity)
                    .setText(texto)
                    .setDuration(Snacky.LENGTH_LONG)
                    .warning()
            warningSnackBar.addCallback(object : Snackbar.Callback() {
                override fun onShown(sb: Snackbar?) {
                    val toast = Toast.makeText(sb!!.context, "onShown Callback", Toast.LENGTH_SHORT)
                    toast.setGravity(Gravity.CENTER, 0, 0)
                    toast.show()
                }

                override fun onDismissed(sb: Snackbar?, event: Int) {
                    val toast = Toast.makeText(sb!!.context, "onDismissed Callback, event:" + event, Toast.LENGTH_SHORT)
                    toast.setGravity(Gravity.CENTER, 0, 0)
                    toast.show()
                }
            })
            warningSnackBar.show()
        }

        fun snackBarError(view: View, texto: String) {
            Snacky.builder()
                    .setView(view)
                    .setText(texto)
                    .setDuration(Snacky.LENGTH_INDEFINITE)
                    .setActionText(android.R.string.ok)
                    .error()
                    .show();
        }



    }


}