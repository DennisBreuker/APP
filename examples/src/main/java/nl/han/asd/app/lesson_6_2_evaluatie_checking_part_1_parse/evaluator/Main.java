package nl.han.asd.app.lesson_6_2_evaluatie_checking_part_1_parse.evaluator;

import nl.han.asd.app.lesson_6_2_evaluatie_checking_part_1_parse.ExpressionsLexer;
import nl.han.asd.app.lesson_6_2_evaluatie_checking_part_1_parse.ExpressionsParser;
import nl.han.asd.app.lesson_6_2_evaluatie_checking_part_1_parse.parser.ExpressionsReader;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class Main {
    public static void main(String[] args) {
        String expression = "3 + 1 * 4 + 1 + 5 * 9 + 2 * 6 * 5 + 3 + 5";

        //Setup pipeline
        CharStream input = CharStreams.fromString(expression);
        ExpressionsLexer lexer = new ExpressionsLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExpressionsParser parser = new ExpressionsParser(tokens);

        //Parse
        ParseTree tree = parser.expression();

        // Walk using listener
        ParseTreeWalker walker = new ParseTreeWalker();
        ExpressionsReader reader = new ExpressionsReader();
        walker.walk(reader, tree);

        System.out.println(reader.getExpression());
    }
}
