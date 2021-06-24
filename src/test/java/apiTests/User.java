package apiTests;

import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.stringContainsInOrder;


public class User {
    int userId = 666;
    String userName = "Pumuchio";
    String uri = "https://petstore.swagger.io/v2/user";

    public String lerJson(String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }

    @Test(priority = 0)
    public void incluirUser() throws IOException { // Create - Post

        String jsonBody = lerJson("src/test/resources/data/user.json");

        given()
                .contentType("application/json")
                .log().all()
                .body(jsonBody)
                .when()
                .post(uri)
                .then()                                             
                .log().all() 
                .statusCode(200)
                .body("code", is(200))
                .body("type", is("unknown")) 
                .body("message", is(Integer.toString(userId)))
        ;
    }

    @Test(priority = 1 , dependsOnMethods = {"incluirUser"})
    public void consultarUser(){


        given()
                .contentType("application/json")
                .log().all()
        .when()
                .get(uri + "/" + userName)
        .then()
                .log().all()
                .statusCode(200)
                .body("id", is(userId))
                .body("username", is(userName))
                .body("firstName", is("Pumuchio"))
                .body("lastName", is("Rede"))
                .body("email", is("destruosuared@rede.com"))
                .body("password", is("123456"))
                .body("phone", is("1234567890"))
                .body("userStatus", is(0))
        ;
    }

    @Test(priority = 2, dependsOnMethods = {"consultarUser"})
    public void alterarUser() throws IOException {
        String jsonBody = lerJson("src/test/resources/data/newuser.json");
        given()
                .contentType("application/json")
                .log().all()
                .body(jsonBody)
                .when()
                .put(uri + "/" + userName)
                .then()
                .log().all()
                .statusCode(200)
                .body("code", is(200))
                .body("type", is("unknown"))
                .body("message", is(Integer.toString(userId)))
        ;
    }

    @Test(priority = 1, dependsOnMethods = {"alterarUser"})
    public void apagarUser(){

        given()
                .contentType("application/json")
                .log().all()
        .when()
                .delete(uri + "/" + userName) // Get == Consultar
        .then()
                .log().all()
                .statusCode(200)
                .body("code", is(200))
                .body("type", is("unknown"))
                .body("message", is(userName))
        ;
    }

}
