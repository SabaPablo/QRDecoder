package com.example.qrdecode

import android.content.Intent
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.qrdecode.databinding.ActivityMainBinding
import com.google.zxing.integration.android.IntentIntegrator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnScanner.setOnClickListener { initScanner() }
    }

    private fun initScanner(){
        IntentIntegrator(this).initiateScan()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (result != null) {
            if (result.contents == null) {
                binding.conta.visibility = View.GONE
                Toast.makeText(this, "Cancelado", Toast.LENGTH_LONG).show()
            } else {
                binding.conta.visibility = View.VISIBLE
                Toast.makeText(this, "El valor escaneado es: " + result.contents, Toast.LENGTH_LONG).show()
                val res = result.contents.split("@")
                binding.nroTramite.text = res[0]
                binding.surNameTx.text = res[1]
                binding.nameBx.text = res[2]
                binding.sexTx.text = res[3]
                binding.birtdayTx.text = res[6]
                binding.emitionTx.text = res[7]
                binding.cuitTx.text = res[8]

            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

}