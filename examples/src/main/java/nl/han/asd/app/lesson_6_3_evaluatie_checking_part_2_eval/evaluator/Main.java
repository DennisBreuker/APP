package nl.han.asd.app.lesson_6_3_evaluatie_checking_part_2_eval.evaluator;

import nl.han.asd.app.lesson_6_3_evaluatie_checking_part_2_eval.ExpressionsLexer;
import nl.han.asd.app.lesson_6_3_evaluatie_checking_part_2_eval.ExpressionsParser;
import nl.han.asd.app.lesson_6_3_evaluatie_checking_part_2_eval.parser.ExpressionsReader;
import nl.han.asd.app.lesson_6_3_evaluatie_checking_part_2_eval.transform.Transformer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class Main {
    public static void main(String[] args) {
        String expression = "3+1*2+2*3+2";

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

//        System.out.println(new Evaluator().eval(reader.getExpression()));
        System.out.println(reader.getExpression());
        System.out.println(new Transformer().transform(reader.getExpression()));
    }
}
