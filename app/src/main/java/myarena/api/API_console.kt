package myarena.api

import com.google.gson.GsonBuilder

/**
 * Ответ MyArena.ru API на запрос о консоли сервера (Неофициальный метод - getconsole)
 */
class API_console : API_ответ() {

    private val console_log = "ERROR: Empty output"

    override fun toString(): String {
        return if (успех()) {
            console_log
        } else {
            message
        }
    }

    companion object {
        fun fromJSON(JSON: String): API_console {
            val builder = GsonBuilder()
            val gson = builder.create()
            return gson.fromJson(JSON, API_console::class.java)
        }
    }
}
