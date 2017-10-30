package com.hilton.folio

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._
import java.util.Random
import io.gatling.core.body.ElFileBody

class RecordedSimulation extends Simulation {
	val httpProtocol = http
		.baseURL("http://192.168.0.102:8082")
		.inferHtmlResources()
		.acceptHeader("*/*")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("en-US,en;q=0.8")
		.userAgentHeader("Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.115 Safari/537.36")

	val headers_0 = Map(
		"Postman-Token" -> "199921d6-bdd5-e22f-98fa-910337d975c3",
		"Proxy-Connection" -> "keep-alive",
		"Content-Type" -> "application/json")


	val getFolioById = scenario("RecordedSimulation")
    	.exec(http("getFolioById")
            .get("/greeting?name=ravi")
            .headers(headers_0))



	setUp(getFolioById.inject(constantUsersPerSec(100) during(30 seconds))).protocols(httpProtocol)




	//setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)

}
