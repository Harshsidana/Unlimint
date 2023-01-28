package com.example.unlimint

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.unlimint.viewmodel.JokesViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val viewModel: JokesViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.getJokes()

    }
}