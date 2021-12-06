package com.example

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.server.testing.*
import kotlin.test.Test
import kotlin.test.assertEquals

class ApplicationTest {
    @Test
    fun testGetRequest() {
        withTestApplication(Application::main) {
            handleRequest(HttpMethod.Get, "/").apply {
                assertEquals(HttpStatusCode.OK, response.status())
                assertEquals("Hello, world!", response.content)
            }
        }
    }

    @Test
    fun testPostRequest() {
        val name = "testName"
        withTestApplication(Application::main) {
            handleRequest(HttpMethod.Post, "/") {
                addHeader(HttpHeaders.ContentType, ContentType.Application.FormUrlEncoded.toString())
                setBody(listOf("name" to name).formUrlEncode())
            }.apply {
                assertEquals(HttpStatusCode.OK, response.status())
                assertEquals("Hello, $name!", response.content)
            }
        }
    }
}