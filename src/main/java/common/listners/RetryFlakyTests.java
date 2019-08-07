package common.listners;

import common.properties.Property;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFlakyTests implements IRetryAnalyzer {

    static final int MAX_RETRY_COUNT = Property.MAX_RETRY_COUNT.getIntWithDefault(1);

    private int retryCount = 0;

    @Override
    public boolean retry(ITestResult result) {
        return retryCount++ < MAX_RETRY_COUNT;
    }
}
