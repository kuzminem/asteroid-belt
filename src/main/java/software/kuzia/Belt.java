package software.kuzia;

public class Belt {
    char[][] space;

    public Belt(int side) {
        space = new char[side][side];

        for (int l = 0; l < side; l++) {
            for (int r = 0; r < side; r++) {
                space[l][r] = ' ';
            }
        }
    }

    public int getSize() {
        return space.length;
    }

    public char getAsteroid(int line, int row) {
        return space[line][row];
    }

    public void setAsteroid(int line, int row, char type) {
        space[line][row] = type;
    }
}
