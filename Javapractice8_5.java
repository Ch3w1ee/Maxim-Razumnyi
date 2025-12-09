import java.util.Scanner;

public class Javapractice8_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите текст:");
        String text = sc.nextLine().toLowerCase();

        String[] bad = {
                "fuck",
                "bitch",
                "nigga",
                "nigger",
                "fucking",
                "condom",
                "dick",
                "faggot",
                "morron",
                "shut up"
        };

        for (int i = 0; i < bad.length; i++) {
            if (text.contains(bad[i])) {
                String stars = "***";
                text = text.replace(bad[i], stars);
            }
        }

        System.out.println("Результат:");
        System.out.println(text);
    }
}
