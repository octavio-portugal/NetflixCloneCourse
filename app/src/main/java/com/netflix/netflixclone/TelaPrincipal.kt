package com.netflix.netflixclone

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.google.firebase.auth.FirebaseAuth
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_tela_principal.*

class TelaPrincipal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_principal)

        var imagens = Uri.parse("https://firebasestorage.googleapis.com/v0/b/netflix-clone-6488a.appspot.com/o/imagens%2Fwitcher.png?alt=media&token=52e7a2ca-1f62-4649-850e-c8f79796e682")

        Picasso.get().load(imagens).fit().placeholder(R.drawable.gif).into(serie1)
        Picasso.get().load(imagens).fit().placeholder(R.drawable.gif).into(serie2)
        Picasso.get().load(imagens).fit().placeholder(R.drawable.gif).into(serie3)
        Picasso.get().load(imagens).fit().placeholder(R.drawable.gif).into(serie4)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val inflate = menuInflater
        inflate.inflate(R.menu.menu_tela_principal, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {

            R.id.item_sair -> {
                FirebaseAuth.getInstance().signOut()
                VoltarFormLogin()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun VoltarFormLogin(){
        var intent = Intent(this, FormLogin::class.java)
        startActivity(intent)
        finish()
    }
}