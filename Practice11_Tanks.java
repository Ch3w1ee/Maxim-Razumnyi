import java.util.Scanner;

class InvalidMenuChoiceException extends Exception {
    public InvalidMenuChoiceException(String message) {
        super(message);
    }
}

class InvalidCommandException extends Exception {
    public InvalidCommandException(String message) {
        super(message);
    }
}

class OutOfFieldException extends Exception {
    public OutOfFieldException(String message) {
        super(message);
    }
}

class BulletAlreadyActiveException extends Exception {
    public BulletAlreadyActiveException(String message) {
        super(message);
    }
}

public class Practice11_Tanks {

    static Scanner scanner = new Scanner(System.in);

    static char[][][] levels = {
            {
                    {'#','#','#','#','#','#','#','#','#','#','#','#','#','#'},
                    {'#','T',' ',' ',' ','#',' ',' ',' ',' ',' ','E',' ','#'},
                    {'#',' ','#','#',' ','#',' ','#','#','#',' ',' ',' ','#'},
                    {'#',' ',' ',' ',' ',' ',' ',' ',' ','#',' ','#',' ','#'},
                    {'#',' ','#','#','#','#',' ','#',' ','#',' ','#',' ','#'},
                    {'#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#'},
                    {'#','#','#','#','#','#','#','#','#','#','#','#','#','#'}
            }
    };

    static char[][] field;
    static int tankX, tankY;
    static int lives = 3;

    static int bulletX, bulletY;
    static boolean bulletActive;

    public static void main(String[] args) {

        while (true) {
            try {
                System.out.println("\n=== ТАНЧИКИ ===");
                System.out.println("1. Почати гру");
                System.out.println("2. Вихiд");
                System.out.print("Вибiр: ");

                String input = scanner.nextLine();

                if (input.length() == 0)
                    throw new InvalidMenuChoiceException("Вибiр не може бути порожнiм!");

                if (!input.equals("1") && !input.equals("2"))
                    throw new InvalidMenuChoiceException("Неправильний пункт меню!");

                if (input.equals("1")) startGame();
                if (input.equals("2")) break;

            } catch (InvalidMenuChoiceException e) {
                System.out.println("❌ " + e.getMessage());
            }
        }
    }

    static void startGame() {

        loadLevel(0);

        while (true) {
            try {
                drawField();
                System.out.println("Життя: " + lives);
                System.out.print("Команда (w/a/s/d/f/q): ");

                String cmd = scanner.nextLine();

                if (cmd.length() == 0)
                    throw new InvalidCommandException("Команда не може бути порожньою!");

                cmd = cmd.toLowerCase();

                if (!cmd.equals("w") && !cmd.equals("a") &&
                        !cmd.equals("s") && !cmd.equals("d") &&
                        !cmd.equals("f") && !cmd.equals("q"))
                    throw new InvalidCommandException("Невiдома команда!");

                if (cmd.equals("q")) return;

                moveTank(cmd);
                moveBullet();

                if (lives <= 0) {
                    System.out.println("💀 Гра завершена!");
                    return;
                }

            } catch (InvalidCommandException |
                     OutOfFieldException |
                     BulletAlreadyActiveException e) {

                System.out.println("❌ " + e.getMessage());
            }
        }
    }

    static void loadLevel(int n) {
        field = new char[levels[n].length][levels[n][0].length];

        for (int y = 0; y < field.length; y++) {
            for (int x = 0; x < field[y].length; x++) {
                field[y][x] = levels[n][y][x];
                if (field[y][x] == 'T') {
                    tankX = x;
                    tankY = y;
                    field[y][x] = ' ';
                }
            }
        }
        bulletActive = false;
    }

    static void drawField() {
        System.out.println();
        for (int y = 0; y < field.length; y++) {
            for (int x = 0; x < field[y].length; x++) {
                if (x == tankX && y == tankY)
                    System.out.print('T');
                else if (bulletActive && x == bulletX && y == bulletY)
                    System.out.print('*');
                else
                    System.out.print(field[y][x]);
            }
            System.out.println();
        }
    }

    static void moveTank(String cmd)
            throws OutOfFieldException, BulletAlreadyActiveException {

        int nx = tankX;
        int ny = tankY;

        if (cmd.equals("w")) ny--;
        if (cmd.equals("s")) ny++;
        if (cmd.equals("a")) nx--;
        if (cmd.equals("d")) nx++;

        if (cmd.equals("f")) {
            if (bulletActive)
                throw new BulletAlreadyActiveException("Куля вже летить!");
            bulletX = tankX + 1;
            bulletY = tankY;
            bulletActive = true;
            return;
        }

        if (nx < 0 || ny < 0 ||
                ny >= field.length ||
                nx >= field[0].length)
            throw new OutOfFieldException("Не можна виходити за межi поля!");

        if (field[ny][nx] != '#') {
            tankX = nx;
            tankY = ny;
        }
    }

    static void moveBullet() {

        if (!bulletActive) return;

        bulletX++;

        if (bulletX >= field[0].length ||
                field[bulletY][bulletX] == '#') {
            bulletActive = false;
            return;
        }

        if (field[bulletY][bulletX] == 'E') {
            field[bulletY][bulletX] = ' ';
            bulletActive = false;
        }
    }
}