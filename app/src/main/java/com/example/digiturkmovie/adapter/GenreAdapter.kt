package com.example.digiturkmovie.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.digiturkmovie.databinding.GenreLayoutAdapterBinding
import com.example.digiturkmovie.databinding.MovieLayoutAdapterBinding
import com.example.digiturkmovie.models.MovieItem

class GenreAdapter{


    private val diffCalback = object : DiffUtil.ItemCallback<MovieItem>() {
        override fun areItemsTheSame(oldItem: MovieItem, newItem: MovieItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MovieItem, newItem: MovieItem): Boolean {
            return newItem == oldItem
        }

    }


    inner class MyGenreViewHolder(val binding: GenreLayoutAdapterBinding):
        RecyclerView.ViewHolder(binding.root) {


    }


}