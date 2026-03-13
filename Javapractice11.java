import java.io.*;
import java.util.Scanner;

public class Javapractice11 {

    static Scanner scanner = new Scanner(System.in);
    static String fileName = "text.txt";

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n--- МЕНЮ ---");
            System.out.println("1 - Записати до файлу");
            System.out.println("2 - Прочитати файл");
            System.out.println("3 - Вийти");
            System.out.print("Ваш вибiр: ");

            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                writeToFile();
            } else if (choice.equals("2")) {
                readFile();
            } else if (choice.equals("3")) {
                System.out.println("Вихiд з програми.");
                break;
            } else {
                System.out.println("Неправильний вибiр.");
            }
        }
    }

    public static void writeToFile() {

        System.out.print("Введiть один рядок: ");
        String text = scanner.nextLine();

        try {
            FileWriter writer = new FileWriter(fileName, true);
            writer.write(text + "\n");
            writer.close();

            System.out.println("Рядок записано у файл.");

        } catch (IOException e) {
            System.out.println("Помилка запису у файл.");
        }
    }

    public static void readFile() {

        try {
            File file = new File(fileName);

            if (!file.exists()) {
                System.out.println("Файл ще не створений.");
                return;
            }

            Scanner fileScanner = new Scanner(file);

            System.out.println("\n--- ВМIСТ ФАЙЛУ ---");

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                System.out.println(line);
            }

            fileScanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Помилка читання файлу.");
        }
    }
}