package api_tests.service;

import api_tests.AbstractBookerService;
import api_tests.constants.BookerEndpoints;

public class PingService extends AbstractBookerService {

    public String ping(){
        return get(BookerEndpoints.PING.getUrl()).body().asString();
    }


}
