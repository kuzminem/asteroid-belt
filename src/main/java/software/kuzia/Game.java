package software.kuzia;

public class Game {
    public static void main(String[] args) {
        Belt belt = new Belt(101);
        Mover mover = new Mover(belt.getSize() / 2 - 1, belt.getSize() / 2, 1);
        Radar radar = new Radar();

        for (int r = 44; r < 57; r++) {
            belt.setAsteroid(52, r, 'O');
        }
        for (int i = 0; i < 8; i++) {
            belt.setAsteroid(52 - i, 43 + i, '.');
        }
        for (int i = 0; i < 7; i++) {
            belt.setAsteroid(52 - i, 57 - i, 'o');
        }

        belt.setAsteroid(belt.getSize() / 2, belt.getSize() / 2, 'X');

        radar.draw(belt, mover);

        for (int i = 0; i < 4; i++) {
            mover.turnRight();
            radar.draw(belt, mover);
        }

        for (int i = 0; i < 4; i++) {
            mover.turnLeft();
            radar.draw(belt, mover);
        }

        // System.out.println(belt.getAsteroid(mover.getMoveLine(),mover.getMoveRow()));
    }
}
