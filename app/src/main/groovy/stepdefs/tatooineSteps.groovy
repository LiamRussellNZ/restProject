package stepdefs

import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.restassured.RestAssured
import io.restassured.http.Method
import io.restassured.path.json.JsonPath
import io.restassured.response.Response
import io.restassured.specification.RequestSpecification

class tatooineSteps {

    Response response
    JsonPath jsonPathEvaluator

    @Given("I make a API call")
    void makeAnApiCall() {
        RestAssured.baseURI = "http://swapi.dev/api"
        RequestSpecification httpRequest = RestAssured.given()
        response = httpRequest.request(Method.GET, "/planets/1/")
        jsonPathEvaluator = response.jsonPath()
        String responseBody = response.getBody().asString()
        int statusCode = response.getStatusCode()
        assert statusCode == 200
        System.out.println("Response is " + responseBody)
    }

    @Then("Tatooine is the planet name")
    void tatooinePlanetName() {
        String name = jsonPathEvaluator.get("name")
        assert name == "Tatooine"
    }
}
