package com.betrybe.trybevirtualmenu.views

import MenuDB
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.betrybe.trybevirtualmenu.R
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.textview.MaterialTextView

class MenuItemDetailActivity : AppCompatActivity() {

    private val planeName : MaterialTextView by lazy { findViewById(R.id.detail_name) }
    private val plateImage : ShapeableImageView by lazy { findViewById(R.id.detail_image) }
    private val plateDescription : MaterialTextView by lazy { findViewById(R.id.detail_description) }
    private val platePrice : MaterialTextView by lazy { findViewById(R.id.detail_price) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_item_detail)

        val plateId = intent.getIntExtra("plate_id", 0)

        val plate = MenuDB.getPlateById(plateId + 1)!!

        planeName.text = plate.name
        plateDescription.text = plate.desc
        platePrice.text = plate.price
        plateImage.setImageResource(plate.image)
    }
}
