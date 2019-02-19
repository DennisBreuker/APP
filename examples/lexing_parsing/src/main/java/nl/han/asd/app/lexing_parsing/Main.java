package nl.han.asd.app.lexing_parsing;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws IOException {
        //Setup pipeline
        InputStream inputStream = Main.class.getResourceAsStream("/example.cfg");
        CharStream charStream = CharStreams.fromStream(inputStream);

        ConfigurationLexer lexer = new ConfigurationLexer(charStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ConfigurationParser parser = new ConfigurationParser(tokens);

        //Parse
        ParseTree tree = parser.properties();

        System.out.println(tree.toStringTree());
    }
}
