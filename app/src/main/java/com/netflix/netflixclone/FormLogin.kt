package com.netflix.netflixclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_form_login.*

class FormLogin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_login)

        var textCadastrar = text_signup

        textCadastrar.setOnClickListener {
            OpenSingnupScreen()
        }
    }
    private fun OpenSingnupScreen(){
        var intent = Intent(this, FormCadastro::class.java)
        startActivity(intent)

    }
}