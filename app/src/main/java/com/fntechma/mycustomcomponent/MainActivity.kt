package com.fntechma.mycustomcomponent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fntechma.mycustomcomponent.components.ButtonPrimary
import com.fntechma.mycustomcomponent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnPrimaryEnabled.setEnabled {  }
        binding.btnPrimaryDisabled.setDesabled {  }


    }
}