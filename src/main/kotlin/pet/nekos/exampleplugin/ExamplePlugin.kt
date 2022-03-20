package pet.nekos.exampleplugin

import pet.nekos.api.Server
import pet.nekos.api.plugin.Plugin
import pet.nekos.api.plugin.PluginManager
import pet.nekos.api.event.HandlerList
import pet.nekos.api.event.message.MessageEvent

import java.io.File

class ExamplePlugin() : Plugin() {
 
    override fun onEnable() {
        println("Testing before registering events")
        this.server?.pluginManager?.registerEvents(MessageListener(), this)
        println("Testing after registering events")
        isEnabled = true
    }
}