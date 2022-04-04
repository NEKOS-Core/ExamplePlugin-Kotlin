package pet.nekos.exampleplugin

import pet.nekos.api.plugin.Plugin
import pet.nekos.api.event.Listener
import pet.nekos.api.event.EventHandler
import pet.nekos.api.event.message.MessageEvent

import pet.nekos.api.message.ChatMessage

class ExamplePlugin() : Plugin(), Listener {

    @EventHandler
    fun onMessage(e: MessageEvent) {
        println(e.msg)
        println("Very WIP!" + "\nName: " + e.msg.user.name + "\nNickname: " + e.msg.user.nickname + "\nContent: " + e.msg.content)
        if (e.msg is ChatMessage) {
            (e.msg as ChatMessage).reply("Testing")
        }
    }

}