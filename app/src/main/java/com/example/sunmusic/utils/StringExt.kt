package com.example.sunmusic.utils

import com.example.sunmusic.domain.mapper.JsonParser
import org.json.JSONArray
import org.json.JSONObject

fun <T : JsonParser> String.toObject(clazz: Class<T>): List<T> {
    val result = mutableListOf<T>()
    if (first() == '[' && last() == ']') {
        val jsonArray = JSONArray(this)
        for (i in 0 until jsonArray.length()) {
            val jsonObject = jsonArray.getJSONObject(i)
            val instanceObject = clazz.newInstance().apply { formJson(jsonObject) }
            result.add(instanceObject)
        }
    } else {
        val jsonObject = JSONObject(this)
        val instanceObject = clazz.newInstance().apply { formJson(jsonObject) }
        result.add(instanceObject)
    }
    return result
}