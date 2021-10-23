package com.example.qrdecode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.qrdecode.databinding.ActivityDataBinding
import com.example.qrdecode.databinding.ActivityMainBinding

class DataActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDataBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}