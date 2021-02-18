package com.netflix.netflixclone

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.MediaController
import android.widget.Toolbar
import kotlinx.android.synthetic.main.activity_trailer_video.*

class TrailerVideo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trailer_video)

        supportActionBar!!.hide()

        var videoUrl = Uri.parse("https://firebasestorage.googleapis.com/v0/b/netflix-clone-6488a.appspot.com/o/imagens%2Fvideo%2FTHE%20WITCHER%20_%20TRAILER%20FINAL%20_%20NETFLIX.mp4?alt=media&token=09bfa2a6-17a2-4d8c-a209-70436c50bddc")

        val decordview = window.decorView
        var opcoes = View.SYSTEM_UI_FLAG_FULLSCREEN
        decordview.systemUiVisibility = opcoes

        video.setMediaController(MediaController(this))
        video.setVideoURI(videoUrl)
        video.requestFocus()
    }
}