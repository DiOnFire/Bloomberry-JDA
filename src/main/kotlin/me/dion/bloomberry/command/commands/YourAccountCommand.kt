package me.dion.bloomberry.command.commands

import me.dion.bloomberry.command.ISlashCommand
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent

class YourAccountCommand : ISlashCommand {
    override fun name(): String {
        return "account"
    }

    override fun description(): String {
        return "Shows info about your Bloomware account."
    }

    override fun handle(event: SlashCommandInteractionEvent) {
        TODO("Not yet implemented")
    }
}