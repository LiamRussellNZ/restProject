package restProject
import static io.restassured.RestAssured.*

class App {
    String getGreeting() {
        return 'Hello World!'
    }

    static void main(String[] args) {
        println new App().greeting
        def res = given().when().get("https://swapi.dev/api/planets/1/")
        println res
        given().when().get("https://swapi.dev/api/planets/1/").then().assertThat().statusCode(200)
    }
}
