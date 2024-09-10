import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {
    @BeforeAll
    public static void setup() {
        // Устанавливаем базовый URL для всех тестов
        RestAssured.baseURI = "https://postman-echo.com";
    }
}

