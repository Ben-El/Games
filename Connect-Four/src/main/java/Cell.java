public class Cell {
    private char sign;
    private String color;

    public static final String DEFAULT_COLOR = "\u001B[0m";
    public static final String WINNING_COLOR = "\033[4;32m";

    public Cell() {
        this.sign = '-';
        this.color = DEFAULT_COLOR;
    }

    public Cell(char sign) {
        this.sign = sign;
        this.color = DEFAULT_COLOR;
    }

    public char getSign() {
        return this.sign;
    }

    public String getColor() {
        return this.color;
    }

    public void setSign(char sign) {
        this.sign = sign;
    }

    public void setColor(String color) {
        this.color = color;
    }
}