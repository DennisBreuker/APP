package nl.han.asd.app.lesson_6_3_evaluatie_checking_part_2_eval.transform;

import nl.han.asd.app.lesson_6_3_evaluatie_checking_part_2_eval.expressions.Expression;
import nl.han.asd.app.lesson_6_3_evaluatie_checking_part_2_eval.expressions.Number;

public class Transformer {
    public Expression transform(Expression ast) {
        Number number = new Number();
        number.setNumber(ast.eval());
        return number;
    }
}
