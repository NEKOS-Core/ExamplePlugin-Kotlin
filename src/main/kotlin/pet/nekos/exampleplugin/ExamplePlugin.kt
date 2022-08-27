package pet.nekos.exampleplugin

import pet.nekos.api.plugin.Plugin
import pet.nekos.api.event.Listener
import pet.nekos.api.event.EventHandler
import pet.nekos.api.event.message.MessageEvent

import pet.nekos.api.entities.*

import java.io.File

class ExamplePlugin() : Plugin(), Listener {

    @EventHandler
    fun onMessage(e: MessageEvent) {
        // val message = "\nName: " + e.msg.user.name + "\nNickname: " + e.msg.user.nickname + "\nContent: " + e.msg.content + "\nUser hash: " + e.msg.user.hash
        println("Bare event without any data")
    }

    @EventHandler
    fun onChatMessage(e: MessageEvent, m: Message) {
        val message = "Retrieved only from message object:\n" + "\nName: " + m.user.name + "\nNickname: " + m.user.nickname + "\nContent: " + m.content + "\nUser hash: " + m.user.hash
        if (!m.isOwn()) {
            m.reply(message)
        }
    }

    @EventHandler
    fun onChatMessage(e: MessageEvent, u: User) {
        val message = "Retrieved only from user object:\n" + "\nName: " + u.name + "\nNickname: " + u.nickname + "\nUser hash: " + u.hash
        println("Event only getting user")
        if (!u.isSelf()) {
            u.sendMessage(message)
        }
    }

    @EventHandler
    fun onChatMessage(e: MessageEvent, m: Message, g: Guild) {
        val message = "Retrieved from message that must be from a guild:\n" + "Guild name: " + g.name + "\nContent: " + m.content + "\nName: " + m.user.name +  "\nNickname: " + m.user.nickname + "\nUser hash: " + m.user.hash
        println("Event getting message from guild")
        if (!m.isOwn()) {
            m.reply(message)
        }
    }


}