package me.dion.bloomberry.command.commands

import me.dion.bloomberry.command.ISlashCommand
import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import java.awt.Color

class StatsCommand : ISlashCommand {
    override fun name(): String {
        return "stats"
    }

    override fun description(): String {
        return "Shows current stats of usage of Bloomware"
    }

    override fun handle(event: SlashCommandInteractionEvent) {
        val embedBuilder = EmbedBuilder()
            .setTitle("Bloomware stats")
            .setColor(Color.ORANGE)
            .setAuthor("Bloomberry")
            .addField("Current online", "test", true)
            .build()

        event.replyEmbeds(embedBuilder).setEphemeral(true).queue()
    }
}