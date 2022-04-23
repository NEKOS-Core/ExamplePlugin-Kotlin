package pet.nekos.exampleplugin

import pet.nekos.api.plugin.Plugin
import pet.nekos.api.event.Listener
import pet.nekos.api.event.EventHandler
import pet.nekos.api.event.message.MessageEvent

import pet.nekos.api.message.ChatMessage

class ExamplePlugin() : Plugin(), Listener {

    @EventHandler
    fun onMessage(e: MessageEvent) {
        val message = "\nName: " + e.msg.user.name + "\nNickname: " + e.msg.user.nickname + "\nContent: " + e.msg.content + "\nUser hash: " + e.msg.user.hash
        if (e.msg is ChatMessage) {
            if (!e.msg.isOwn()) {
                (e.msg as ChatMessage).reply(message)
                println(message)

            }
        }
    }

}