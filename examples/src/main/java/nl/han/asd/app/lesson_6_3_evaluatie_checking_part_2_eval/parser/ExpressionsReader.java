package nl.han.asd.app.lesson_6_3_evaluatie_checking_part_2_eval.parser;

import nl.han.asd.app.lesson_6_3_evaluatie_checking_part_2_eval.ExpressionsBaseListener;
import nl.han.asd.app.lesson_6_3_evaluatie_checking_part_2_eval.ExpressionsParser;
import nl.han.asd.app.lesson_6_3_evaluatie_checking_part_2_eval.expressions.Addition;
import nl.han.asd.app.lesson_6_3_evaluatie_checking_part_2_eval.expressions.Expression;
import nl.han.asd.app.lesson_6_3_evaluatie_checking_part_2_eval.expressions.Multiplication;
import nl.han.asd.app.lesson_6_3_evaluatie_checking_part_2_eval.expressions.Number;

import java.util.Stack;

public class ExpressionsReader extends ExpressionsBaseListener {
    Stack<Expression> expressions = new Stack<>();

    @Override
    public void exitExpression(ExpressionsParser.ExpressionContext ctx) {
        if (isNumber(ctx)) {
            Number number = new Number();
            number.setNumber(ctx.getChild(0).getText());

            expressions.push(number);
        } else if (isExpression(ctx)) {
            Expression expression = null;

            String operatorStr = ctx.getChild(1).getText();
            switch(operatorStr) {
                case "*": expression = new Multiplication(); break;
                case "+": expression = new Addition(); break;
            }
            expression.setRight(expressions.pop());
            expression.setLeft(expressions.pop());

            expressions.push(expression);
        }
    }

    private boolean isExpression(ExpressionsParser.ExpressionContext ctx) {
        return ctx.getChildCount() == 3;
    }

    private boolean isNumber(ExpressionsParser.ExpressionContext ctx) {
        return ctx.getChildCount() == 1;
    }

    public Expression getExpression() {
        return expressions.peek();
    }
}
