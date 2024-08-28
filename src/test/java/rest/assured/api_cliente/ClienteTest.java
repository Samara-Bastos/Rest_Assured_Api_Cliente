package rest.assured.api_cliente;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import rest.assured.api_cliente.fixture.ClienteRequestFixture;
import rest.assured.api_cliente.model.ClienteRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.equalTo;

public class ClienteTest {
    
     @BeforeEach
    public void setUp() {
        RestAssured.baseURI = "http://localhost:8080";
    }

    @Test
    public void permiteCriarUmClienteComSucesso() {
        ClienteRequest validCliente = ClienteRequestFixture.createClienteValido();

        given()
            .contentType(ContentType.JSON)
            .body(validCliente)
            .when()
            .post("/cliente/create")
            .then()
            .statusCode(HttpStatus.CREATED.value());
    }

    @Test
    public void naoPermiteCriarUmCliente() {
        ClienteRequest invalidCliente = ClienteRequestFixture.createClienteInvalido();

        given()
            .contentType(ContentType.JSON)
            .body(invalidCliente)
            .when()
            .post("/cliente/create")
            .then()
            .statusCode(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void permiteExibirTodosOsClientes() {
        given()
            .contentType(ContentType.JSON)
        .when()
            .get("/cliente")
        .then()
            .statusCode(200)
            .body("[0].id", notNullValue())
            .body("[0].nome", notNullValue()); 
    }

    @Test
    public void testReadClienteById() {
        Long clienteId = 1L;

        given()
            .contentType(ContentType.JSON)
        .when()
            .get("/cliente/" + clienteId)
        .then()
            .statusCode(200)
            .body("id", equalTo(clienteId.intValue()))
            .body("nome", notNullValue());
    }

    @Test
    public void testUpdateCliente() {
        Long clienteId = 1L;
        ClienteRequest request = ClienteRequestFixture.createClienteValido();
        request.setNome("Nome Atualizado");

        given()
            .contentType(ContentType.JSON)
            .body(request)
        .when()
            .put("/cliente/update/" + clienteId)
        .then()
            .statusCode(200)
            .body("nome", equalTo("Nome Atualizado"));
    }

    @Test
    public void testDeleteCliente() {
        Long clienteId = 1L;
        given()
            .contentType(ContentType.JSON)
        .when()
            .delete("/cliente/delete/" + clienteId)
        .then()
            .statusCode(204);
    }
}
