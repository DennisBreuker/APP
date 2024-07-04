package nl.han.asd.app.lesson_6_2_evaluatie_checking_part_1_parse.expressions;

public class Multiplication extends Expression {
    public Multiplication() {
        operator = Operator.MULTIPLY;
    }

    @Override
    public String toString() {
        return "(" + left + " * " + right + ")";
    }

}
