package restProject

import io.restassured.RestAssured
import io.restassured.http.Method
import io.restassured.response.Response
import io.restassured.specification.RequestSpecification

class App {
    String getGreeting() {
        return 'Hello World!'
    }

    static void main(String[] args) {
        println new App().greeting
        RestAssured.baseURI = "http://swapi.dev/api"
        RequestSpecification httpRequest = RestAssured.given()
        Response response = httpRequest.request(Method.GET, "/planets/1/")
        String responseBody = response.getBody().asString()
        System.out.println("Response is " + responseBody)
    }
}
