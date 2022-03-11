package com.example.digiturkmovie.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.digiturkmovie.databinding.MovieLayoutAdapterBinding
import com.example.digiturkmovie.models.MovieItem

class MovieAdapter(private val listener: OnItemClickListener): RecyclerView.Adapter<MovieAdapter.MyViewHolder>() {

    private val adapterData = mutableListOf<Int>()


    var onItemClick: ((MovieItem) -> Unit)? = null

    private val diffCalback = object : DiffUtil.ItemCallback<MovieItem>() {
        override fun areItemsTheSame(oldItem: MovieItem, newItem: MovieItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MovieItem, newItem: MovieItem): Boolean {
            return newItem == oldItem
        }

    }

    private val differ = AsyncListDiffer(this, diffCalback)
    var movies:List<MovieItem>



    get() = differ.currentList
    set(value) {
        differ.submitList(value)
    }

    inner class MyViewHolder(val binding: MovieLayoutAdapterBinding):
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {
            init {
                itemView.setOnClickListener(this)
            }

            override fun onClick(p0: View?) {
                val position: Int = adapterPosition
                if(position != RecyclerView.NO_POSITION) {
                    listener.onItemClick(position)
                }

            }

    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(MovieLayoutAdapterBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        ))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentMovie = movies[position]

        holder.binding.apply {
            textView.text = currentMovie.title
            imageView.load("https://image.tmdb.org/t/p/w185"+currentMovie.poster_path){
                crossfade(true)
                crossfade(1000)
            }
        }
    }


    override fun getItemCount() = movies.size
}