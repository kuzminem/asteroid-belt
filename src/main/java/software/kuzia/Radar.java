package software.kuzia;

public class Radar {
    String[][] radar = new String[23][23];

    public void draw(Belt belt, Mover mover) {
        // Заполнение.
        int firstLine = mover.getLine();
        int firstRow = mover.getRow();

        switch (mover.getDirection()) {
            case "Right":
                radar[0][11] = " 90";
                radar[11][22] = "180";
                radar[22][11] = "270";
                radar[11][0] = " 0 ";
                firstLine -= 11;
                firstRow += 11;
                for (int l = 1; l < 22; l++) {
                    for (int r = 1; r < 22; r++) {
                        radar[l][r] = " " + belt.getAsteroid(firstLine + r, firstRow - l) + " ";
                    }
                }
                break;
            case "Down":
                radar[0][11] = "180";
                radar[11][22] = "270";
                radar[22][11] = " 0 ";
                radar[11][0] = " 90";
                firstLine += 11;
                firstRow += 11;
                for (int l = 1; l < 22; l++) {
                    for (int r = 1; r < 22; r++) {
                        radar[l][r] = " " + belt.getAsteroid(firstLine - l, firstRow - r) + " ";
                    }
                }
                break;
            case "Left":
                radar[0][11] = "270";
                radar[11][22] = " 0 ";
                radar[22][11] = " 90";
                radar[11][0] = "180";
                firstLine += 11;
                firstRow -= 11;
                for (int l = 1; l < 22; l++) {
                    for (int r = 1; r < 22; r++) {
                        radar[l][r] = " " + belt.getAsteroid(firstLine - r, firstRow + l) + " ";
                    }
                }
                break;
            default:
                radar[0][11] = " 0 ";
                radar[11][22] = " 90";
                radar[22][11] = "180";
                radar[11][0] = "270";
                firstLine -= 11;
                firstRow -= 11;
                for (int l = 1; l < 22; l++) {
                    for (int r = 1; r < 22; r++) {
                        radar[l][r] = " " + belt.getAsteroid(firstLine + l, firstRow + r) + " ";
                    }
                }
                break;
        }

        // Маска 7, 5, 3, 2, 2, 1, 1
        for (int r = 0; r < 11; r++) {
            radar[0][r] = " Z ";
            radar[0][22 - r] = " Z ";
            radar[22][r] = " Z ";
            radar[22][22 - r] = " Z ";
        }
        for (int r = 0; r < 8; r++) {
            radar[1][r] = " Z ";
            radar[1][22 - r] = " Z ";
            radar[21][r] = " Z ";
            radar[21][22 - r] = " Z ";
        }
        for (int r = 0; r < 6; r++) {
            radar[2][r] = " Z ";
            radar[2][22 - r] = " Z ";
            radar[20][r] = " Z ";
            radar[20][22 - r] = " Z ";
        }
        for (int r = 0; r < 4; r++) {
            radar[3][r] = " Z ";
            radar[3][22 - r] = " Z ";
            radar[19][r] = " Z ";
            radar[19][22 - r] = " Z ";
        }
        for (int l = 4; l < 11; l++) {
            radar[l][0] = " Z ";
            radar[l][22] = " Z ";
            radar[22 - l][0] = " Z ";
            radar[22 - l][22] = " Z ";
        }
        for (int l = 4; l < 8; l++) {
            radar[l][1] = " Z ";
            radar[l][21] = " Z ";
            radar[22 - l][1] = " Z ";
            radar[22 - l][21] = " Z ";
        }
        for (int l = 4; l < 6; l++) {
            radar[l][2] = " Z ";
            radar[l][20] = " Z ";
            radar[22 - l][2] = " Z ";
            radar[22 - l][20] = " Z ";
        }

        radar[11][11] = " M ";

        // Отрисовка.
        for (int l = 0; l < 23; l++) {
            for (int r = 0; r < 23; r++) {
                System.out.print(radar[l][r]);
            }
            System.out.println();
        }
    }
}
