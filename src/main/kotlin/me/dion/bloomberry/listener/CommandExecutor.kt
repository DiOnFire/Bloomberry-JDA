package me.dion.bloomberry.listener

import me.dion.bloomberry.command.ISlashCommand
import me.dion.bloomberry.command.commands.RequestRolesCommand
import me.dion.bloomberry.command.commands.StatsCommand
import me.dion.bloomberry.command.commands.YourAccountCommand
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent

class CommandExecutor {
    companion object {
        private val commands = ArrayList<ISlashCommand>()

        fun init() {
            commands.add(StatsCommand())
            commands.add(YourAccountCommand())
            commands.add(RequestRolesCommand())
        }

        fun execute(event: SlashCommandInteractionEvent) {
            for (command in commands) {
                if (event.name == command.name()) {
                    command.handle(event)
                    break
                }
            }
        }
    }
}