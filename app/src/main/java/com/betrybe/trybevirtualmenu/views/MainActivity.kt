package com.betrybe.trybevirtualmenu.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.betrybe.trybevirtualmenu.R
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.betrybe.trybevirtualmenu.adapters.Adapter

class MainActivity : AppCompatActivity() {
    private val plateRecyclerView by lazy { findViewById<RecyclerView>(R.id.main_menu) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val plates = MenuDB.getPlate()
        val plateAdapter = Adapter(plates)

        plateRecyclerView.layoutManager = LinearLayoutManager(this)
        plateRecyclerView.adapter = plateAdapter

    }
}
