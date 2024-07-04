package nl.han.asd.app.lesson_6_3_evaluatie_checking_part_2_eval.evaluator;

import nl.han.asd.app.lesson_6_3_evaluatie_checking_part_2_eval.expressions.Expression;

public class Evaluator {
    public int eval(Expression ast) {
        return ast.eval();
    }
}
