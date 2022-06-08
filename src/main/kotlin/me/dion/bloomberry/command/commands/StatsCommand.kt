package me.dion.bloomberry.command.commands

import me.dion.bloomberry.command.ISlashCommand
import me.dion.bloomberry.util.Utils
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
            .addField("Current online", Utils.getOnline().toString(), true)
            .build()

        event.replyEmbeds(embedBuilder).setEphemeral(true).queue()
    }
}