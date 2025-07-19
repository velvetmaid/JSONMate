package com.vlma.jsonmate

import android.content.Context
import org.json.JSONObject

object AppConfig {
    private var config: JSONObject? = null

    fun init(context: Context) {
        val json = context.assets.open("config.json")
            .bufferedReader()
            .use { it.readText() }

        config = JSONObject(json)
    }

    fun get(key: String, default: String = ""): String {
        return config?.optString(key, default) ?: default
    }
}
