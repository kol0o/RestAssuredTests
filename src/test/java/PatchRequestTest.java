import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PatchRequestTest extends BaseTest {

    @Test
    public void testPatchRequest() {
        String requestBody = "This is expected to be sent back as part of response body.";

        // Выполняем PATCH-запрос с телом
        Response response = given()
                .body(requestBody)
                .when()
                .patch("/patch")
                .then()
                .statusCode(200)  // Проверяем, что статус-код 200
                .body("data", equalTo(requestBody))  // Проверяем, что тело ответа совпадает с отправленным телом
                .extract()
                .response();

        // Выводим тело ответа для наглядности (опционально)
        System.out.println("Response: " + response.asString());
    }
}
