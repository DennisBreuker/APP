package nl.han.asd.app.evaluation_checking;

import java.util.HashMap;

public class ConfigurationReader extends ConfigurationBaseListener {
    private HashMap<String,String> properties;

    public ConfigurationReader() {
        properties = new HashMap<String,String>();
    }

    @Override
    public void exitProperty(ConfigurationParser.PropertyContext cxt) {
        properties.put(cxt.getChild(0).getText(),
                cxt.getChild(2).getText());
    }
    public HashMap<String, String> getProperties() {
        return properties;
    }
}

