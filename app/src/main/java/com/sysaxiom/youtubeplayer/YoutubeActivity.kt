package com.sysaxiom.youtubeplayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

//region Custom Imports



import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import kotlinx.android.synthetic.main.activity_youtube.*

//endregion

class YoutubeActivity : YouTubeBaseActivity(), YouTubePlayer.OnInitializedListener {

    //region Variable Initialisation
    val videoCode = "wKJ9KzGQq0w"
    val apiKey = "AIzaSyDv-gjtmZh1h9WKwQbp-aySccEFlDkxFuk"
    //endregion

    //region Activity Life Cycle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_youtube)
        initializeYoutube()

    }
    //endregion

    //region Youtube Delegate Methods
    fun initializeYoutube() {
        yt_pv.initialize(apiKey, this)
    }

    override fun onInitializationSuccess(provider: YouTubePlayer.Provider?, player: YouTubePlayer?, wasRestored: Boolean) {
        showShortToast("Youtube Api Initialization Success")
        if (!wasRestored) {
            player?.cueVideo(videoCode);
        }
    }

    override fun onInitializationFailure(p0: YouTubePlayer.Provider?, p1: YouTubeInitializationResult?) {
        showShortToast("Youtube Api Initialization Failure")
    }
    //endregion

    //region Toast
    fun showShortToast(message: CharSequence) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    fun showLongToast(message: CharSequence) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
    //endregion
}

