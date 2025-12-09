import java.util.Scanner;

public class Javapractice8_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите строку:");
        String s = sc.nextLine();
        String r = "";
        for(int i=s.length()-1;i>=0;i--) r+=s.charAt(i);
        System.out.println("Результат: " + r);
    }
}
