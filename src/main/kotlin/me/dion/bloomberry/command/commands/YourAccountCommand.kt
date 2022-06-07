package me.dion.bloomberry.command.commands

import me.dion.bloomberry.command.ISlashCommand
import me.dion.bloomberry.util.Utils
import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.MessageBuilder
import net.dv8tion.jda.api.entities.MessageEmbed
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import java.awt.Color

class YourAccountCommand : ISlashCommand {
    override fun name(): String {
        return "account"
    }

    override fun description(): String {
        return "Shows info about your Bloomware account."
    }

    override fun handle(event: SlashCommandInteractionEvent) {
        event.replyEmbeds(createEmbed(event)).setEphemeral(true).queue()
    }

    private fun check(id: Long): Boolean {
        val user = Utils.getUserData(id)
        return user != null
    }

    private fun createEmbed(event: SlashCommandInteractionEvent): MessageEmbed {
        return if (check(event.member!!.id.toLong())) {
            val user = Utils.getUserData(event.member!!.id.toLong())
            EmbedBuilder()
                .setColor(Color.GREEN)
                .setTitle("Your account")
                .setDescription(
                    "#️⃣ **UID:** ${user?.id}\n" +
                            "\uD83D\uDCBB **Login:** ${user?.login}\n" +
                            "\uD83D\uDCE7 **Email:** ${user?.email}\n" +
                            (if (user?.email_verified == true) "✅ **Email verified**\n" else "❌ **Email not verified**\n") +
                            "\uD83D\uDCC5 **Register date:** ${user?.register_date?.substring(0, 10)}")
                .build()
        } else {
            EmbedBuilder()
                .setColor(Color.RED)
                .setTitle("Your account")
                .setDescription("It looks like you haven't connected your Discord account to your Bloomware account.")
                .build()
        }

    }
}