# How to implement InnertubeProvider using Ktor & OkHttp3

Here's the code snippet

```kotlin
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.compression.ContentEncoding
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.request
import io.ktor.client.request.setBody
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.HttpMethod
import io.ktor.http.contentType
import io.ktor.http.parametersOf
import io.ktor.serialization.kotlinx.json.json
import io.ktor.serialization.kotlinx.xml.xml
import io.ktor.util.toMap
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import me.knighthat.innertube.Innertube
import me.knighthat.innertube.request.Request
import me.knighthat.innertube.response.Response
import nl.adaptivity.xmlutil.XmlDeclMode
import nl.adaptivity.xmlutil.serialization.XML
import org.jetbrains.annotations.Blocking


class InnertubeProvider: Innertube.Provider {

    private val CLIENT = HttpClient(OkHttp) {
        expectSuccess = true

        install( ContentNegotiation ) {
            json(Json {
                ignoreUnknownKeys = true
                explicitNulls = false
                encodeDefaults = true
            })
            xml(
                format =
                    XML {
                        xmlDeclMode = XmlDeclMode.Charset
                        autoPolymorphic = true
                    },
                contentType = ContentType.Text.Xml,
            )
        }

        install( ContentEncoding ) {
            gzip(1f)
            deflate(0.9F)
        }

        defaultRequest {
            contentType( ContentType.Application.Json )
            parametersOf( "prettyPrint", "false" )
        }
    }

    @Blocking
    override fun execute( request: Request ): Response = runBlocking( Dispatchers.IO ) {
        val result = CLIENT.request( request.url ) {
            method = HttpMethod.parse( request.httpMethod )
            // Only setBody when it's not null
            request.dataToSend?.toJsonString()?.also( this::setBody )
            // Disable pretty print - potentially save data
            url {
                parameters.append( "prettyPrint", "false" )
            }
            // Add headers
            request.headers
                   // Turn Map<String, List<String>> into Map<String, String> by flattening values
                   .mapValues { (_, v) ->
                       v.joinToString(", ") { it }
                   }
                   .forEach( headers::append )
        }

        Response(
            result.status.value, "", result.headers.toMap(), result.bodyAsText()
        )
    }
}
```

Now all you have to do is to set the provider with

```kotlin
Innertube.setClient( InnertubeProvider() )
```
