package com.example.project2

import android.media.MediaPlayer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModel: ViewModel() {

    private val PressedTimeInMillis = MutableLiveData<Long>()
    val pressedTimeInMillis: LiveData<Long> = PressedTimeInMillis
    private var musicPlayer = MutableLiveData<MediaPlayer>()
    var music: LiveData<MediaPlayer> = musicPlayer
    private val currTimeMS = MutableLiveData<Long>()
    val currentTimeInMillis: LiveData<Long> = currTimeMS
    private val currTime = MutableLiveData<String>()
    val currentTime: LiveData<String> = currTime


    private val isMusicPlayedFromBeggining = MutableLiveData<Boolean>()
    val musicPlayedFromBeggining: LiveData<Boolean> = isMusicPlayedFromBeggining



    fun setCurrTimeMS(time: Long) {
        currTimeMS.value = time
    }
    }

    
}