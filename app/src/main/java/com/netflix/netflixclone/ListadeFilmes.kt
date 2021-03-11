package com.netflix.netflixclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import com.google.firebase.auth.FirebaseAuth
import com.netflix.netflixclone.databinding.ActivityListadeFilmesBinding
import kotlinx.android.synthetic.main.activity_listade_filmes.view.*

private lateinit var binding: ActivityListadeFilmesBinding

class ListadeFilmes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListadeFilmesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recycler_filmes = binding.recyclerview
        recycler_filmes.adapter = FilmesAdapter()
        recycler_filmes.layoutManager = GridLayoutManager(applicationContext, 3)


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

    private fun VoltarFormLogin() {
        var intent = Intent(this, FormLogin::class.java)
        startActivity(intent)
        finish()
    }
}