package com.betrybe.trybevirtualmenu.interfaces
import android.view.View

interface ItemListener {
    fun onPlateClick(view: View, position: Int)
}