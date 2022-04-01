package pet.nekos.exampleplugin

import pet.nekos.api.plugin.Plugin
import pet.nekos.api.event.Listener
import pet.nekos.api.event.EventHandler
import pet.nekos.api.event.EventPriority
import pet.nekos.api.event.message.MessageEvent

import java.io.File

class ExamplePlugin() : Plugin(), Listener {
 
    override fun onEnable() {
        this.server?.pluginManager?.registerEvents(this, this)
        isEnabled = true
    }

    @EventHandler(EventPriority.NORMAL)
    fun onMessage(e: MessageEvent) {
        println("Very WIP! Testing message... Content passed along was: " + e.content)
    }   
    
}