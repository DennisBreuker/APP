package nl.han.asd.app.lesson_6_1_evaluatie_checking;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // Setup pipeline
        CharStream input = CharStreams.fromStream(new FileInputStream("example.cfg"));
        ConfigurationLexer lexer = new ConfigurationLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ConfigurationParser parser = new ConfigurationParser(tokens);

        // Get tree
        ParseTree tree = parser.properties();

        // Walk through tree using ConfigurationReader
        ParseTreeWalker walker = new ParseTreeWalker();
        ConfigurationReader reader = new ConfigurationReader();
        walker.walk(reader, tree);

        // Show the collected key-value pairs
        System.out.println(reader.getProperties().toString());
    }
}
