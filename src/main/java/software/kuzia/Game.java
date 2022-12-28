package software.kuzia;

public class Game {
    public static void main(String[] args) {
        Belt belt = new Belt(101);

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

        Mover mover = new Mover(belt.getSize() / 2 - 1, belt.getSize() / 2, 1);
        Radar radar;

        radar = new Radar(belt, mover);
        radar.draw();

        mover.turnRight();

        radar = new Radar(belt, mover);
        radar.draw();

        mover.turnRight();

        radar = new Radar(belt, mover);
        radar.draw();

        mover.turnRight();

        radar = new Radar(belt, mover);
        radar.draw();

        // mover.turnLeft();
        // System.out.println(belt.getAsteroid(mover.getMoveLine(),mover.getMoveRow()));
    }
}
