package api.tests;

import common.listners.TestListner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;

@Listeners(TestListner.class)
public abstract class BaseAPITest {

    protected final Logger logger = LogManager.getLogger(this);

}
