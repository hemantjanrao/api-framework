package api;

import api.services.BaseService;
import api.constants.BookerEndpoints;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.ExtractableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;

public abstract class AbstractBookerService extends BaseService {

    protected RequestSpecification getRequestSpec(){

        return RestAssured.given()
                .baseUri(BookerEndpoints.BASE_URI.getUrl())
                .relaxedHTTPSValidation()
                .contentType("application/json")
                .accept("application/json");

    }

    @Override
    protected ResponseSpecification getResponseSpec() {
        return RestAssured.expect().response()
                .statusCode(HttpStatus.SC_OK);
    }

    protected ExtractableResponse post(Object body, String url) {
        return request(Method.POST, body, url);
    }

}
