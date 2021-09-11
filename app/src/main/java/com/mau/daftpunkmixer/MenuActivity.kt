package com.mau.daftpunkmixer

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback

class MenuActivity : Activity() {
    private var mInterstitialAd: InterstitialAd? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_menu)

        var adRequest = AdRequest.Builder().build()

        InterstitialAd.load(this, "ca-app-pub-4679090084656962/2791426783", adRequest, object: InterstitialAdLoadCallback()
            {
            override fun onAdFailedToLoad(p0: LoadAdError) {
                Log.d("MenuActivity", p0?.message)
                mInterstitialAd = null
                }

            override fun onAdLoaded(p0: InterstitialAd) {
                Log.d("MenuActivity", "Ad was Loaded")
                mInterstitialAd = p0
                }

            })

        mInterstitialAd?.fullScreenContentCallback =  object: FullScreenContentCallback(){
            override fun onAdDismissedFullScreenContent() {
                Log.d("MenuActivity", "Ad was Dismissed")
            }

            override fun onAdFailedToShowFullScreenContent(p0: AdError) {
                Log.d("MenuActivity", "Ad failed to show")
            }

            override fun onAdShowedFullScreenContent() {
                Log.d("MenuActivity", "Ad showed fullscreen content")
                mInterstitialAd = null
            }
        }
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

    fun buyCoffee(view: View){
        if(mInterstitialAd != null)
            mInterstitialAd?.show(this)
        else Log.d("MenuActivity", "Ad wasn't ready yet.")
    }

    fun closeMenu(view: View){
        finish()
    }
}

