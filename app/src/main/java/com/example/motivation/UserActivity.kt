package com.example.motivation

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.motivation.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var binding: ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSave.setOnClickListener(this)

        supportActionBar?.hide()
    }

    override fun onClick(view: View) {
        if(view.id == R.id.btn_save) {
            handleSave()
        }
    }

    private fun handleSave() {
        val name: String = binding.editName.text.toString()
        if(name != "") {
            SecurityPreferences(this).storeString("USER_NAME", name)
            //Leva para a
            startActivity(Intent(this, MainActivity::class.java))
            //Destruindo a volta para a tela antiga (cadastrar nome), bom para telas de login por exemplo
            finish()
        } else {
            Toast.makeText(this, R.string.validation_mandatory_name, Toast.LENGTH_SHORT).show()
        }
    }
}