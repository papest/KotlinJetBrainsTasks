package ktor

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.*
import io.ktor.client.request.*
import io.ktor.client.request.forms.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.coroutines.runBlocking
import java.io.File

fun main() {
    runBlocking {
        val client = HttpClient(CIO)
        val response: HttpResponse = client.post("http://localhost:8080/upload") {
            onUpload { bytesSentTotal, contentLength ->
                println("Sent $bytesSentTotal bytes from $contentLength")

                setBody(
                    MultiPartFormDataContent(
                        formData {
                            append("description", "Ktor Logo")
                            append("image", File("ktor_logo.png").readBytes(), Headers.build {
                                append(HttpHeaders.ContentType, "image/png")
                                append(HttpHeaders.ContentDisposition, "filename=\"ktor_logo.png\"")
                            })
                        },
                        boundary = "WebAppBoundary"
                    )
                )
            }
        }
        println(response.bodyAsText())
    }
}
