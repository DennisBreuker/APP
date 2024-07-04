package nl.han.asd.app.lesson_6_2_evaluatie_checking_part_1_parse.expressions;

public class Addition extends Expression {
    public Addition() {
        operator = Operator.ADD;
    }

    @Override
    public String toString() {
        return "(" + left + " + " + right + ")";
    }

}
