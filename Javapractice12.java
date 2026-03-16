import java.io.*;
import java.util.Scanner;

public class Javapractice12 {

    static Scanner scanner = new Scanner(System.in);
    static String fileName = "text.txt";

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n--- МЕНЮ ---");
            System.out.println("1 - Додати рядки у файл");
            System.out.println("2 - Прочитати весь файл");
            System.out.println("3 - Прочитати дiапазон рядкiв");
            System.out.println("4 - Вставити рядок у позицiю");
            System.out.println("5 - Вийти");
            System.out.print("Ваш вибiр: ");

            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                writeLines();
            } else if (choice.equals("2")) {
                readFile();
            } else if (choice.equals("3")) {
                readRange();
            } else if (choice.equals("4")) {
                insertLine();
            } else if (choice.equals("5")) {
                System.out.println("Вихiд.");
                break;
            } else {
                System.out.println("Невiрний вибiр.");
            }
        }
    }

    public static void writeLines() {

        System.out.println("Вводьте рядки (порожнiй рядок - завершити)");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {

            while (true) {

                String text = scanner.nextLine();

                if (text.equals("")) {
                    break;
                }

                writer.write(text);
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("Помилка запису у файл.");
        }
    }

    public static void readFile() {

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            String line;
            int number = 1;

            System.out.println("\n--- ВМIСТ ФАЙЛУ ---");

            while ((line = reader.readLine()) != null) {
                System.out.println(number + ": " + line);
                number++;
            }

        } catch (IOException e) {
            System.out.println("Помилка читання файлу.");
        }
    }

    public static void readRange() {

        System.out.print("Початковий рядок: ");
        int start = Integer.parseInt(scanner.nextLine());

        System.out.print("Кiнцевий рядок: ");
        int end = Integer.parseInt(scanner.nextLine());

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            String line;
            int number = 1;

            while ((line = reader.readLine()) != null) {

                if (number >= start && number <= end) {
                    System.out.println(number + ": " + line);
                }

                number++;
            }

        } catch (IOException e) {
            System.out.println("Помилка читання.");
        }
    }

    public static void insertLine() {

        System.out.print("В який рядок вставити: ");
        int pos = Integer.parseInt(scanner.nextLine());

        System.out.print("Введiть текст: ");
        String newLine = scanner.nextLine();

        String[] lines = new String[1000];
        int count = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            String line;

            while ((line = reader.readLine()) != null) {
                lines[count] = line;
                count++;
            }

        } catch (IOException e) {
            System.out.println("Помилка читання.");
            return;
        }

        if (pos < 1) pos = 1;
        if (pos > count + 1) pos = count + 1;

        for (int i = count; i >= pos; i--) {
            lines[i] = lines[i - 1];
        }

        lines[pos - 1] = newLine;
        count++;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {

            for (int i = 0; i < count; i++) {
                writer.write(lines[i]);
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("Помилка запису.");
        }
    }
}