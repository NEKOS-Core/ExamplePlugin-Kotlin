package pet.nekos.exampleplugin

import pet.nekos.api.plugin.Plugin
import pet.nekos.api.event.Listener
import pet.nekos.api.event.EventHandler
import pet.nekos.api.event.message.MessageEvent

class ExamplePlugin() : Plugin(), Listener {

    @EventHandler
    fun onMessage(e: MessageEvent) {
        println("Very WIP! Testing message... Content passed along was: " + e.content)
    }   
    
}