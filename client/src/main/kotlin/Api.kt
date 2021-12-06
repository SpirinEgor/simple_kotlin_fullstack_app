package com.example

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.js.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*

private const val endpointsUrl = "https://ktor-server-spirinegor.herokuapp.com/"

suspend fun apiRequest(message: String): String? {
    val client = HttpClient(Js)
    val response: HttpResponse = client.post(endpointsUrl) {
        headers {
            append(HttpHeaders.ContentType, ContentType.Application.FormUrlEncoded.toString())
        }
        body = listOf("name" to message).formUrlEncode()
    }
    client.close()
    if (response.status != HttpStatusCode.OK) return null
    return response.receive()
}
