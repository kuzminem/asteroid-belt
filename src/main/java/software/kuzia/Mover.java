package software.kuzia;

public class Mover {
    private int line;
    private int row;
    private String direction;
    private int level;

    public Mover(int line, int row, int level) {
        this.line = line;
        this.row = row;
        this.direction = "Up";
        this.level = 1;
    }

    public int getLine() {
        return line;
    }

    public int getRow() {
        return row;
    }

    public String getDirection() {
        return direction;
    }

    public int getLevel() {
        return level;
    }

    public int getMoveLine() {
        if (direction.equals("Up")) {
            return line - 1;
        }
        if (direction.equals("Down")) {
            return line + 1;
        }
        return line;
    }

    public int getMoveRow() {
        if (direction.equals("Left")) {
            return row - 1;
        }
        if (direction.equals("Right")) {
            return row + 1;
        }
        return row;
    }

    public void move() {
        switch (direction) {
            case "Right":
                row++;
                break;
            case "Down":
                line++;
                break;
            case "Left":
                row--;
                break;
            default:
                line--;
                break;
        }
    }

    public void turnRight() {
        switch (direction) {
            case "Right":
                direction = "Down";
                break;
            case "Down":
                direction = "Left";
                break;
            case "Left":
                direction = "Up";
                break;
            default:
                direction = "Right";
                break;
        }
    }

    public void turnLeft() {
        switch (direction) {
            case "Left":
                direction = "Down";
                break;
            case "Down":
                direction = "Right";
                break;
            case "Right":
                direction = "Up";
                break;
            default:
                direction = "Left";
                break;
        }
    }
}
