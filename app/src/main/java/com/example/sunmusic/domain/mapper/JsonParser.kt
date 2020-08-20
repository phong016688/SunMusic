package com.example.sunmusic.domain.mapper

import org.json.JSONObject

interface JsonParser {
    fun formJson(jsonObject: JSONObject)
    fun toJson(): JSONObject
}
