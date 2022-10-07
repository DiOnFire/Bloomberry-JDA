package me.dion.bloomberry

import me.dion.bloomberry.listener.CommandExecutor
import me.dion.bloomberry.listener.EventListener
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.entities.Activity
import net.dv8tion.jda.api.interactions.commands.build.Commands

class Bloomberry {
    companion object {
        const val TOKEN = "ди нах токен аутдейтед"

        @JvmStatic
        fun main(args: Array<String>) {
            val builder = JDABuilder
                .createDefault(TOKEN)
                .addEventListeners(EventListener())
                .setActivity(Activity.listening("иди нахуй"))
                .build()

            CommandExecutor.init()

            val cmds = builder.updateCommands()

            cmds.addCommands(
                Commands.slash("stats", "Shows current stats of usage of Bloomware")
            )
            cmds.addCommands(
                Commands.slash("account", "Shows info about your Bloomware account.")
            )
            cmds.addCommands(
                Commands.slash("requestrole", "Gives roles to you if they are available.")
            )

            cmds.queue()
        }
    }
}
