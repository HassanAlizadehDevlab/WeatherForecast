package com.android.shared.utils

object TestUtil {
    fun parseJson(fileName: String): String =
        javaClass.classLoader?.getResourceAsStream("json/$fileName")
            ?.bufferedReader().use { it?.readText().orEmpty() }
}