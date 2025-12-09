import java.util.Scanner;

public class Javapractice8_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите строку:");
        String s = sc.nextLine();
        String rev = "";
        for(int i=s.length()-1;i>=0;i--) rev+=s.charAt(i);
        if(s.equalsIgnoreCase(rev)) System.out.println("Это палиндром");
        else System.out.println("Это не палиндром");
    }
}
