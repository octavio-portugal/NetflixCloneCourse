package com.netflix.netflixclone

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_tela_serie.*

class TelaSerie : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_serie)

        var imagemDoVideo = Uri.parse("https://firebasestorage.googleapis.com/v0/b/netflix-clone-6488a.appspot.com/o/imagens%2Fvideo.jpg?alt=media&token=f751f201-a813-434d-a3a2-9e8a4b20813e")
        Picasso.get().load(imagemDoVideo).fit().into(image_video)


        play_video.setOnClickListener {

            var intent = Intent(this, TrailerVideo::class.java)
            startActivity(intent)
        }
    }
}