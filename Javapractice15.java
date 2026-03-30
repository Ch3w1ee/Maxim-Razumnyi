import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Javapractice15 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int MAX = 50;

        String[] dates = new String[MAX]; // зберiгаємо дату у єдиному форматi
        String[] texts = new String[MAX];

        int count = 0;

        String savePath = "";
        DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        DateTimeFormatter saveFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        DateTimeFormatter displayFormat = chooseDisplayFormat(sc);

        System.out.println("1 - Створити новий щоденник");
        System.out.println("2 - Вiдкрити iснуючий щоденник");
        System.out.print("Ваш вибiр: ");

        int startChoice;
        try {
            startChoice = Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            startChoice = 1;
        }

        if (startChoice == 2) {
            System.out.print("Введiть шлях до файлу: ");
            savePath = sc.nextLine();

            int loaded = loadDiary(savePath, dates, texts, MAX);
            if (loaded >= 0) {
                count = loaded;
                System.out.println("Щоденник успiшно завантажено!");
            } else {
                System.out.println("Не вдалося завантажити файл. Буде створено новий щоденник.");
                count = 0;
                savePath = "";
            }
        } else {
            System.out.println("Створено новий щоденник.");
        }

        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1 - Додати запис");
            System.out.println("2 - Видалити запис за датою i часом");
            System.out.println("3 - Переглянути всi записи");
            System.out.println("4 - Змiнити формат вiдображення дати");
            System.out.println("0 - Вийти");
            System.out.print("Ваш вибiр: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                choice = -1;
            }

            if (choice == 1) {
                if (count >= MAX) {
                    System.out.println("Щоденник заповнений!");
                    continue;
                }

                System.out.print("Введiть дату i час у форматi yyyy-MM-dd HH:mm: ");
                String dateInput = sc.nextLine();

                try {
                    LocalDateTime dt = LocalDateTime.parse(dateInput, inputFormat);
                    String savedDate = dt.format(saveFormat);

                    System.out.print("Введiть текст запису: ");
                    String text = sc.nextLine();

                    dates[count] = savedDate;
                    texts[count] = text;
                    count++;

                    System.out.println("Запис додано!");
                } catch (Exception e) {
                    System.out.println("Помилка! Дату i час введено неправильно.");
                }

            } else if (choice == 2) {
                if (count == 0) {
                    System.out.println("Щоденник порожнiй.");
                    continue;
                }

                System.out.print("Введiть дату i час запису для видалення у форматi yyyy-MM-dd HH:mm: ");
                String deleteInput = sc.nextLine();

                boolean found = false;

                try {
                    LocalDateTime dt = LocalDateTime.parse(deleteInput, inputFormat);
                    String deleteDate = dt.format(saveFormat);

                    for (int i = 0; i < count; i++) {
                        if (dates[i].equals(deleteDate)) {
                            for (int j = i; j < count - 1; j++) {
                                dates[j] = dates[j + 1];
                                texts[j] = texts[j + 1];
                            }

                            dates[count - 1] = null;
                            texts[count - 1] = null;
                            count--;

                            found = true;
                            System.out.println("Запис видалено!");
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Запис не знайдено!");
                    }
                } catch (Exception e) {
                    System.out.println("Помилка! Дату i час введено неправильно.");
                }

            } else if (choice == 3) {
                if (count == 0) {
                    System.out.println("Щоденник порожнiй.");
                } else {
                    for (int i = 0; i < count; i++) {
                        try {
                            LocalDateTime dt = LocalDateTime.parse(dates[i], saveFormat);
                            System.out.println("\nЗапис №" + (i + 1));
                            System.out.println("Дата: " + dt.format(displayFormat));
                            System.out.println("Текст: " + texts[i]);
                        } catch (Exception e) {
                            System.out.println("\nЗапис №" + (i + 1));
                            System.out.println("Дата: " + dates[i]);
                            System.out.println("Текст: " + texts[i]);
                        }
                    }
                }

            } else if (choice == 4) {
                displayFormat = chooseDisplayFormat(sc);

            } else if (choice == 0) {
                System.out.print("Бажаєте зберегти щоденник? (так/нi): ");
                String answer = sc.nextLine();

                if (answer.equalsIgnoreCase("так")) {
                    System.out.print("Введiть шлях до файлу: ");
                    String path = sc.nextLine();

                    boolean ok = saveDiary(path, dates, texts, count);
                    if (ok) {
                        System.out.println("Щоденник збережено!");
                    } else {
                        System.out.println("Помилка пiд час збереження.");
                    }
                }

                System.out.println("Вихiд...");
                break;

            } else {
                System.out.println("Некоректний вибiр!");
            }
        }

        sc.close();
    }

    public static DateTimeFormatter chooseDisplayFormat(Scanner sc) {
        while (true) {
            System.out.println("\nОберiть формат вiдображення дати:");
            System.out.println("1 - dd.MM.yyyy HH:mm");
            System.out.println("2 - yyyy-MM-dd HH:mm");
            System.out.println("3 - dd/MM/yyyy HH:mm");
            System.out.println("4 - Ввести свiй формат");
            System.out.print("Ваш вибiр: ");

            String choice = sc.nextLine();

            if (choice.equals("1")) {
                return DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
            } else if (choice.equals("2")) {
                return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            } else if (choice.equals("3")) {
                return DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            } else if (choice.equals("4")) {
                System.out.print("Введiть свiй формат: ");
                String pattern = sc.nextLine();

                try {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
                    LocalDateTime now = LocalDateTime.now();
                    now.format(formatter); // перевiрка
                    return formatter;
                } catch (Exception e) {
                    System.out.println("Неправильний формат! Спробуйте ще раз.");
                }
            } else {
                System.out.println("Некоректний вибiр!");
            }
        }
    }

    public static boolean saveDiary(String path, String[] dates, String[] texts, int count) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(path));

            for (int i = 0; i < count; i++) {
                writer.println(dates[i]);
                writer.println(texts[i]);
                writer.println();
            }

            writer.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static int loadDiary(String path, String[] dates, String[] texts, int MAX) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));

            int count = 0;

            while (true) {
                String date = reader.readLine();
                if (date == null) {
                    break;
                }

                String text = reader.readLine();
                if (text == null) {
                    break;
                }

                if (count < MAX) {
                    dates[count] = date;
                    texts[count] = text;
                    count++;
                }

                reader.readLine(); // пропускаємо порожнiй рядок
            }

            reader.close();
            return count;
        } catch (Exception e) {
            return -1;
        }
    }
}