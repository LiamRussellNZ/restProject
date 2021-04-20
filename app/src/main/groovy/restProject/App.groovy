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
        println new App().getGreeting()
        RestAssured.baseURI = "http://swapi.dev/api"
        RequestSpecification httpRequest = RestAssured.given()
        Response response = httpRequest.request(Method.GET, "/planets/1/")
        String responseBody = response.getBody().asString()
        int statusCode = response.getStatusCode()
        assert statusCode == 200
        System.out.println("Response is " + responseBody)
    }
}
