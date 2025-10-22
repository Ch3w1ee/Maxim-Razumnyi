import java.util.Scanner;

public class task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите текст:");
        String text = sc.nextLine();

        int count = 0;
        int i = 0;

        while (i < text.length()) {
            char ch = text.charAt(i);
            if (ch == '.' || ch == '!' || ch == '?') {
                count++;
            }
            i++;
        }

        int j = 0;
        int count2 = 0;
        do {
            if (j < text.length()) {
                char ch = text.charAt(j);
                if (ch == '.' || ch == '!' || ch == '?') {
                    count2++;
                }
                j++;
            }
        } while (j < text.length());

        System.out.println("Количество предложений (while): " + count);
        System.out.println("Количество предложений (do-while): " + count2);

        sc.close();
    }
}