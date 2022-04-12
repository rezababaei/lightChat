package com.rezababaei.lightchat.network.repositories

import android.util.Log
import io.socket.client.Socket

import javax.inject.Inject


class SocketRepositoryImpl @Inject constructor(private val mSocket: Socket) : SocketRepository {

    companion object {
        private const val TAG = "SocketRepositoryImpl"

        private const val NEW_MESSAGE = "new message"
        private const val ADD_USER = "add user"
        private const val USER_LEFT = "user left"
        private const val USER_JOIN = "user joined"
        private const val TYPING = "typing"
        private const val STOP_TYPING = "stop typing"
        private const val LOGIN = "login"
    }

    override fun connect() {
        mSocket.connect()
    }


    override fun onConnect(callBack: () -> Unit)  {
        mSocket.on(Socket.EVENT_CONNECT) {
            callBack.invoke()
            Log.i(TAG, "onConnect: Called")
        }
    }

    override fun onConnectError() {
        mSocket.on(Socket.EVENT_CONNECT_ERROR) {
            Log.i(TAG, "onConnectError: called ${it[0]}")
        }
    }

    override fun onDisconnect() {
        mSocket.on(Socket.EVENT_DISCONNECT) {
            Log.i(TAG, "onDisconnect: called")
        }
    }


    override fun login(name: String) {
    mSocket.emit(ADD_USER,name)
    }

    override fun onLogin(callBack: (Int) -> Unit) {
        mSocket.on(LOGIN){
          callBack.invoke(0) //
        }
    }


}