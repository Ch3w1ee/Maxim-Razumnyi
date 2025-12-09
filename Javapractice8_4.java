import java.util.Scanner;

public class Javapractice8_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите строку:");
        String s = sc.nextLine();
        String res = "";
        boolean up = false;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c==' ' || c=='-'){
                up = true;
            }else{
                if(up){
                    res += Character.toUpperCase(c);
                    up = false;
                }else{
                    res += Character.toLowerCase(c);
                }
            }
        }
        System.out.println("Результат: " + res);
    }
}
