package com.example.unlimint

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.unlimint.databinding.ActivityMainBinding
import com.example.unlimint.viewmodel.JokesViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    var binding: ActivityMainBinding? = null

    private val viewModel: JokesViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        getJokes()
        val adapter = JokesAdapter()
        binding?.rvJokes?.adapter=adapter
        viewModel.getJokesLiveData().observe(this) { jokesList ->
            adapter.updateData(jokesList)
        }
    }

    private fun getJokes() {
        viewModel.getJokes()
    }
}