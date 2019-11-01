
package com.mobilite.core

class ServiceHolder {

    lateinit var myService: CoreService

    fun get(): CoreService? {
        return myService
    }

    fun set(myService: CoreService) {
        this.myService = myService
    }

}