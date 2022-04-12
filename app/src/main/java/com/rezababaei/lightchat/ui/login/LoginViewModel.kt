package com.rezababaei.lightchat.ui.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rezababaei.lightchat.network.repositories.SocketRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val socketRepository: SocketRepository) :
    ViewModel() {
    companion object {
        private const val TAG = "LoginViewModel"
    }

    private var isConnected = false
    val userName = MutableLiveData<String>()

    private val _successfulLogin = MutableLiveData(false)
     val successfulLogin: LiveData<Boolean>
        get() = _successfulLogin

    init {
        socketRepository.onConnect {
            Log.i(TAG, "viewModel connect called")
            isConnected = true
        }
        socketRepository.onConnectError()
        socketRepository.onDisconnect()
        socketRepository.onLogin {
//            _successfulLogin.value=true it has error because of different threads
            _successfulLogin.postValue(true)


        }
        socketRepository.connect()
    }

    fun login() {
        if (isConnected) {
            userName.value?.let { socketRepository.login(it) }
        }
    }
}