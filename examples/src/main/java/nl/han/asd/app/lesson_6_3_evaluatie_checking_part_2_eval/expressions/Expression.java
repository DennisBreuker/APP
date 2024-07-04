package nl.han.asd.app.lesson_6_3_evaluatie_checking_part_2_eval.expressions;

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

    public abstract int eval();
}
