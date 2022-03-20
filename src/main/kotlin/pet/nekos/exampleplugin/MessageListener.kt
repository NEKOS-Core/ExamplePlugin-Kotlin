package pet.nekos.exampleplugin

import pet.nekos.api.event.Listener
import pet.nekos.api.event.EventHandler
import pet.nekos.api.event.EventPriority
import pet.nekos.api.event.message.MessageEvent

class MessageListener : Listener {
    @EventHandler(EventPriority.NORMAL)
    fun onMessage(e: MessageEvent) {
        println("Very WIP! Testing message...")
    }   
}