package com.netflix.netflixclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.*
import kotlinx.android.synthetic.main.activity_form_cadastro.*

class FormCadastro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_cadastro)

        btn_login.setOnClickListener {

            CadastrarUsuario()
        }
    }

    private fun CadastrarUsuario() {

        var email = edit_email.text.toString()
        var senha = edit_password.text.toString()
        var mensagens = errorMessage

        if (email.isEmpty() || senha.isEmpty()) {
            mensagens.setText("Coloque o seu e-mail e sua senha!")
        } else {
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, senha)
                .addOnCompleteListener(this) {

                    if (it.isSuccessful) {
                        Toast.makeText(this, "Cadastro realizado com Sucesso!", Toast.LENGTH_SHORT).show()
                        VoltarParaTelaDeLogin()

                    }
                }.addOnFailureListener {
                    var erro = it

                    when {

                        erro is FirebaseAuthInvalidCredentialsException -> mensagens.setText("Digite um e-mail valido")
                        erro is FirebaseAuthWeakPasswordException -> mensagens.setText("Digite uma senha com no mínimo 6 caracteres!")
                        erro is FirebaseAuthUserCollisionException -> mensagens.setText("Esta conta já foi cadastrada!")
                        erro is FirebaseNetworkException -> mensagens.setText("Sem conexão com a internet!")
                        else -> mensagens.setText("Erro ao cadastrar o usúario")
                    }
                }
        }
    }
    private fun VoltarParaTelaDeLogin(){
        var intent = Intent(this, FormLogin::class.java)
        startActivity(intent)
        finish()
    }

}
