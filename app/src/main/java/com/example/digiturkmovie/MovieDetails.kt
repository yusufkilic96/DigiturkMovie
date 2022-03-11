package com.example.digiturkmovie

import android.content.res.Configuration
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager

import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast

import androidx.activity.viewModels

import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet

import com.example.digiturkmovie.adapter.MovieAdapter
import com.example.digiturkmovie.databinding.ActivityMainBinding
import com.example.digiturkmovie.viewmodel.MovieViewModel

import com.google.android.exoplayer2.*
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.hls.HlsManifest
import com.google.android.exoplayer2.source.hls.HlsMediaSource
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource


class MovieDetails : AppCompatActivity(), Player.Listener {

    private lateinit var binding: ActivityMainBinding

    private lateinit var constraintLayoutRoot: ConstraintLayout
    private lateinit var exoPlayerView: PlayerView

    private lateinit var exoPlayer: ExoPlayer
    private lateinit var mediaSource: MediaSource

    private lateinit var hlsManifest: HlsManifest

    private lateinit var progressBar: ProgressBar
    private lateinit var textView: TextView

    private lateinit var urlType: URLType

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_movie_details)
        supportActionBar?.hide()

        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)


        textView = findViewById(R.id.videoTitle)
        progressBar = findViewById(R.id.progressBar)



        findView()
        initPlayer()

        if(savedInstanceState != null) {
            savedInstanceState.getInt("mediaItem").let { restoredMedia ->
                val seekTime = savedInstanceState.getLong("SeekTime")
                exoPlayer.seekTo(restoredMedia, seekTime)
                exoPlayer.play()
            }
        }

    }

    private fun findView() {
        constraintLayoutRoot = findViewById(R.id.constraintLayoutRoot)
        exoPlayerView = findViewById(R.id.exoPlayerView)
    }

    private fun initPlayer() {
        exoPlayer = ExoPlayer.Builder(this).build()
        exoPlayer.addListener(playerListener)

        exoPlayerView.player = exoPlayer
        exoPlayer.addListener(this)

        createMediaSource()


        // create media source
        exoPlayer.setMediaSource(mediaSource)

        exoPlayer.prepare()



    }

    private fun createMediaSource() {
        urlType = URLType.HLS
        urlType.url = "https://bitdash-a.akamaihd.net/content/sintel/hls/playlist.m3u8"

        exoPlayer.seekTo(0)
        when(urlType) {
            URLType.HLS -> {
                val dataSourceFactory: DataSource.Factory = DefaultHttpDataSource.Factory()
                mediaSource = HlsMediaSource.Factory(dataSourceFactory).createMediaSource(
                    MediaItem.fromUri(Uri.parse(urlType.url))
                )


                //DefaultDataSource
            }
        }




    }


    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)

        val constraintSet = ConstraintSet()
        constraintSet.connect(exoPlayerView.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, 0)
        constraintSet.connect(exoPlayerView.id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, 0)
        constraintSet.connect(exoPlayerView.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START, 0)
        constraintSet.connect(exoPlayerView.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END, 0)

        constraintSet.applyTo(constraintLayoutRoot)

        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            //hideSystemUI()
        } else {
            //showSystemUI()

            val layoutParams = exoPlayerView.layoutParams as ConstraintLayout.LayoutParams
            layoutParams.dimensionRatio = "16:9"
        }

        window.decorView.requestLayout()


    }

    //for landscape
    private fun hideSystemUI() {
        actionBar?.hide()

        window.decorView.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_FULLSCREEN
                )
    }
    private fun showSystemUI() {
        actionBar?.show()

        window.decorView.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                )
    }

    override fun onResume() {
        super.onResume()

        exoPlayer.playWhenReady = true
        exoPlayer.play()
    }

    override fun onPause() {
        super.onPause()

        exoPlayer.pause()
        exoPlayer.playWhenReady = false
    }

    override fun onStop() {
        super.onStop()

        exoPlayer.release()
        exoPlayer.playWhenReady = false
    }

    override fun onDestroy() {
        super.onDestroy()

        exoPlayer.removeListener(playerListener)
        exoPlayer.stop()
        exoPlayer.clearMediaItems()

        window.clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
    }

    private var playerListener = object: Player.Listener {
        override fun onRenderedFirstFrame() {
            super.onRenderedFirstFrame()
            if(urlType == URLType.HLS) {
                //hls stream doesnt need seek bar
                exoPlayerView.useController = false
            }
        }

        override fun onPlayerError(error: PlaybackException) {
            super.onPlayerError(error)
            Toast.makeText(this@MovieDetails, "${error.message}", Toast.LENGTH_SHORT).show()
        }

        override fun onTimelineChanged(timeline: Timeline, reason: Int) {
            super.onTimelineChanged(timeline, reason)
            val manifest = exoPlayer.currentManifest
            if(manifest != null) {
                hlsManifest = manifest as HlsManifest

                textView.text = hlsManifest.multivariantPlaylist.variants[0].url.lastPathSegment +
                        "\n" + hlsManifest.multivariantPlaylist.variants[0].format.codecs


            }
        }
    }

    override fun onPlaybackStateChanged(playbackState: Int) {
        super.onPlaybackStateChanged(playbackState)

        when(playbackState) {
            ExoPlayer.STATE_BUFFERING -> {
                progressBar.visibility = View.VISIBLE
            }
            ExoPlayer.STATE_READY -> {
                progressBar.visibility = View.INVISIBLE
            }
        }
    }

    override fun onMediaMetadataChanged(mediaMetadata: MediaMetadata) {
        super.onMediaMetadataChanged(mediaMetadata)


    }



    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putLong("SeekTime", exoPlayer.currentPosition)
        outState.putInt("mediaItem", exoPlayer.currentMediaItemIndex)
    }


}