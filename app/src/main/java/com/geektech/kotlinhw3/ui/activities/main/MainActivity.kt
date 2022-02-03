package com.geektech.kotlinhw3.ui.activities.main

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.geektech.kotlinhw3.databinding.ActivityMainBinding
import com.geektech.kotlinhw3.models.Pictures
import com.geektech.kotlinhw3.ui.activities.second.SecondActivity

class MainActivity : AppCompatActivity(){

    private lateinit var binding: ActivityMainBinding
    private val list = arrayListOf(
        Pictures("https://i.pinimg.com/564x/9b/a2/57/9ba25796112cad616be27e473ae1e149--kids-cartoon-characters-childhood-characters.jpg", false),
        Pictures("https://i.guim.co.uk/img/media/c8b1d78883dfbe7cd3f112495941ebc0b25d2265/256_0_3840_2304/master/3840.jpg?width=1200&height=900&quality=85&auto=format&fit=crop&s=579884b0bd058f1350519d3cc586d587", false),
        Pictures("https://www.liveabout.com/thmb/b_XjAEyjRIBb-loREyq24Dmg4Sg=/1000x1000/filters:no_upscale():max_bytes(150000):strip_icc()/bart-simpson-58fe1f773df78ca159b60cc2.jpg", false),
        Pictures("https://hips.hearstapps.com/digitalspyuk.cdnds.net/17/05/1486126267-mickey-mouse.jpg", false),
        Pictures("https://static.wikia.nocookie.net/172bc581-d35b-4216-9f02-2eb048d89706", false)
    )
    private lateinit var adapter: MainAdapter
    private var newList: ArrayList<Pictures> = ArrayList()
    private lateinit var launcher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        setLauncherResult()
    }

    private fun setLauncherResult() {
        launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {}
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initView() {
        adapter = MainAdapter(list)
        binding.recyclerView.adapter = adapter
        adapter.onItemClick = { picture ->

            if (picture.isSelected) {
                newList.add(picture)
            } else {
                newList.remove(picture)
            }
            adapter.notifyDataSetChanged()
        }

        binding.btnSend.setOnClickListener {
            val intent = Intent(this@MainActivity, SecondActivity::class.java)
            intent.putExtra("key", newList)
            launcher.launch(intent)
        }
    }
}