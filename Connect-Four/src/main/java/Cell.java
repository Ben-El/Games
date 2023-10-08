import lombok.Data;

@Data
public class Cell {
    private char sign;
    private String color;

    public static final String DEFAULT_COLOR = "\u001B[0m";
    public static final String WINNING_COLOR = "\033[4;32m"; //

    public Cell() {
        this.sign = '-';
        this.color = DEFAULT_COLOR;
    }

    public Cell(char sign) {
        this.sign = sign;
        this.color = DEFAULT_COLOR;
    }
}