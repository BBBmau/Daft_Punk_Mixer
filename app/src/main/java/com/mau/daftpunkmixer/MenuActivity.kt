package com.mau.daftpunkmixer

import android.app.Activity
import android.os.Bundle
import android.view.View

class MenuActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
    }

    fun closeMenu(view: View){
        finish()
    }
}

