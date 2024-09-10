import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetRequestTest extends BaseTest {

    @Test
    public void testGetRequest() {
        // Выполняем GET-запрос с параметрами
        Response response = given()
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .when()
                .get("/get")
                .then()
                .statusCode(200)  // Проверяем, что статус-код 200
                .body("args.foo1", equalTo("bar1"))  // Проверяем, что параметр foo1 равен "bar1"
                .body("args.foo2", equalTo("bar2"))  // Проверяем, что параметр foo2 равен "bar2"
                .extract()
                .response();

        // Выводим тело ответа для наглядности (опционально)
        System.out.println("Response: " + response.asString());
    }
}
