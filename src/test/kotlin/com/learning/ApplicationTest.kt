package com.learning

import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpStatusCode
import io.ktor.server.testing.testApplication
import org.junit.Test
import kotlin.test.assertEquals

class ApplicationTest {
  @Test
  fun testGetOrder() = testApplication {
    val response = client.get("/order/2023-02-23-01")
    
    assertEquals(
      """{"number":"2023-02-23-01","contents":[{"item":"Ham Sandwich","amount":2,"price":5.5},{"item":"Water","amount":1,"price":1.5},{"item":"Beer","amount":3,"price":2.3},{"item":"Cheesecake","amount":1,"price":3.75}]}""",
      response.bodyAsText()
    )
    
    assertEquals(HttpStatusCode.OK, response.status)
  }
}
