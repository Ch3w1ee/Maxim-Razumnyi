import java.util.Scanner;

public class Javapractice8_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите строку:");
        String s = sc.nextLine();
        String[] w = s.split(" ");
        String min = w[0];
        String max = w[0];
        for(int i=0;i<w.length;i++){
            if(w[i].length()>max.length()) max=w[i];
            if(w[i].length()<min.length()) min=w[i];
        }
        System.out.println("Максимальное: " + max + " (" + max.length() + ")");
        System.out.println("Минимальное: " + min + " (" + min.length() + ")");
    }
}
