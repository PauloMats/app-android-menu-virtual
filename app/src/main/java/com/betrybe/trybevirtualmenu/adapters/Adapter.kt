package com.betrybe.trybevirtualmenu.adapters

import Plate
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.textview.MaterialTextView
import com.betrybe.trybevirtualmenu.R
import com.betrybe.trybevirtualmenu.interfaces.ItemListener

class Adapter(
    private val plates: List<Plate>) : RecyclerView.Adapter<Adapter.PlateViewHolder>() {

    private var plateListener: ItemListener? = null

    fun setListener(listener: ItemListener) {
        this.plateListener = listener
    }

    class PlateViewHolder(itemView: View, plateListener: ItemListener?) :
        RecyclerView.ViewHolder(itemView) {

        val name: MaterialTextView = itemView.findViewById(R.id.item_menu_name)
        val image: ShapeableImageView = itemView.findViewById(R.id.item_menu_image)

        init {
            itemView.setOnClickListener {
                plateListener?.onPlateClick(itemView, adapterPosition)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlateViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_menu_layout, parent, false)
        return PlateViewHolder(view, plateListener)
    }

    override fun onBindViewHolder(holder: PlateViewHolder, position: Int) {
        holder.name.text = plates[position].name
        holder.image.setImageResource(plates[position].image)
    }

    override fun getItemCount():
            Int = plates.size
}