package com.example.lecture8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = (application as JokeApp).viewModel
        val button = findViewById<Button>(R.id.buttonView)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        val textView = findViewById<TextView>(R.id.textView)
        progressBar.visibility = View.INVISIBLE

        button.setOnClickListener {
            button.isEnabled = false
            progressBar.visibility = View.VISIBLE
            viewModel.getJoke()
        }
        viewModel.init(object : TextCallback {
            override fun provideText(text: String) = runOnUiThread {
                button.isEnabled = true
                progressBar.visibility = View.INVISIBLE
                textView.text = text
            }
        })

    }

    override fun onDestroy() {
        viewModel.clear()
        super.onDestroy()
    }
}