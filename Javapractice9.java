import java.util.Scanner;

public class Javapractice9 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String text = inputString();

        System.out.println("Выберите действие:");
        System.out.println("1 - Перевернуть всю строку");
        System.out.println("2 - Перевернуть каждое слово");

        int choice = sc.nextInt();
        sc.nextLine();

        if (choice == 1) {
            System.out.println("Результат:");
            System.out.println(reverseString(text));
        } else if (choice == 2) {
            System.out.println("Результат:");
            System.out.println(reverseWords(text));
        } else {
            System.out.println("Неверный выбор");
        }
    }

    public static String inputString() {
        while (true) {
            System.out.println("Введите строку (минимум 2 слова, каждое не короче 3 символов):");
            String line = sc.nextLine();
            String[] words = line.split(" ");

            if (words.length >= 2) {
                boolean ok = true;
                for (int i = 0; i < words.length; i++) {
                    if (words[i].length() < 3) {
                        ok = false;
                        break;
                    }
                }
                if (ok) {
                    return line;
                }
            }
            System.out.println("Строка введена неверно, попробуйте еще раз");
        }
    }

    public static String reverseString(String s) {
        String result = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            result = result + s.charAt(i);
        }
        return result;
    }

    public static String reverseWords(String s) {
        String[] words = s.split(" ");
        String result = "";

        for (int i = 0; i < words.length; i++) {
            String word = "";
            for (int j = words[i].length() - 1; j >= 0; j--) {
                word = word + words[i].charAt(j);
            }
            result = result + word;
            if (i < words.length - 1) {
                result = result + " ";
            }
        }
        return result;
    }
}
