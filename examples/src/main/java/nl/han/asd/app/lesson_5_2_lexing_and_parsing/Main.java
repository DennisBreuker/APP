package nl.han.asd.app.lesson_5_2_lexing_and_parsing;


import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileInputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        //Setup pipeline
        CharStream input = CharStreams.fromStream(new FileInputStream("example.cfg"));
        ConfigurationLexer lexer = new ConfigurationLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ConfigurationParser parser = new ConfigurationParser(tokens);

        //Parse
        ParseTree tree = parser.properties();

        System.out.println(tree.toStringTree());
    }
}
