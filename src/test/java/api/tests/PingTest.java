package api.tests;

import api.service.PingService;
import common.retry.RetryFlakyTests;
import org.testng.annotations.Test;

import static com.google.common.truth.Truth.assertThat;

@Test(retryAnalyzer = RetryFlakyTests.class)
public class PingTest extends BaseAPITest {

    public void pingTestServer() {
        assertThat(new PingService().ping()).isEqualTo("Created");
    }
}

