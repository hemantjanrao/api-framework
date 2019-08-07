package api.constants;

import api.Endpoint;

public enum BookerEndpoints implements Endpoint {
    BASE_URI("https://restful-booker.herokuapp.com"),
    PING("/ping"),
    BOOKING("/booking"),
    BOOKING_ID("/booking/%d"),
    AUTH("/auth");

    private String url;

    BookerEndpoints(String url){
        this.url = url;
    }

    @Override
    public String getUrl(Object... params) {
        return String.format(url, params);
    }
}
