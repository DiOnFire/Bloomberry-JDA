package me.dion.bloomberry.util

import com.google.gson.JsonParser
import me.dion.bloomberry.Bloomberry
import me.dion.bloomberry.traits.User
import net.dv8tion.jda.api.entities.Role
import okhttp3.OkHttpClient
import okhttp3.Request

class Utils {
    companion object {
        private val client = OkHttpClient.Builder().build()

        fun getUserData(userId: Long): User? {
            val request = Request.Builder()
                .url("http://127.0.0.1:8000/api/users/discord?discord_id=${userId}&auth_key=${Bloomberry.TOKEN}")
                .build()
            val response = client.newCall(request).execute()
            val json = JsonParser.parseString(response.body.string()).asJsonObject
            return if (json.get("error") != null) {
                null
            } else {
                User(
                    json.get("id")!!.asInt,
                    json.get("login")!!.asString,
                    json.get("email")!!.asString,
                    json.get("email_verified")!!.asBoolean,
                    json.get("subscription_started")!!.asString,
                    json.get("subscription_months")!!.asInt,
                    json.get("discord_linked")!!.asBoolean,
                    json.get("discord_oauth")!!.asString,
                    json.get("create_date")!!.asString
                )
            }
        }

        fun getOnline(): Int {
            val request = Request.Builder()
                .url("http://127.0.0.1:8000/api/client/stats")
                .build()

            val response = client.newCall(request).execute()
            val json = JsonParser.parseString(response.body.string()).asJsonObject
            return json.get("online").asInt
        }

        fun hasRole(roles: List<Role>, target: String): Boolean {
            for (role in roles) {
                if (role.name.contentEquals(target)) return true
            }
            return false
        }
    }
}