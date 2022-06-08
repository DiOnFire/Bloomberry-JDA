package me.dion.bloomberry.command.commands

import me.dion.bloomberry.command.ISlashCommand
import me.dion.bloomberry.util.Utils
import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import java.awt.Color

class RequestRolesCommand : ISlashCommand {
    override fun name(): String {
        return "requestrole"
    }

    override fun description(): String {
        return "Gives roles to you if they are available."
    }

    override fun handle(event: SlashCommandInteractionEvent) {
        if (!YourAccountCommand.check(event.member!!.idLong)) {

            event.replyEmbeds(EmbedBuilder()
                .setColor(Color.RED)
                .setTitle("Your account")
                .setDescription("It looks like you haven't connected your Discord account to your Bloomware account.")
                .build())
                .setEphemeral(true)
                .queue()
        } else {
            val roles = event.member!!.roles
            val connectRole = event.guild!!.getRoleById(983793472760860803)

            if (!Utils.hasRole(roles, connectRole!!.name)) {
                event.guild!!.addRoleToMember(event.member!!, connectRole).queue()
                event.replyEmbeds(EmbedBuilder()
                    .setColor(Color.BLUE)
                    .setTitle("Role request")
                    .setDescription("Role \"Bloomware Connect\" was given to you.")
                    .build())
                    .setEphemeral(true)
                    .queue()
            } else {
                event.replyEmbeds(EmbedBuilder()
                    .setColor(Color.GRAY)
                    .setTitle("Role request")
                    .setDescription("Your roles are up-to-date.")
                    .build())
                    .setEphemeral(true)
                    .queue()
            }
        }
    }
}