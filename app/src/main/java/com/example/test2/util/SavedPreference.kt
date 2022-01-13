package com.example.test2.util

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager

private const val EMAIL = "email"
private const val PASSWORD = "password"

object SavedPreference {
    private fun getSharedPreference(ctx: Context?): SharedPreferences? {
        return PreferenceManager.getDefaultSharedPreferences(ctx)
    }

    private fun editor(context: Context, const: String, string: String) {
        getSharedPreference(
            context
        )?.edit()?.putString(const, string)?.apply()
    }

    fun setEmail(context: Context, email: String) {
        editor(
            context,
            EMAIL,
            email
        )
    }

    fun getEmail(context: Context) = getSharedPreference(context)?.getString(EMAIL, "")

    fun setPassword(context: Context, password: String) {
        editor(
            context,
            PASSWORD,
            password
        )
    }

    fun getPassword(context: Context) = getSharedPreference(context)?.getString(PASSWORD, "")
}