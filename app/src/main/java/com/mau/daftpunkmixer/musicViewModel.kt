package com.mau.daftpunkmixer

import androidx.lifecycle.ViewModel

class MusicViewModel : ViewModel() {
    private var _pitchIndex = 0

    val pitchIndex: Int
        get() = _pitchIndex
    }