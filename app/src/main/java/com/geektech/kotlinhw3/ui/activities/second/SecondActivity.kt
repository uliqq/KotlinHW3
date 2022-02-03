package com.geektech.kotlinhw3.ui.activities.second

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.geektech.kotlinhw3.databinding.ActivitySecondBinding
import com.geektech.kotlinhw3.models.Pictures

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    private lateinit var list: ArrayList<Pictures>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView() {
        list = intent.getSerializableExtra("key") as ArrayList<Pictures>
        val adapter = SecondAdapter(list)
        binding.recyclerView.adapter = adapter

        binding.btnBack.setOnClickListener {
            val intent = Intent()
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}