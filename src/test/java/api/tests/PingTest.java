package api.tests;


import api.service.PingService;
import org.testng.annotations.Test;

import static com.google.common.truth.Truth.assertThat;


public class PingTest extends BaseAPITest {

    @Test
    public void pingTestServer() {
        assertThat(new PingService().ping()).isEqualTo("Created");
    }
}

