package nl.han.asd.app.lesson_6_1_evaluatie_checking_configuration_part_2;

import java.util.HashMap;

public class ConfigurationReader extends ConfigurationBaseListener {
    private final HashMap<String,String> properties;

    public ConfigurationReader() {
        properties = new HashMap<>();
    }

//    @Override
//    public void enterProperty(ConfigurationParser.PropertyContext ctx) {
//        System.out.println("--- ENTER");
//        System.out.println(ctx.getChild(0).getText());
//        System.out.println(ctx.getChild(1).getText());
//        System.out.println(ctx.getChild(2).getText());
//    }

    @Override
    public void exitProperty(ConfigurationParser.PropertyContext cxt) {
        properties.put(cxt.getChild(0).getText(),
                cxt.getChild(2).getText());
    }
    public HashMap<String, String> getProperties() {
        return properties;
    }
}

