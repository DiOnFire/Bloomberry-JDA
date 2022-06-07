package me.dion.bloomberry

import me.dion.bloomberry.listener.CommandExecutor
import me.dion.bloomberry.listener.EventListener
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.entities.Activity
import net.dv8tion.jda.api.interactions.commands.build.Commands

class Bloomberry {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val builder = JDABuilder
                .createDefault("OTY0NjQ0MzU2NzU1NzA5OTky.YlnpEA.fj9M7G3g7bAuxMthDd7fYi7h06A")
                .addEventListeners(EventListener())
                .setActivity(Activity.listening("иди нахуй"))
                .build()

            CommandExecutor.init()

            val cmds = builder.updateCommands()

            cmds.addCommands(
                Commands.slash("stats", "Shows current stats of usage of Bloomware")
            )

            cmds.queue()
        }
    }
}