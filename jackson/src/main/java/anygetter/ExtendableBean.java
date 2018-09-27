package anygetter;

import java.util.Map;

public class ExtendableBean {
    public String name;
    private Map<String, String> properties;

    public ExtendableBean(Map<String, String> properties) {
        this.properties = properties;
    }
}
