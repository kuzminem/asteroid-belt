package software.kuzia;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Belt belt = new Belt(101);
        Mover mover = new Mover(belt.getSize() / 2 - 1, belt.getSize() / 2, 1);
        Radar radar = new Radar();

        belt.setAsteroid(belt.getSize() / 2, belt.getSize() / 2, 'X');
        belt.setAsteroid(48, 48, 'o');

        Scanner scanner = new Scanner(System.in);
        String input;
        do {
            radar.draw(belt, mover);
            System.out.print("M - двигаться, L - влево, R - вправо, Q - выход: ");
            input = scanner.nextLine();
            switch (input) {
                case "m":
                case "M": {
                    char asteroid = belt.getAsteroid(mover.getMoveLine(), mover.getMoveRow());
                    if (asteroid == ' ') {
                        mover.move();
                        break;
                    }
                    if (asteroid == '.' || asteroid == 'o' || asteroid == 'O') {
                        char nextAsteroid = belt.getAsteroid(mover.getNextMoveLine(), mover.getNextMoveRow());
                        if (nextAsteroid == ' ') {
                            belt.setAsteroid(mover.getNextMoveLine(), mover.getNextMoveRow(), asteroid);
                            belt.setAsteroid(mover.getMoveLine(), mover.getMoveRow(), ' ');
                            mover.move();
                        } else if (nextAsteroid == 'X') {
                            belt.setAsteroid(mover.getMoveLine(), mover.getMoveRow(), ' ');
                            mover.move();
                        }
                    }
                }
                break;
                case "l":
                case "L": {
                    mover.turnLeft();
                }
                break;
                case "r":
                case "R": {
                    mover.turnRight();
                }
                break;
            }
        } while (!(input.equals("q") || input.equals("Q")));
        System.out.println("Вышли.");
    }
}
