package com.example.unlimint

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.unlimint.databinding.JokeItemLayoutBinding

class JokesAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var jokesList:List<String> = mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val holderPostBinding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context), R.layout.joke_item_layout, parent, false
        )
        return PostViewHolder(holderPostBinding)
    }

    override fun getItemCount(): Int = if (jokesList.isNullOrEmpty()) 0 else jokesList.size

    private fun getItem(position: Int): String = jokesList[position]

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PostViewHolder).onBind(getItem(position))
    }


    fun updateData(list: List<String>) {
        jokesList = list
        notifyDataSetChanged()
    }

    private inner class PostViewHolder(private val viewDataBinding: ViewDataBinding) :
        RecyclerView.ViewHolder(viewDataBinding.root) {

        fun onBind(joke: String) {
            (viewDataBinding as JokeItemLayoutBinding).tvItem.text = joke
        }
    }
}