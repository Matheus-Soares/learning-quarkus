package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class MathResourceTest {

    @Test
    public void testSumEndpoint() {
        given()
                .when().get("/math/sum?firstNumber=1&secondNumber=2")
                .then()
                .statusCode(200)
                .body(is("The sum of 1 and 2 is 3"));
    }

    @Test
    public void testSubEndpoint() {
        given()
                .when().get("/math/sub?firstNumber=1&secondNumber=2")
                .then()
                .statusCode(200)
                .body(is("The subtraction of 1 and 2 is -1"));
    }

    @Test
    public void testMultEndpoint() {
        given()
                .when().get("/math/mult?firstNumber=1&secondNumber=2")
                .then()
                .statusCode(200)
                .body(is("The multiplication of 1 and 2 is 2"));
    }

    @Test
    public void testDivEndpoint() {
        given()
                .when().get("/math/div?firstNumber=1&secondNumber=2")
                .then()
                .statusCode(200)
                .body(is("The division of 1 and 2 is 0.5"));
    }

    @Test
    public void testDivEndpointWithError() {
        given()
                .when().get("/math/div?firstNumber=1&secondNumber=0")
                .then()
                .statusCode(400);
    }

}