package common.properties;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

public enum Property {

    PROXY("proxy"),
    MAX_RETRY_COUNT("maxRetryCount");

    private static Properties properties = null;
    private String value;
    private String systemPropertyKey;

    Property(String key){
        this.systemPropertyKey = key;
        this.value = retrieveValue(key);
    }

    private String retrieveValue(String key){

        if(System.getProperty(key) != null){
            return System.getProperty(key);
        } else {
            return getValueFromConfig(key);
        }
    }

    private String getValueFromConfig(String key) {
        if (properties == null){

            properties =  loadConfigFile();
        }

        Object objFromFile = properties.get(key);
        if (objFromFile != null) {
            return Objects.toString(objFromFile);
        } else {
            return null;
        }
    }

    private Properties loadConfigFile() {
        String configFileName = "config.properties";

        if (StringUtils.isBlank(configFileName)) {
            return new Properties();
        }

        try (InputStream configFileStream = ClassLoader.getSystemClassLoader().getResourceAsStream(configFileName)) {
            Properties properties = new Properties();
            properties.load(configFileStream);
            return properties;
        } catch (IOException e) {
            throw new IllegalArgumentException(
                    "Properties file '" + configFileName + "' not found.", e);
        }
    }

    public String getValue() {
        return retrieveValue(this.systemPropertyKey);
    }

    public boolean isSpecified() {
        return StringUtils.isNotEmpty(value);
    }

    public int getIntWithDefault(int defaultValue){
        return isSpecified() ? Integer.parseInt(value) : defaultValue;
    }

}
