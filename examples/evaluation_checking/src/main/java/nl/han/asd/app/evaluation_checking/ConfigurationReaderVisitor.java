package nl.han.asd.app.evaluation_checking;

import org.antlr.v4.runtime.tree.ParseTree;

import java.util.HashMap;

public class ConfigurationReaderVisitor extends
        ConfigurationBaseVisitor<HashMap<String,String>> {

    public HashMap<String,String> visitProperties(
            ConfigurationParser.PropertiesContext cxt) {
        HashMap<String,String> props = new HashMap<>();
        for(ParseTree child : cxt.children) {
            HashMap<String,String> prop = visit(child);
            props.putAll(prop);
        }
        return props;
    }

    public HashMap<String,String> visitProperty(
            ConfigurationParser.PropertyContext cxt) {
        HashMap<String,String> prop = new HashMap<>();
        prop.put(cxt.getChild(0).getText(),
                cxt.getChild(2).getText());
        return prop;
    }
}
