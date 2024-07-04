package nl.han.asd.app.lesson_6_2_evaluatie_checking_part_1_parse.expressions;

public class Number extends Expression {
    private int number;

    public void setNumber(String numberString) {
        this.number = Integer.parseInt(numberString);
    }

    @Override
    public String toString() {
        return "" + number;
    }

}
