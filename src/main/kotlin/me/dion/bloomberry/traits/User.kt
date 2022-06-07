package me.dion.bloomberry.traits

data class User(
    val id: Int,
    val login: String,
    val email: String,
    val email_verified: Boolean,
    val subscription_started: String,
    val subscription_months: Int,
    val discord_linked: Boolean,
    val discord_oauth: String,
    val register_date: String
)