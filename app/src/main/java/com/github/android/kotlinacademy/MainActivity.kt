package com.github.android.kotlinacademy

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var items: MutableList<Item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = findViewById<RecyclerView>(R.id.rv_club)
        initData()

        list.layoutManager = LinearLayoutManager(this)
        list.adapter = ItemAdapter(this, items) {
            Log.d("Items ", it.name)
            val toast = Toast.makeText(applicationContext, it.name, Toast.LENGTH_SHORT)
            toast.show()
        }
    }

    private fun initData() {

        val name = resources.getStringArray(R.array.club_name)
        val image = resources.obtainTypedArray(R.array.club_image)

        items.clear()

        for (i in name.indices) {
            items.add(Item(name[i], image.getResourceId(i, 0)))
        }

        image.recycle()
    }
}
