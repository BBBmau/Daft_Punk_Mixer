package com.mau.daftpunkmixer

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View

class MenuActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
    }

    fun instagramButton(view: View){
        val uri = Uri.parse("http://instagram.com/_u/master_mau")
        val insta = Intent(Intent.ACTION_VIEW, uri)
        insta.setPackage("com.instagram.android")

        try {
            startActivity(insta)
        } catch (e: ActivityNotFoundException){
            startActivity(Intent(Intent.ACTION_VIEW,
                Uri.parse("http://instagram.com/master_mau")))
        }
    }

    fun closeMenu(view: View){
        finish()
    }
}

