package com.rezababaei.lightchat.ui.chat

import androidx.lifecycle.ViewModel
import com.rezababaei.lightchat.network.repositories.SocketRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(private val socketRepository: SocketRepository): ViewModel() {

}