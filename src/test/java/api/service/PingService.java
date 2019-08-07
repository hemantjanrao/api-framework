package api.service;

import api.AbstractBookerService;
import api.constants.BookerEndpoints;
import io.restassured.RestAssured;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;

public class PingService extends AbstractBookerService {

    public String ping(){
        return get(BookerEndpoints.PING.getUrl()).body().asString();
    }

    @Override
    protected ResponseSpecification getResponseSpec() {
        return RestAssured.expect().response()
                .statusCode(HttpStatus.SC_CREATED);
    }


}
