import java.util.Scanner;

class UserLimitException extends Exception {
    public UserLimitException(String message) {
        super(message);
    }
}

class UserNotFoundException extends Exception {
    public UserNotFoundException(String message) {
        super(message);
    }
}

class ValidationException extends Exception {
    public ValidationException(String message) {
        super(message);
    }
}

public class Javapractice10 {

    static final int MAX_USERS = 15;
    static String[] usernames = new String[MAX_USERS];
    static String[] passwords = new String[MAX_USERS];
    static int userCount = 0;

    static String[] bannedWords = {"admin", "pass", "password", "qwerty", "ytrewq"};
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            try {
                showMenu();
                int choice = Integer.parseInt(scanner.nextLine());

                if (choice == 1) {
                    registerUser();
                } else if (choice == 2) {
                    deleteUser();
                } else if (choice == 3) {
                    authenticateUser();
                } else if (choice == 4) {
                    addBannedPassword();
                } else if (choice == 0) {
                    System.out.println("Программа завершена.");
                    break;
                } else {
                    System.out.println("Неверный пункт меню.");
                }

            } catch (Exception e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
    }

    static void showMenu() {
        System.out.println("\n1 - Добавить пользователя");
        System.out.println("2 - Удалить пользователя");
        System.out.println("3 - Выполнить действие (вход)");
        System.out.println("4 - Добавить запрещённый пароль");
        System.out.println("0 - Выход");
        System.out.print("Выберите пункт: ");
    }

    static void registerUser() throws Exception {

        if (userCount >= MAX_USERS) {
            throw new UserLimitException("Достигнут лимит пользователей (15).");
        }

        System.out.print("Введите имя пользователя: ");
        String username = scanner.nextLine();
        validateUsername(username);

        if (findUser(username) != -1) {
            throw new ValidationException("Пользователь уже существует.");
        }

        System.out.print("Введите пароль: ");
        String password = scanner.nextLine();
        validatePassword(password);

        usernames[userCount] = username;
        passwords[userCount] = password;
        userCount++;

        System.out.println("Пользователь успешно зарегистрирован.");
    }

    static void deleteUser() throws Exception {
        System.out.print("Введите имя пользователя для удаления: ");
        String username = scanner.nextLine();

        int index = findUser(username);

        if (index == -1) {
            throw new UserNotFoundException("Пользователь не найден.");
        }

        usernames[index] = null;
        passwords[index] = null;

        System.out.println("Пользователь удалён.");
    }

    static void authenticateUser() throws Exception {
        System.out.print("Введите имя: ");
        String username = scanner.nextLine();

        System.out.print("Введите пароль: ");
        String password = scanner.nextLine();

        int index = findUser(username);

        if (index == -1) {
            throw new UserNotFoundException("Пользователь не найден.");
        }

        if (!passwords[index].equals(password)) {
            throw new ValidationException("Неверный пароль.");
        }

        System.out.println("Пользователь успешно аутентифицирован.");
    }

    static int findUser(String username) {
        for (int i = 0; i < MAX_USERS; i++) {
            if (usernames[i] != null && usernames[i].equals(username)) {
                return i;
            }
        }
        return -1;
    }

    static void validateUsername(String username) throws ValidationException {

        if (username.length() < 5) {
            throw new ValidationException("Имя должно быть не менее 5 символов.");
        }

        if (username.contains(" ")) {
            throw new ValidationException("Имя не должно содержать пробелы.");
        }
    }

    static void validatePassword(String password) throws ValidationException {

        if (password.length() < 10) {
            throw new ValidationException("Пароль должен быть не менее 10 символов.");
        }

        if (password.contains(" ")) {
            throw new ValidationException("Пароль не должен содержать пробелы.");
        }

        int digitCount = 0;
        boolean hasSpecial = false;

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);

            if (Character.isDigit(c)) {
                digitCount++;
            }

            if (!Character.isLetterOrDigit(c)) {
                hasSpecial = true;
            }

            if (!(Character.isLetterOrDigit(c))) {
                if (!isAllowedSpecial(c)) {
                    throw new ValidationException("Недопустимый символ в пароле.");
                }
            }
        }

        if (digitCount < 3) {
            throw new ValidationException("Пароль должен содержать минимум 3 цифры.");
        }

        if (!hasSpecial) {
            throw new ValidationException("Пароль должен содержать спецсимвол.");
        }

        for (int i = 0; i < bannedWords.length; i++) {
            if (password.toLowerCase().contains(bannedWords[i])) {
                throw new ValidationException("Пароль содержит запрещённое слово.");
            }
        }
    }

    static boolean isAllowedSpecial(char c) {
        String allowed = "!@#$%^&*()-_=+";
        return allowed.indexOf(c) != -1;
    }

    static void addBannedPassword() {
        System.out.print("Введите запрещённое слово: ");
        String newWord = scanner.nextLine();

        String[] newArray = new String[bannedWords.length + 1];

        for (int i = 0; i < bannedWords.length; i++) {
            newArray[i] = bannedWords[i];
        }

        newArray[bannedWords.length] = newWord.toLowerCase();
        bannedWords = newArray;

        System.out.println("Запрещённое слово добавлено.");
    }
}