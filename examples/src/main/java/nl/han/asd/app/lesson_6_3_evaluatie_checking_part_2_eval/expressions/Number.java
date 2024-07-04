package nl.han.asd.app.lesson_6_3_evaluatie_checking_part_2_eval.expressions;

public class Number extends Expression {
    private int number;

    public void setNumber(String numberString) {
        this.number = Integer.parseInt(numberString);
    }
    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public int eval() {
        return number;
    }

    @Override
    public String toString() {
        return "" + number;
    }

}
