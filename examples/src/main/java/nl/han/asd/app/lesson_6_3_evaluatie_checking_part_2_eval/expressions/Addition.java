package nl.han.asd.app.lesson_6_3_evaluatie_checking_part_2_eval.expressions;

public class Addition extends Expression {
    public Addition() {
        operator = Operator.ADD;
    }

    @Override
    public int eval() {
        return left.eval() + right.eval();
    }

    @Override
    public String toString() {
        return "(" + left + " + " + right + ")";
    }

}
