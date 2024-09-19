package beans;

import java.io.Serializable;

public class ValueBean implements Serializable {
    private String value = "Hello, World!";

    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }

}
