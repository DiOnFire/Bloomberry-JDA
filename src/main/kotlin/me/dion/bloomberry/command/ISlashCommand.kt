package me.dion.bloomberry.command

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent

interface ISlashCommand {
    fun name(): String
    fun description(): String
    fun handle(event: SlashCommandInteractionEvent)
}