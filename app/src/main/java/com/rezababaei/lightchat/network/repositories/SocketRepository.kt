package com.rezababaei.lightchat.network.repositories

interface SocketRepository {
    //connect
    fun connect()
    fun onConnect(callBack:() -> Unit)
    fun onConnectError()
    fun onDisconnect()

    //login
    fun login(name: String)
    fun onLogin(callBack:(Int) -> Unit)
}