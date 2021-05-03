package br.com.roberto.v1.rest;

import br.com.roberto.v1.model.ContatoModelTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;

public class ContatoRestTest {

    @Before
    public void setup() {
        RestAssured.baseURI = "http://localhost:8086/siscomp-api/api";
    }

    @Test
    public void testaRetonoListaContatosComStatus200ComMaisDe5RegistrosIncluindoCarlosRobertoMedeiros(){
        Response response = given()
                                .contentType("application/json; charset=UTF-8")
                            .when()
                                .get("/v1/contatos")
                            .then()
                                .statusCode(200)
                                .body("contatos.size()", greaterThanOrEqualTo(10))
                                .extract().response();

        List<ContatoModelTest> contatos = response.jsonPath().getList("",ContatoModelTest.class);
        Assert.assertEquals("Carlos Roberto Medeiros",contatos.get(0).getNome());

    }

    @Test
    public void retornaTodosContatosPaginados(){

    }

}
