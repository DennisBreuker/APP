package nl.han.asd.app.lesson_6_2_evaluatie_checking_part_1_parse.expressions;

public abstract class Expression {
    protected Expression left;
    protected Operator operator;
    protected Expression right;

    public void setLeft(Expression left) {
        this.left = left;
    }

    public void setRight(Expression right) {
        this.right = right;
    }
}
