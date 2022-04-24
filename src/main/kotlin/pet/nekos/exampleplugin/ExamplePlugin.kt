package pet.nekos.exampleplugin

import pet.nekos.api.plugin.Plugin
import pet.nekos.api.event.Listener
import pet.nekos.api.event.EventHandler
import pet.nekos.api.event.message.MessageEvent

import pet.nekos.api.entities.message.ChatMessage
import pet.nekos.api.entities.user.User
import pet.nekos.api.entities.guild.Guild

class ExamplePlugin() : Plugin(), Listener {

    @EventHandler
    fun onMessage(e: MessageEvent) {
        // val message = "\nName: " + e.msg.user.name + "\nNickname: " + e.msg.user.nickname + "\nContent: " + e.msg.content + "\nUser hash: " + e.msg.user.hash
        println("Bare event without any data")
    }

    @EventHandler
    fun onChatMessage(e: MessageEvent, c: ChatMessage) {
        val message = "Retrieved only from message object:\n" + "\nName: " + c.user.name + "\nNickname: " + c.user.nickname + "\nContent: " + c.content + "\nUser hash: " + c.user.hash
        if (!c.isOwn()) {
            c.reply(message)
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
    fun onChatMessage(e: MessageEvent, c: ChatMessage, g: Guild) {
        val message = "Retrieved from message that must be from a guild:\n" + "Guild name: " + g.name + "\nContent: " + c.content + "\nName: " + c.user.name +  "\nNickname: " + c.user.nickname + "\nUser hash: " + c.user.hash
        println("Event getting message from guild")
        if (!c.isOwn()) {
            c.reply(message)
        }
    }


}