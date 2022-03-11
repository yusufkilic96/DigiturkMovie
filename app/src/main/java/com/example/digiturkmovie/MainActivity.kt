package com.example.digiturkmovie

import android.content.Intent
import android.graphics.Movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.activity.viewModels
import androidx.constraintlayout.widget.ConstraintLayout

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import com.example.digiturkmovie.adapter.GenreAdapter
import com.example.digiturkmovie.adapter.MovieAdapter
import com.example.digiturkmovie.databinding.ActivityMainBinding

import com.example.digiturkmovie.viewmodel.MovieViewModel

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), MovieAdapter.OnItemClickListener {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MovieViewModel by viewModels()
    private lateinit var movieAdapters: MutableList<MovieAdapter>
    private lateinit var genreAdapter: GenreAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        movieAdapters = listOf(
            MovieAdapter(this),
            MovieAdapter(this),
            MovieAdapter(this),
            MovieAdapter(this),
            MovieAdapter(this),
            MovieAdapter(this),
            MovieAdapter(this),
            MovieAdapter(this),
            MovieAdapter(this),
            MovieAdapter(this),
            MovieAdapter(this),
            MovieAdapter(this),
            MovieAdapter(this),
            MovieAdapter(this),
            MovieAdapter(this),
            MovieAdapter(this),
            MovieAdapter(this),
            MovieAdapter(this),
            MovieAdapter(this)
        ) as MutableList<MovieAdapter>

        setUpRv()

    }


    override fun onItemClick(position: Int) {

        val intent = Intent(this, MovieDetails::class.java).apply {}
        startActivity(intent)
    }

    private fun setUpRv() {

        for(i in 0..18) {
            movieAdapters[i] = MovieAdapter(this)
        }



        binding.rvMovies.apply {
            adapter = movieAdapters[0]
            layoutManager = LinearLayoutManager(
                this@MainActivity, LinearLayoutManager.HORIZONTAL,
                false
            )
            setHasFixedSize(true)
            viewModel.responseMovie.observe(this@MainActivity) { listMovies ->
                movieAdapters[0].movies = listMovies
            }
        }
        binding.rvMovies2.apply {
            adapter = movieAdapters[1]
            layoutManager = LinearLayoutManager(
                this@MainActivity, LinearLayoutManager.HORIZONTAL,
                false
            )
            setHasFixedSize(true)
            viewModel.responseAdventureMovie.observe(this@MainActivity) { listMovies ->
                movieAdapters[1].movies = listMovies
            }
        }
        binding.rvMovies3.apply {
            adapter = movieAdapters[2]
            layoutManager = LinearLayoutManager(
                this@MainActivity, LinearLayoutManager.HORIZONTAL,
                false
            )
            setHasFixedSize(true)
            viewModel.responseAnimationMovie.observe(this@MainActivity) { listMovies ->
                movieAdapters[2].movies = listMovies
            }
        }
        binding.rvMovies4.apply {
            adapter = movieAdapters[3]
            layoutManager = LinearLayoutManager(
                this@MainActivity, LinearLayoutManager.HORIZONTAL,
                false
            )
            setHasFixedSize(true)
            viewModel.responseComedyMovie.observe(this@MainActivity) { listMovies ->
                movieAdapters[3].movies = listMovies
            }
        }
        binding.rvMovies5.apply {
            adapter = movieAdapters[4]
            layoutManager = LinearLayoutManager(
                this@MainActivity, LinearLayoutManager.HORIZONTAL,
                false
            )
            setHasFixedSize(true)
            viewModel.responseCrimeMovie.observe(this@MainActivity) { listMovies ->
                movieAdapters[4].movies = listMovies
            }
        }
        binding.rvMovies6.apply {
            adapter = movieAdapters[5]
            layoutManager = LinearLayoutManager(
                this@MainActivity, LinearLayoutManager.HORIZONTAL,
                false
            )
            setHasFixedSize(true)
            viewModel.responseDocumentaryMovie.observe(this@MainActivity) { listMovies ->
                movieAdapters[5].movies = listMovies
            }
        }
        binding.rvMovies7.apply {
            adapter = movieAdapters[6]
            layoutManager = LinearLayoutManager(
                this@MainActivity, LinearLayoutManager.HORIZONTAL,
                false
            )
            setHasFixedSize(true)
            viewModel.responseDramaMovie.observe(this@MainActivity) { listMovies ->
                movieAdapters[6].movies = listMovies
            }
        }
        binding.rvMovies8.apply {
            adapter = movieAdapters[7]
            layoutManager = LinearLayoutManager(
                this@MainActivity, LinearLayoutManager.HORIZONTAL,
                false
            )
            setHasFixedSize(true)
            viewModel.responseFamilyMovie.observe(this@MainActivity) { listMovies ->
                movieAdapters[7].movies = listMovies
            }
        }
        binding.rvMovies9.apply {
            adapter = movieAdapters[8]
            layoutManager = LinearLayoutManager(
                this@MainActivity, LinearLayoutManager.HORIZONTAL,
                false
            )
            setHasFixedSize(true)
            viewModel.responseFantasyMovie.observe(this@MainActivity) { listMovies ->
                movieAdapters[8].movies = listMovies
            }
        }
        binding.rvMovies10.apply {
            adapter = movieAdapters[9]
            layoutManager = LinearLayoutManager(
                this@MainActivity, LinearLayoutManager.HORIZONTAL,
                false
            )
            setHasFixedSize(true)
            viewModel.responseHorrorMovie.observe(this@MainActivity) { listMovies ->
                movieAdapters[9].movies = listMovies
            }
        }
        binding.rvMovies11.apply {
            adapter = movieAdapters[10]
            layoutManager = LinearLayoutManager(
                this@MainActivity, LinearLayoutManager.HORIZONTAL,
                false
            )
            setHasFixedSize(true)
            viewModel.responseMusicMovie.observe(this@MainActivity) { listMovies ->
                movieAdapters[10].movies = listMovies
            }
        }
        binding.rvMovies12.apply {
            adapter = movieAdapters[11]
            layoutManager = LinearLayoutManager(
                this@MainActivity, LinearLayoutManager.HORIZONTAL,
                false
            )
            setHasFixedSize(true)
            viewModel.responseHistoryMovie.observe(this@MainActivity) { listMovies ->
                movieAdapters[11].movies = listMovies
            }
        }
        binding.rvMovies13.apply {
            adapter = movieAdapters[12]
            layoutManager = LinearLayoutManager(
                this@MainActivity, LinearLayoutManager.HORIZONTAL,
                false
            )
            setHasFixedSize(true)
            viewModel.responseMysteryMovie.observe(this@MainActivity) { listMovies ->
                movieAdapters[12].movies = listMovies
            }
        }
        binding.rvMovies14.apply {
            adapter = movieAdapters[13]
            layoutManager = LinearLayoutManager(
                this@MainActivity, LinearLayoutManager.HORIZONTAL,
                false
            )
            setHasFixedSize(true)
            viewModel.responseRomanceMovie.observe(this@MainActivity) { listMovies ->
                movieAdapters[13].movies = listMovies
            }
        }
        binding.rvMovies15.apply {
            adapter = movieAdapters[14]
            layoutManager = LinearLayoutManager(
                this@MainActivity, LinearLayoutManager.HORIZONTAL,
                false
            )
            setHasFixedSize(true)
            viewModel.responseScienceMovie.observe(this@MainActivity) { listMovies ->
                movieAdapters[14].movies = listMovies
            }
        }
        binding.rvMovies16.apply {
            adapter = movieAdapters[15]
            layoutManager = LinearLayoutManager(
                this@MainActivity, LinearLayoutManager.HORIZONTAL,
                false
            )
            setHasFixedSize(true)
            viewModel.responseTVMovieMovie.observe(this@MainActivity) { listMovies ->
                movieAdapters[15].movies = listMovies
            }
        }
        binding.rvMovies17.apply {
            adapter = movieAdapters[16]
            layoutManager = LinearLayoutManager(
                this@MainActivity, LinearLayoutManager.HORIZONTAL,
                false
            )
            setHasFixedSize(true)
            viewModel.responseThrillerMovie.observe(this@MainActivity) { listMovies ->
                movieAdapters[16].movies = listMovies
            }
        }
        binding.rvMovies18.apply {
            adapter = movieAdapters[17]
            layoutManager = LinearLayoutManager(
                this@MainActivity, LinearLayoutManager.HORIZONTAL,
                false
            )
            setHasFixedSize(true)
            viewModel.responseWarMovie.observe(this@MainActivity) { listMovies ->
                movieAdapters[17].movies = listMovies
            }
        }
        binding.rvMovies19.apply {
            adapter = movieAdapters[18]
            layoutManager = LinearLayoutManager(
                this@MainActivity, LinearLayoutManager.HORIZONTAL,
                false
            )
            setHasFixedSize(true)
            viewModel.responseWesternMovie.observe(this@MainActivity) { listMovies ->
                movieAdapters[18].movies = listMovies
            }
        }

        movieAdapters[0].onItemClick = {movieItem ->
            // do something with your item
            //Log.d("TAG", movieItem.title)
        }

    }

}

enum class URLType(var url: String) {
    MP4(""), HLS(""), DASH("")
}