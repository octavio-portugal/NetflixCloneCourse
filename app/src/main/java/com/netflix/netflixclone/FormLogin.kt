package com.netflix.netflixclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import kotlinx.android.synthetic.main.activity_form_login.*

class FormLogin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_login)




        var textCadastrar = text_signup

        textCadastrar.setOnClickListener {
            OpenSingnupScreen()
        }

        btn_login.setOnClickListener {

            LoginUsuario()
        }
    }

    private fun LoginUsuario(){

        var email = edit_email.text.toString()
        var senha = edit_password.text.toString()
        var mensagens = errorMessage

        if (email.isEmpty() || senha.isEmpty()){
            mensagens.setText("Coloque o seu e-mail e sua senha")
        }else{
            FirebaseAuth.getInstance().signInWithEmailAndPassword(email, senha).addOnCompleteListener {

                if (it.isSuccessful){
                    Toast.makeText(this, "Login Efetuado com Sucesso!", Toast.LENGTH_SHORT).show()
                    AbrirTelaPrincipal()
                }
            }.addOnFailureListener {
                var erro = it

                when{
                    erro is FirebaseAuthInvalidCredentialsException -> mensagens.setText("E-mail ou Senha incorretos!")
                    erro is FirebaseNetworkException -> mensagens.setText("Sem conexão com a internet!")
                    else -> mensagens.setText("Erro ao logar usuário!")
                }
            }
        }


    }

    private fun AbrirTelaPrincipal(){
        var intent = Intent(this, TelaPrincipal::class.java)
        startActivity(intent)
        finish()
    }

    private fun OpenSingnupScreen(){
        var intent = Intent(this, FormCadastro::class.java)
        startActivity(intent)

    }
}