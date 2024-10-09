package com.betrybe.trybevirtualmenu.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.betrybe.trybevirtualmenu.R
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.betrybe.trybevirtualmenu.adapters.Adapter
import com.betrybe.trybevirtualmenu.interfaces.ItemListener
import android.view.View
import android.content.Intent

class MainActivity : AppCompatActivity(), ItemListener {
    private val plateRecyclerView by lazy { findViewById<RecyclerView>(R.id.main_menu) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val plates = MenuDB.getPlate()
        val plateAdapter = Adapter(plates)
        plateAdapter.setListener(this)

        plateRecyclerView.layoutManager = LinearLayoutManager(this)
        plateRecyclerView.adapter = plateAdapter

    }
    override fun onPlateClick(view: View, position: Int) {
        val it = Intent(baseContext, MenuItemDetailActivity::class.java)
        it.putExtra("plate_id", position)
        startActivity(it)

    }
}
